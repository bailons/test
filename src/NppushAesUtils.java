import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.*;
import java.util.concurrent.*;

public class NppushAesUtils {
    // 算法名称
    private static final String KEY_ALGORITHM = "AES";
    // 加解密算法/模式/填充方式
    private static final String algorithmStr = "AES/CBC/PKCS7Padding";

    private static Cipher decipher;

    private static Cipher encipher;

    private static Map cipherMap = new ConcurrentHashMap();

    private static String enInitLock = "enInitLock";
    private static String deInitLock = "deInitLock";

    public static void encryptInit(String appSecret) {
        byte[] keyBytes = appSecret.getBytes();
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        Key enkey = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            Cipher encipher = Cipher.getInstance(algorithmStr, "BC");
            encipher.init(Cipher.ENCRYPT_MODE, enkey, new IvParameterSpec(appSecret.substring(0, 16).getBytes()));
            cipherMap.put(appSecret, encipher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptInit(String appSecret) {
        byte[] keyBytes = appSecret.getBytes();
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        Key dekey = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            Cipher decipher = Cipher.getInstance(algorithmStr, "BC");
            decipher.init(Cipher.DECRYPT_MODE, dekey, new IvParameterSpec(appSecret.substring(0, 16).getBytes()));
            cipherMap.put(appSecret, decipher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * AES加密
     *
     * @param content   加密内容
     * @param appSecret 平台秘钥
     * @return
     */
    public static String encrypt(String content, String appSecret) {
        byte[] encryptedText = null;
        try {
            if (!cipherMap.containsKey(appSecret)) {
                synchronized (enInitLock) {
                    if (!cipherMap.containsKey(appSecret)) {
                        encryptInit(appSecret);
                    }
                }
            }
            encipher = (Cipher) cipherMap.get(appSecret);
            synchronized (KEY_ALGORITHM) {
                encryptedText = encipher.doFinal(content.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encryptedText);
    }

    /**
     * AES解密
     *
     * @param content   加密内容
     * @param appSecret 平台秘钥
     * @return
     */
    public static String decrypt(String content, String appSecret) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(content);
        byte[] encryptedText = null;
        try {
            if (!cipherMap.containsKey(appSecret)) {
                synchronized (deInitLock) {
                    if (!cipherMap.containsKey(appSecret)) {
                        decryptInit(appSecret);
                    }
                }
            }
            decipher = (Cipher) cipherMap.get(appSecret);
            synchronized (algorithmStr) {
                encryptedText = decipher.doFinal(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(encryptedText);
    }

    public static void main(String[] args) throws Exception {
		/*String appSecret = NppushAesUtils.getAppSecret();
		String str = NppushAesUtils.encrypt("610425199310290917", appSecret);
		System.out.println(str);
		System.out.println(NppushAesUtils.decrypt(str, appSecret));*/

        long start = System.currentTimeMillis();
        testTask();
        System.out.println("共用了=====" + (System.currentTimeMillis() - start));
    }

    public static void testTask() throws Exception {
        int num = 1000;
        ExecutorService exec = Executors.newCachedThreadPool();
        CompletionService<String> execcomp = new ExecutorCompletionService<String>(exec);
        List<String> list = new Vector();
        for (int i = 0; i < num; i++) {
            Callable<String> callable = getTask();
            execcomp.submit(callable);
        }
        for (int i = 0; i < num; i++) {
            Future<String> future = execcomp.take();
            String faceBean = future.get();
            list.add(faceBean);
        }
        exec.shutdown();
        System.out.println("Totle num is : " + list.size());
        System.out.println(new HashSet<>(list).size() + "----->" + new HashSet<>(list).toString());
    }

    public static Callable<String> getTask() {
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() {
                String appSecret = "CN_UPLOAD_APP_SECRET";
                return NppushAesUtils.decrypt("pnNXxwXhTwsEuB4Dn8/RJX3UF/EG8HnkFfh3N45PQ8k=", appSecret);
            }
        };
        return task;
    }
}

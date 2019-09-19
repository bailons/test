package bank.common;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {


    public static List<String[]> readTxt(String filePath) {
        if (null == filePath) {
            throw new IllegalArgumentException("参数不能为空");
        }
        List<String[]> records = new LinkedList<>();
        InputStreamReader isr=null;
        BufferedReader br=null;
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    String[] arrStrings = lineTxt.split("\\|");
                    records.add(arrStrings);
                }
                br.close();
                isr.close();
                return records;
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!" + e.getMessage());
        }
        return records;
    }

    /**
     * 写入文件内容
     */
    public static void writeFile(File filename, StringBuffer content) throws IOException {
        // 文件输出流
        FileOutputStream outstream = null;
        PrintWriter write = null;

        // 文件输入流
        FileInputStream inputstream = null;
        // 字符流读取
        BufferedReader buffer = null;
        // 字节流读取
        InputStreamReader readerstream = null;

        String temp = "";
        StringBuffer buf = new StringBuffer();

        try {
            inputstream = new FileInputStream(filename);
            readerstream = new InputStreamReader(inputstream, "utf-8");
            buffer = new BufferedReader(readerstream);
            for (int j = 1; (temp = buffer.readLine()) != null; j++) {
                buf = buf.append(temp);
                buf = buf.append("\n");
            }
            buf.append(content);
            outstream = new FileOutputStream(filename);
            write = new PrintWriter(outstream);
            write.write(buf.toString().toCharArray());
            write.flush();

        } finally {
            if (write != null) {
                write.close();
            }
            if (outstream != null) {
                outstream.close();
            }
            if (readerstream != null) {
                readerstream.close();
            }
            if (buffer != null) {
                buffer.close();
            }
            if (inputstream != null) {
                inputstream.close();
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName
     *            被删除文件的文件名
     * @return 单个文件删除成功返回true,否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }

    public static int getFileLineCount(String filename) {
        int cnt = 0;
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(filename));
            @SuppressWarnings("unused")
            String lineRead = "";
            while ((lineRead = reader.readLine()) != null) {
            }
            cnt = reader.getLineNumber();
        } catch (Exception ex) {
            cnt = -1;
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt + 1;
    }
}

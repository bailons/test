package waitNotifyExample;

/**
 * @ClassName DBTools
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 0031 16:17
 * @Version 1.0
 **/
public class DBTools {
    volatile private boolean prevIsA = false;
    synchronized public void backupA() {
        try {
            while (prevIsA == true) {
                wait();
            }
            for(int i=0;i<5;i++){
                System.out.println("★★★★★");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void backupB() {
        try {
            while (prevIsA == false) {
                wait();
            }
            for(int i=0;i<5;i++){
                System.out.println("✰✰✰✰✰");
            }
            prevIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package waitNotifyExample;

/**
 * @ClassName Main
 * @Description 20个线程备份A库，20个线程备份B库，交叉进行(volatile)
 * @Author leibailong
 * @Date 2018/10/31 0031 16:23
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DBTools dbTools = new DBTools();
        for(int i=0;i<20;i++){
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }
}

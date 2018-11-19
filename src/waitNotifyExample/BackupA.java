package waitNotifyExample;

/**
 * @ClassName BackupA
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 0031 16:21
 * @Version 1.0
 **/
public class BackupA extends Thread {
    private DBTools dbTools;
    public BackupA(DBTools dbTools){
        super();
        this.dbTools = dbTools;
    }
    @Override
    public void run(){
        dbTools.backupA();
    }
}

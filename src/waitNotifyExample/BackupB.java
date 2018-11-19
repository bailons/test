package waitNotifyExample;

/**
 * @ClassName BackupB
 * @Description TODO
 * @Author leibailong
 * @Date 2018/10/31 0031 16:22
 * @Version 1.0
 **/
public class BackupB extends Thread {
    private DBTools dbTools;
    public BackupB(DBTools dbTools){
        super();
        this.dbTools = dbTools;
    }
    @Override
    public void run(){
        dbTools.backupB();
    }
}

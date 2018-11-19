package threadPool;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/13 11:43
 * @Version 1.0
 **/
public class MyTask implements Runnable{
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
           Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}

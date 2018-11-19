package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Description 线程池使用例子:从执行结果可以看出，当线程池中线程的数目大于5时，
 * 便将任务放入任务缓存队列里面，当任务缓存队列满了之后，便创建新的线程。如果上面程序中，将for循环中改成执行20个任务，
 * 就会抛出任务拒绝异常了。
 * @Author leibailong
 * @Date 2018/11/13 11:42
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        //线程池的基本大小,线程池最大数量,线程活动保持时间(线程池的工作线程空闲后，保持存活的时间),
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

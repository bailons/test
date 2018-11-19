package train.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName Main
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 16:22
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Ticket ticket = new Ticket(100);
        int people=10;
        Buy buy = new Buy(ticket,lock);
        BuyThread buyThread = new BuyThread(buy);
        Thread[] threads = new Thread[people];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(buyThread);
            threads[i].setName("购买者"+i);
            threads[i].start();
        }
    }
}

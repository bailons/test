package train.ticket;

/**
 * @ClassName Buy
 * @Description TODO
 * @Author leibailong
 * @Date 2018/11/1 0001 17:00
 * @Version 1.0
 **/
public class Buy {
    private Ticket ticket;
    private String lock;

    public Buy(Ticket ticket, String lock) {
        this.lock = lock;
        this.ticket = ticket;
    }

    public void buy() {
        try {
            synchronized (lock) {
                while (ticket.getTotal() > 0) {
                    int num = ticket.getTotal();
                    num--;
                    System.out.println(Thread.currentThread().getName() + "买了1张票;还剩" + num + "张票!");
                    ticket.setTotal(num);
                    lock.wait(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

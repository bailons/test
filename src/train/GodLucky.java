//设计一个图形化界面的随机抽奖程序,用户单击开始进行滚动抽奖，单击停止即可产生1~36之间的7个随机整数

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Administrator
 */
public class GodLucky extends JFrame implements ActionListener {
    JTextField tf;
    JButton b1;
    JButton b2;
    boolean isGo;

    public GodLucky() {
        tf = new JTextField();
        b1 = new JButton("start");
        b2 = new JButton("end");
        b2.setEnabled(false);
        isGo = false;
        b1.setActionCommand("start");
        b2.setActionCommand("end");
        JPanel p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        this.getContentPane().add(tf, "North");
        this.getContentPane().add(p1, "South");

        this.setTitle("随机抽奖程序");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocation(300, 300);

        Cursor cu = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(cu);

        this.setVisible(true);
        tf.setText("--------------welcome you!------------------");
        this.go();
    }

    public static void main(String[] args) {
        new GodLucky();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("start")) {
            isGo = true;
            b1.setEnabled(false);
            b2.setEnabled(true);
        } else if (s.equals("end")) {
            isGo = false;
            b1.setEnabled(true);
            b2.setEnabled(false);
        }
    }

    public void go() {
        while (true) {
            if (isGo) {
                String s = "";
                for (int j = 1; j <= 7; j++) {
                    int i = (int) (Math.random() * 36) + 1;
                    if (i < 10) {
                        s = s + " 0" + i;
                    } else {
                        s = s + " " + i;
                    }
                }
                tf.setText(s);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
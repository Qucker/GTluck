import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.*;


/**
 * 本程序模拟一个从自定范围之间，随机抽取中奖号码的抽奖程序
 * 需要使用Java的图形界面知识
 * 窗口  JFrame
 * 面板  JPanel
 * 显示文本信息的标签  JLabel
 * 文本框 JTextField
 * 按钮  JButton
 *
 * */
public class GoodLuck_1 extends JFrame {
    JPanel pn1=null;
    JPanel pn2;
    JPanel pn3;
    JTextField tf=null;
    JLabel msg=null;
    JButton btn1;
    JButton btn2;
    public int  a,b;
    boolean flag = true;//用于判断是否继续输出出奖号码的标志。

        //在构造器中，初始化界面
    public GoodLuck_1(int a,int b){
        java.net.URL imgURL = GoodLuck_1.class.getResource("pic/ico2.png");
        ImageIcon test = new ImageIcon(imgURL);
        this.setIconImage(test.getImage()); //第二句
        this.a =a;
        this.b=b;
//        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
        // 实例化流式布局类的对象
        this.setLayout(new GridLayout(4,1,10,10));
        ImageIcon icon = new ImageIcon(imgURL);
        // 用标签来接收图片，实例化JLabel标签对象，该对象显示icon图标
        JLabel labIcon = new JLabel(icon);
        //设置标签大小
        //labIcon.setSize(30,20);setSize方法只对窗体有效，如果想设置组件的大小只能用
        Dimension dim = new Dimension(500,100);
        labIcon.setPreferredSize(dim);
        // 将labIcon标签添加到窗体上
        this.add(labIcon);
        tf=new JTextField(40);//参数意思是，该文本框能够放多少个字符
        Dimension dim1 = new Dimension(500,30);
        tf.setPreferredSize(dim1);
        pn1=new JPanel();
        //组件放在面板上
        pn1.add(tf);
        //将面板放在窗口上，当前窗口对象就是this，放在顶部（上北）
        this.add(pn1, BorderLayout.NORTH);
        /*
         * Java的JFrame对象，默然的布局管理器是“边界布局” 类名是BorderLayout
         *
         * */
        msg=new JLabel("<html><body><p align=\"center\">"+"范围从"+a+"到"+b+"<br>"
                +"点击 开始 进行抽奖<br>"
                +"Good Luck!</p><body></html>");
        pn2=new JPanel();
        pn2.add(msg);
        //面板放在窗体上
        this.add(pn2, BorderLayout.CENTER);

        //底部的按钮部分
        btn1=new JButton("开始");

        //给开始按钮加入事件
        btn1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //给出奖标志赋值
                /*
                flag=true;
                chouJiang();
                */
                /*
                 * 必须使用多线程技术，重新启动一个新的线程，去赋值flag
                 * 接着调用chouJiang(), 才可以是程序恢复响应。
                 * */
                class ThreadStart extends Thread {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        //在这里去调用抽奖方法
                        flag=true;
                        chouJiang(a,b);
                    }
                }

                //必须将上面的线程内部类，实例化，之后启动
                new ThreadStart().start();
            }

        });

        btn2=new JButton("停止");

        //给停止按钮添加事件监听
        btn2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //必须启动一个新的停止线程，才能终止无限循环
                class ThreadStop extends Thread{
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        flag=false;
                    }
                }

                //启动上面的内部类线程
                new ThreadStop().start();
            }

        });

        pn3=new JPanel();
        pn3.add(btn1);
        pn3.add(btn2);
        Dimension dimb = new Dimension(500,50);
        pn3.setPreferredSize(dimb);
        this.add(pn3, BorderLayout.SOUTH);

        //设置窗口的属性
        this.setTitle("致同抽奖程序1.0");
        this.setSize(650, 450);
        this.setLocationRelativeTo(null);
        //JFrame默认的关闭按钮，只是隐藏窗口，需要重写设计关闭功能
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //chouJiang();
    }

    //对于一个复杂的任务，首先想到的是封装方法
    public void chouJiang(int a,int b){
        /*
         * 由于开始按钮启动后，什么时候停止，不确定，因此循环次数也不确定
         * 需要使用while循环，而且开始就是无限循环
         * */
        String text="";  //作用是显示在文本框中的号码序列
        while(flag){
            /**
             * 每次循环都是从指定范围之间，随机抽取
             * 显示在文本框中
             * */
            text="";  //每次显示号码时，都重新显示新抽的号码
                int m= new Random().nextInt(b-a + 1) + a;
                text = text +m;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //显示在文本框中
            tf.setText(text);
        }

    }

//    public static void main(String[] args) {
//        //在正在的开发中，main方法中的代码，越少越好。
//        new GoodLuck_1();
//    }

}
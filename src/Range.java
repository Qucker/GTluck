import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFormattedTextField;
import javax.swing.plaf.FontUIResource;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class Range extends JFrame {
    JLabel lbmin = new JLabel("最小值");
    JLabel lbmax = new JLabel("最大值");
    JLabel label1 = new JLabel("请选择待加密或解密的文件：");
    JTextField sourcefile = new JTextField(); // 选择待加密或解密文件路径的文本域
    JButton buttonBrowseSource = new JButton("浏览"); // 浏览按钮
    JButton bt = new JButton("确定");
    JLabel msg = null;
    JPanel jp1 = new JPanel();
    boolean flag = true;
    java.net.URL imgURL = GoodLuck_1.class.getResource("pic/ico2.png");
    ImageIcon icon1 = new ImageIcon(imgURL);  //xxx代表图片存放路径，2.png图片名称及格式
//    java.net.URL imgURL2 = GoodLuck_1.class.getResource("pic/logo2.png");
//    ImageIcon icon2 = new ImageIcon(imgURL2);  //xxx代表图片存放路径，2.png图片名称及格式

    public Range() {
        JFrame frame = new JFrame();
        // 4.设置窗体对象的属性值：标题、大小、显示位置、关闭操作、布局、禁止调整大小、可见、...
        frame.setTitle("致同抽奖系统");// 设置窗体的标题
        frame.setSize(650, 450);// 设置窗体的大小，单位是像素
        frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
        frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);// 设置禁止调整窗体大小
        frame.setIconImage(icon1.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        // 实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐，组件之间的间隔为5个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
        // 实例化流式布局类的对象
        frame.setLayout(fl);

        // 5.实例化元素组件对象，将元素组件对象添加到窗体上（组件添加要在窗体可见之前完成）。
        // 实例化ImageIcon图标类的对象，该对象加载磁盘上的图片文件到内存中，这里的路径要用两个\

        ImageIcon icon = new ImageIcon(imgURL);
        // 用标签来接收图片，实例化JLabel标签对象，该对象显示icon图标
        JLabel labIcon = new JLabel(icon);
        //设置标签大小
        //labIcon.setSize(30,20);setSize方法只对窗体有效，如果想设置组件的大小只能用
        Dimension dim = new Dimension(650, 200);
        labIcon.setPreferredSize(dim);
        // 将labIcon标签添加到窗体上
        frame.add(labIcon);

        frame.add(lbmin);
//        frame.add(label1);

        // 实例化JTextField标签对象
        JFormattedTextField textMin = new JFormattedTextField(new java.text.DecimalFormat("#0"));
        Dimension dim1 = new Dimension(550, 30);
        //textName.setSize(dim);//setSize这方法只对顶级容器有效，其他组件使用无效。
        textMin.setPreferredSize(dim1);//设置除顶级容器组件其他组件的大小
        textMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String old = textMin.getText();
                JFormattedTextField.AbstractFormatter formatter = textMin.getFormatter();
                if (!old.equals("")) {
                    if (formatter != null) {
                        String str = textMin.getText();
                        try {
                            long page = (Long) formatter.stringToValue(str);
                            textMin.setText(page + "");
                        } catch (ParseException pe) {
                            textMin.setText("");//解析异常直接将文本框中值设置为1
                        }
                    }
                }
            }
        });
        frame.add(textMin);
//        JButton

        //实例化JPasswordField
        JFormattedTextField textMax = new JFormattedTextField(new java.text.DecimalFormat("#0"));
        //设置大小
        textMax.setPreferredSize(dim1);//设置组件大小
        //添加textword到窗体上
        textMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String old = textMax.getText();
                JFormattedTextField.AbstractFormatter formatter = textMax.getFormatter();
                if (!old.equals("")) {
                    if (formatter != null) {
                        String str = textMax.getText();
                        try {
                            long page = (Long) formatter.stringToValue(str);
                            textMax.setText(page + "");
                        } catch (ParseException pe) {
                            textMax.setText("");//解析异常直接将文本框中值设置为1
                        }
                    }
                }
            }
        });

        frame.add(textMax);
        //实例化JButton组件
        JButton bt = new JButton();
        //设置按钮的显示内容
        Dimension dim2 = new Dimension(100, 30);
        //设置按钮的大小
        bt.setText("确定");
        bt.setSize(dim2);
        frame.add(bt);

        frame.setVisible(true);// 设置窗体为可见
        RangeController ll = new RangeController(frame, textMin, textMax);
        //对当前窗体添加监听方法
        bt.addActionListener(ll);//监控按钮

    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
        }
        new Range();
            //new Range();
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                try{
////                    UIManager.setLookAndFeel(new SubstanceRavenGraphiteGlassLookAndFeel());//黑
////                    UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());//淡蓝
////                    UIManager.setLookAndFeel(new SubstanceCremeLookAndFeel());//浅色
//                    UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
//                    new Range();//此处初始化自己的组件
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
            //        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);
//
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                //SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
//                try {
//                    UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
//                } catch (UnsupportedLookAndFeelException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}

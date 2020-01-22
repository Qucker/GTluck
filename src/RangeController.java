import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//监听事件
public class RangeController implements ActionListener{

    private javax.swing.JFormattedTextField jt;//账号输入框对象
    private javax.swing.JFormattedTextField jp;//密码输入框对象
    private javax.swing.JFrame Range;//定义一个窗体对象
    public RangeController(javax.swing.JFrame Range,javax.swing.JFormattedTextField jt,javax.swing.JFormattedTextField jp) {
        this.Range=Range;//获取Range界面
        this.jt=jt;//获取登录界面中的min输入框对象
        this.jp=jp;// ;//获取登录界面中的max输入框对象
    }

    public void actionPerformed(ActionEvent e) {
        String textFile2 = jp.getText();
        //利用get方法来获取min和max对象的文本信息，并用equal方法进行判断。最好不要用==，用==这个地方验证不过去。
        if(jt.getText().equals("")&&jt.getText().length()==0||textFile2.equals("")&&jp.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "请输入正确的数字", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int a = Integer.parseInt(jt.getText());
            int b = Integer.parseInt(jp.getText());
            if (a>=b)
            {
                JOptionPane.showMessageDialog(null, "最小值不宜大于等于最大值", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                new GoodLuck_1(a, b);
                // 通过我们获取的登录界面对象，用dispose方法关闭它
                Range.dispose();
            }
            }

        }
    }

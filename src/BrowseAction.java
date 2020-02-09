import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class BrowseAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Range.buttonBrowseSource)) {
            JFileChooser fcDlg = new JFileChooser();
            fcDlg.setDialogTitle("请选择Excel文件...");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件(*.xls;*.xlsx)", "xls", "xlsx");
            fcDlg.setFileFilter(filter);
            int returnVal = fcDlg.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filepath = fcDlg.getSelectedFile().getPath();
//            System.out.println(filepath);
            Range.sourcefile.setText(filepath);
            }
        }
    }
}
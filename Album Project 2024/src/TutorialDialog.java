import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class TutorialDialog extends JFrame {
   TutorialDialog(int  x, int y, String instruction){
       this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
       this.setSize(x, y);
       JTextArea area = new JTextArea(instruction);
       area.setSize(new Dimension(200, 200));
       //JLabel instructions = new JLabel(instruction);
     //  instructions.setBounds(0, 0, 400, 400);
       this.setName("Tutorial");
       Font font = new Font( "Arial",  Font.BOLD, 11);
       area.setFont(font);
       this.add(area, BorderLayout.CENTER);
       this.setVisible(true);
   }

}

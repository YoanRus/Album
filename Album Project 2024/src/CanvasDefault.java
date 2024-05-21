import java.awt.*;
import javax.swing.JFrame;

public class CanvasDefault extends Canvas {
    public void paint(Graphics g) {

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("p3.gif");
        g.drawImage(i, 120,100,this);

    }
}

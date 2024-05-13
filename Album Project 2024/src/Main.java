import java.awt.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Album Organized");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1200);
        JButton Button1 = new JButton("VERTICAL1");
        JButton Button2 = new JButton("VERTICAL2");
        JButton Button3 = new JButton("VERTICAL3");
        frame.add(Button1, BorderLayout.NORTH);
        frame.add(Button3,BorderLayout.NORTH);
        frame.add(Button2);
        Image image = Toolkit.getDefaultToolkit().getImage("Icon.png");
        frame.setIconImage(image);
        frame.setVisible(true);
    }
}

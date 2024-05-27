import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


public class TesterPanel extends JPanel {
    TesterPanel(){
        this.setVisible(true);
        this.setSize(800, 600);
        System.out.println("Drawing");
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //g2.drawLine(0,0,110, 200);
    }
}

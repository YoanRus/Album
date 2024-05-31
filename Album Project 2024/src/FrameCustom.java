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

public class FrameCustom extends Frame {
    public CanvasDefault canvas = new CanvasDefault(false);
    boolean isFilledOut = false;
    String filepath = null;
    String TextFieldOne;
    String TextFieldTwo;
    boolean dialogVisibility = true;
    boolean IsSortedByDate = false;

    FrameCustom() {
        //We are creating the main Frame
        JFrame frame = new JFrame("Album Organized");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 720);
        JButton Button1 = new JButton("Add Image");
        JButton Button2 = new JButton("Delete");
       //  JButton Button3 = new JButton("Upload File");
        JPanel HeaderPane = new JPanel();
        HeaderPane.add(Button1);
        HeaderPane.add(Button2);
       //  HeaderPane.add(Button3);
        HeaderPane.setBackground(Color.BLACK);
        frame.setLayout(null);
        canvas.setLayout(new BorderLayout());
        canvas.add(new Button("Ender"), BorderLayout.SOUTH);
       // canvas.setPreferredSize(new Dimension(1200, 720));
        JScrollPane scrollPane = new JScrollPane(canvas,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 40, 1180, 700);
        frame.add(scrollPane);
        //We are now implimenting a Button to Choose our images
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                JDialog dialog = new JDialog();
                dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                dialog.setSize(400, 400);
                Button ButtonSelectFile = new Button("Select File");

                dialog.add(ButtonSelectFile, BorderLayout.NORTH);
                ButtonSelectFile.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.showOpenDialog(null);
                        filepath = fileChooser.getSelectedFile().getAbsolutePath();
                        System.out.println(filepath);
                    }

                });
                JTextArea field1 = new JTextArea();
                JTextField field2 = new JTextField(20);

                Button buttonSubmit = new Button("Submit");
                dialog.add(field1, BorderLayout.CENTER);
                dialog.add(field2, BorderLayout.SOUTH);
                dialog.add(buttonSubmit, BorderLayout.EAST);
                buttonSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TextFieldOne = field1.getText();
                        TextFieldTwo = field2.getText();
                        if ((field1.getText()!=null)&&(filepath != null)&&(field2.getText()!=null)) {
                            isFilledOut = true;

                        }
                        if(isFilledOut){
                            File file = new File("ImageData");
                            try {
                                FileWriter writer = new FileWriter(file, true);
                                writer.append(filepath);
                                writer.append('\n');
                                writer.append(TextFieldOne);
                                writer.append('\n');
                                writer.append(TextFieldTwo);
                                writer.append('\n');
                                dialogVisibility = false;
                                dialog.setVisible(false);
                                writer.close();

                            }
                            catch(IOException m){
                                System.out.println("FileIsNotFound");
                            }
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });
        //This Button is able to delete the contents of the Album
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter file = new PrintWriter("ImageData");
                    file.close();
                }
                catch(FileNotFoundException f){
                    System.out.println("FileNotFoundException");
                }
            }
        });
        //This is a prototype
        // Button3.addActionListener(new ActionListener() {
            ////public void actionPerforme;d(ActionEvent e) {
             //   canvas = new CanvasDefault(IsSortedByDate);

           // }
        // });
        HeaderPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        HeaderPane.setBounds(0,0, 1200, 40);
        frame.add(HeaderPane);
        frame.setVisible(true);
            Image image = Toolkit.getDefaultToolkit().getImage("Icon.png");
            frame.setIconImage(image);
    }
}

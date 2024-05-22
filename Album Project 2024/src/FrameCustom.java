import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FrameCustom extends Frame {
    boolean isFilledOut = false;
    String filepath = null;
    String TextFieldOne;
    String TextFieldTwo;
    boolean dialogVisibility = true;

    FrameCustom() {
        JFrame frame = new JFrame("Album Organized");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        JButton Button1 = new JButton("Add Image");
        JButton Button2 = new JButton("Catagories");
        JButton Button3 = new JButton("Upload File");
        JPanel panel = new JPanel();

        panel.add(Button1);
        //panel.add(Box.createRigidArea(new Dimension(5, 0)));
        //We can add spaces if we prefer to do so

        panel.add(Button2);
        // panel.add(Box.createRigidArea(new Dimension(5, 0)));

        panel.add(Button3);
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
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner("ImageData");
                try {
                    BufferedImage myPicture = ImageIO.read(new File(scanner.nextLine()));
                    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                    panel.add(picLabel);
                }
                catch(IOException m){
                    System.out.println("FileIsNotFound");
                }
            }
        });
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(panel);
        Image image = Toolkit.getDefaultToolkit().getImage("Icon.png");
        frame.setIconImage(image);
        frame.setVisible(true);
    }


}

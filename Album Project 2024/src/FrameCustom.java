import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class FrameCustom extends Frame {
    boolean isFilledOut = false;
    String filepath = "";
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
                TextFieldOne = field1.getText();
                TextFieldTwo = field1.getText();
                if (field1.getText() != null && field2.getText() != null && filepath != "") {
                    isFilledOut = true;
                    System.out.println("We are on baby");
                }
                Button buttonSubmit = new Button("Submit");
                dialog.add(field1, BorderLayout.CENTER);
                dialog.add(field2, BorderLayout.SOUTH);
                dialog.add(buttonSubmit, BorderLayout.EAST);
                buttonSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(isFilledOut){
                            File file = new File("ImageData");
                            try {
                                FileWriter writer = new FileWriter(file, true);
                                writer.write("NEW");
                                writer.append(filepath);
                                writer.append('\n');
                                writer.append(TextFieldOne);
                                writer.append('\n');
                                writer.append(TextFieldTwo);
                                writer.append('\n');
                                dialogVisibility = false;
                                writer.close();
                            }
                            catch(IOException m){
                                System.out.println("FileIsNotFound");
                            }
                        }
                    }
                });

                if (!dialogVisibility) {
                    dialog.setVisible(false);
                } else {
                    dialog.setVisible(true);
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

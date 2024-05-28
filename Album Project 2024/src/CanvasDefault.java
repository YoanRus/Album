import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CanvasDefault extends JPanel{
    ArrayList<ArrayList<String>> canvasStrings = new ArrayList<>();
    CanvasDefault(boolean sorted){
        File file = new File("ImageData");
        this.setPreferredSize(new Dimension(1200, 720));
        try {
            Scanner scanner = new Scanner(file);

           while (scanner.hasNextLine())
           {
               ArrayList<String> line = new ArrayList<>();
               line.add(scanner.nextLine());
               line.add(scanner.nextLine());
               line.add(scanner.nextLine());
               canvasStrings.add(line);

           }
            scanner.close();
            this.setPreferredSize(new Dimension(1200, 720 + canvasStrings.size()*450));

            //This is the sorting section:
            if(sorted){
                for(int i = 0; i < canvasStrings.size(); i++){
                    for(int j = 0; j < canvasStrings.get(i).size()-i-1; j++){
                        //
                    }
                }
            }

        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
    public void paint(Graphics g) {

         Graphics2D g2d = (Graphics2D) g;
         int x = 100;
         int y = 100;
         g2d.setFont(new Font("Arial", Font.BOLD, 30));
         g2d.setStroke(new BasicStroke(7));
           for(int i = 0; i < canvasStrings.size(); i++){
               Image m = new ImageIcon(canvasStrings.get(i).get(0)).getImage();
               g2d.drawImage(m, x, y, null);
               x += m.getWidth(null)+ 50;
               y += 50;
               g2d.drawString(canvasStrings.get(i).get(1), x, y);
               y += m.getHeight(null);
               x=100;
               g2d.drawString(canvasStrings.get(i).get(2), x, y);
               g2d.drawLine(0, y+50, 1200, y+50);
               y += 150;


           }

    }
}

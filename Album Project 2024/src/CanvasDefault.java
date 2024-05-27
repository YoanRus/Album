import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CanvasDefault extends JPanel{
    ArrayList<ArrayList<String>> canvasStrings = new ArrayList<>();
    CanvasDefault(){
        File file = new File("ImageData");
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
            Dimension b= this.getSize();
            b.height += canvasStrings.size()*500;
            this.setPreferredSize(b);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
    public void paint(Graphics g) {

         Graphics2D g2d = (Graphics2D) g;
         int x = 100;
         int y = 100;
           for(int i = 0; i < canvasStrings.size(); i++){
               Image m = new ImageIcon(canvasStrings.get(i).get(0)).getImage();
               g2d.drawImage(m, x, y, null);
               y += m.getHeight(null)+ 20;
               g2d.drawString(canvasStrings.get(i).get(1), x, y);
               y += 100;
               g2d.drawString(canvasStrings.get(i).get(2), x, y);


           }

    }
}

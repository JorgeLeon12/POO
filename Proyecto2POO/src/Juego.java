import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


import java.awt.Color;
import javax.swing.JPanel;

public class Juego extends JPanel{

	private BufferedImage image;

	public Juego(){
       try {                
          image = ImageIO.read(new File("./Numeros/1.png"));
       } catch (IOException ex) {
            System.out.println("Error con la imagen!");// handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
}
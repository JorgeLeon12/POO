import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.lang.Math;

import java.awt.Color;
import javax.swing.JPanel;

public class Juego extends JPanel{

	private BufferedImage image, image2;
	private int num1, num2;
	private String dificultad = "";

	public Juego(){
		super();		
	}
	
	
	//Accessors o funciones para acceder a una clase... no son precisamente indispensables pero java los ama
	public void setDificultad(String valor) {
		dificultad = valor;
	} 

	public String getDificultad() {
		return dificultad;
	}

	public Juego(String difi){
		dificultad = difi;
		num1 = (int) Math.round((Math.random()*9));
		num2 = (int) Math.round((Math.random()*9));
		String strNum1 = "./Numeros/" + (Integer.toString(num1)) + ".png";
		String strNum2 = "./Numeros/" + (Integer.toString(num2)) + ".png";
		if(dificultad == "Principiante"){
			System.out.println(dificultad);
			try {
				image = ImageIO.read(new File(strNum1));
				image2 = ImageIO.read(new File(strNum2));
			}catch (IOException ex) {
				System.out.println("Error con la imagen");
			}
		}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 250, 250, null);
        g.drawImage(image2, 300,250,null);
    }
}
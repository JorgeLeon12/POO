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

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Juego extends JPanel{

	private BufferedImage imgNum, imgNum2, imgSig, imgInt, imgIgu;
	private int num1, num2, coor1, coor2, coor3;
	private String dificultad = "";
	public JTextField respUsr;

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
		num1 = (int) Math.round((Math.random()*8+1));
		num2 = (int) Math.round((Math.random()*8+1));
		String strNum1 = "./Numeros/" + (Integer.toString(num1)) + ".png";
		String strNum2 = "./Numeros/" + (Integer.toString(num2)) + ".png";

		if(dificultad == "Principiante"){
		}else if(dificultad == "Sencillo"){//----------------------------------Sensillo----------------------------------------------
			System.out.println(dificultad);
			try {
				coor1 = 250;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch (IOException ex) {
				System.out.println("Error con la imgNumn");
			}
		}else if(dificultad == "Retador"){//----------------------------------Retador----------------------------------------------
			System.out.println(dificultad);
			try {
				coor1 = 250;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch (IOException ex) {
				System.out.println("Error con la imgNumn");
			}
		}else if(dificultad == "Avanzado"){//----------------------------------Avanzado----------------------------------------------
			System.out.println(dificultad);
			try {
				coor1 = 250;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch (IOException ex) {
				System.out.println("Error con la imgNumn");
			}
		}else if(dificultad == "DIOS"){//----------------------------------OH GOD WHY!?----------------------------------------------
			System.out.println(dificultad);
			try {
				coor1 = 250;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch (IOException ex) {
				System.out.println("Error con la imgNumn");
			}
		}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgNum, this.coor1, 250, null);
       	g.drawImage(imgNum2, coor2,250,null);
       	g.drawImage(imgSig, coor3,250,null);
    }
}
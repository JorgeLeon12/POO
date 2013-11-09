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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Juego extends JPanel implements ActionListener{

	private BufferedImage imgNum, imgNum2, imgSig, imgInt, imgIgu;
	private int num1, num2, coor1, coor2, coor3, puntuacion;
	private String dificultad = "";
	public JTextField respUsr;
	public JButton enviar;

	public Juego(){
		super();
		this.setLayout(null);
		

		this.setLayout(new BorderLayout());
		JPanel preguntas=new JPanel();

		preguntas.setPreferredSize(new Dimension(800,50));
		preguntas.setLayout(new FlowLayout());
		//preguntas.add(titulo);
		this.add(preguntas, BorderLayout.SOUTH);
	}
	
	public void setDificultad(String valor){
		dificultad = valor;
	} 

	public String getDificultad(){
		return dificultad;
	}

	public Juego(String difi){
		this.dificultad = difi;
		pintarJuego();
	}

	public void pintarJuego(){
		this.num1 = (int)Math.round((Math.random()*8+1));
		this.num2 = (int)Math.round((Math.random()*8+1));
		String strNum1 = "./Numeros/" + (Integer.toString(num1)) + ".png";
		String strNum2 = "./Numeros/" + (Integer.toString(num2)) + ".png";

		if(this.puntuacion == 0){
			respUsr = new JTextField(5);
			respUsr.addActionListener(this);
			respUsr.setLocation(2000,2000);
			this.add(respUsr);

			enviar=new JButton("Validar!");
			enviar.addActionListener(this);
			enviar.setBounds(690,530,100,30);
			this.add(enviar);
		}

		if(this.dificultad == "Principiante"){
		}else if(this.dificultad == "Sencillo"){//----------------------------------Sencillo----------------------------------------------
			System.out.println(dificultad);
			try{
				this.coor1 = 240;
				this.coor2 = 455;
				this.coor3 = 345;
				this.imgNum = ImageIO.read(new File(strNum1));
				this.imgNum2 = ImageIO.read(new File(strNum2));
				this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagenb");
			}
		}else if(dificultad == "Retador"){//----------------------------------Retador----------------------------------------------
			System.out.println(dificultad);
			try{
				coor1 = 240;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen");
			}
		}else if(dificultad == "Avanzado"){//----------------------------------Avanzado----------------------------------------------
			System.out.println(dificultad);
			try{
				coor1 = 240;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen");
			}
		}else if(dificultad == "DIOS"){//----------------------------------OH GOD WHY!?----------------------------------------------
			System.out.println(dificultad);
			try{
				coor1 = 240;
				coor2 = 455;
				coor3 = 345;
				imgNum = ImageIO.read(new File(strNum1));
				imgNum2 = ImageIO.read(new File(strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen");
			}
		}
    }
    public void validarRespuesta(int respuestaUsuario){
    	if(this.dificultad == "Principiante"){
    		//asdasdasd
    	}else{
    		if((this.num1 + this.num2) == respuestaUsuario){
    			this.puntuacion = this.puntuacion + 10;
    			System.out.println("Correcto, la respuesta es " + (this.num1+this.num2) + " y tu puntuacion es de " + this.puntuacion);
    			//respUsr.setText(null);
    			pintarJuego();
    			this.repaint();
    		}else{
    			System.out.println("incorrecto");
    		}
    	}
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(this.imgNum, this.coor1, 250, null);
       	g.drawImage(this.imgNum2, this.coor2, 250, null);
       	g.drawImage(this.imgSig, this.coor3, 250, null);
    }
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(this.respUsr.getText() + " respUsr");
		String respuestaUsuario = this.respUsr.getText();
		System.out.println(respuestaUsuario + " respuestaUsuario");
		
		validarRespuesta(Integer.parseInt((respuestaUsuario)));
	}
}
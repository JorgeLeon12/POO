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

import java.awt.Frame;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Juego extends JPanel implements ActionListener{

	private BufferedImage imgNum, imgNum2, imgSig, imgInt, imgCor;
	private int num1, num2, coor1, coor2, coor3, puntuacion;
	private String dificultad = "", strNum1, strNum2;
	public JTextField respUsr;
	public JButton enviar, reIniciar;

	public Juego(){
		super();
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

	public void generarNumeros(){
		this.num1 = (int)Math.round((Math.random()*8+1));
		this.num2 = (int)Math.round((Math.random()*8+1));
		this.strNum1 = "./Numeros/" + (Integer.toString(this.num1)) + ".png";
		this.strNum2 = "./Numeros/" + (Integer.toString(this.num2)) + ".png";
	}
	public void pintarJuego(){
		if(this.puntuacion == 0){
			respUsr = new JTextField(5);
			respUsr.addActionListener(this);
			respUsr.setLocation(2000,2000);
			this.add(respUsr);

			enviar = new JButton("Validar!");
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
				do{
					generarNumeros();
				}while((this.num1 + this.num2) > 10);
				this.imgNum = ImageIO.read(new File(this.strNum1));
				this.imgNum2 = ImageIO.read(new File(this.strNum2));
				this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen: " + ex);
			}
		}else if(dificultad == "Retador"){//----------------------------------Retador----------------------------------------------
			System.out.println(dificultad);
			try{
				coor1 = 240;
				coor2 = 455;
				coor3 = 345;
				generarNumeros();
				imgNum = ImageIO.read(new File(this.strNum1));
				imgNum2 = ImageIO.read(new File(this.strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen: " + ex);
			}
		}else if(dificultad == "Avanzado"){//----------------------------------Avanzado----------------------------------------------
			System.out.println(dificultad);
			try{
				coor1 = 240;
				coor2 = 455;
				coor3 = 345;
				generarNumeros();
				imgNum = ImageIO.read(new File(this.strNum1));
				imgNum2 = ImageIO.read(new File(this.strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen: " + ex);
			}
		}else if(dificultad == "DIOS"){//----------------------------------OH GOD WHY!?----------------------------------------------
			System.out.println(dificultad);
			try{
				coor1 = 240;
				coor2 = 455;
				coor3 = 345;
				generarNumeros();
				imgNum = ImageIO.read(new File(this.strNum1));
				imgNum2 = ImageIO.read(new File(this.strNum2));
				imgSig = ImageIO.read(new File("./Numeros/+.png"));
			}catch(IOException ex){
				System.out.println("Error con la Imagen: " + ex);
			}
		}
    }

    public void imgCorrecto(boolean corOInco){
    	try{
			imgCor = ImageIO.read(new File("./Numeros/c.png"));
		}catch(IOException ex){
			System.out.println("Error con la Imagen: " + ex);
		}
    }
    public void validarRespuesta(int respuestaUsuario){
    	if(this.dificultad == "Principiante"){
    		//asdasdasd
    	}else{
    		if((this.num1 + this.num2) == respuestaUsuario){
    			this.puntuacion = this.puntuacion + 10;
    			
    			/*try{
    				Thread.sleep(5000);
    			}catch(InterruptedException e){
    				System.out.println(e);
    			}*/

    			this.reIniciar = new JButton("Siguiente!");
				this.reIniciar.addActionListener(this);
				this.reIniciar.setBounds(690,530,100,30);
				this.add(reIniciar);
				this.repaint();

				System.out.println("Correcto, la respuesta es " + (this.num1 + this.num2) + " y tu puntuacion es de " + this.puntuacion);
				Font myFont= new Font ("Comic Sans MS",1,22);
				JLabel texto1=new JLabel("asdasdasdasd");
				texto1.setFont(myFont);
				this.add(texto1);
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

       	g.drawString("Tu puntacion actual es de " + this.puntuacion,10,10);
    }
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == enviar || e.getSource() == respUsr){
			//System.out.println(this.respUsr.getText() + " respUsr");
			String respuestaUsuario = this.respUsr.getText();
			//System.out.println(respuestaUsuario + " respuestaUsuario");
			respUsr.setText(null);
			validarRespuesta(Integer.parseInt((respuestaUsuario)));
		}else if(e.getSource() == reIniciar){
			remove(reIniciar);
			pintarJuego();
			this.repaint();
		}
	}
}
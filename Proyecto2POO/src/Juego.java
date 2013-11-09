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

    private BufferedImage imgNum, imgNum2, imgNum3, imgNum4, imgSig, imgInt, imgCor;
    private int num1, num2, num3, num4, coor1, coor2, coor3, coor4, coor5, puntuacion, maxNum1, maxNum2, maxNum3;
    private String dificultad = "", strNum1, strNum2, strNum3, strNum4;
    public JTextField respUsr;
    public JButton enviar, reIniciar;
    public boolean respuestaCorrecta;

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
        this.num1 = (int)Math.round((Math.random()*(this.maxNum1)+1));
        this.num2 = (int)Math.round((Math.random()*(this.maxNum2)+1));
        this.num3 = (int)Math.round((Math.random()*(this.maxNum3)+1));
        this.num4 = (int)Math.round((Math.random()*(this.maxNum3)+1));
        System.out.println(this.num1 + ", " + this.num2 + ", " + this.num3 + ", " + this.num4);
        this.strNum1 = "./Numeros/" + (Integer.toString(this.num1)) + ".png";
        this.strNum2 = "./Numeros/" + (Integer.toString(this.num2)) + ".png";
        this.strNum3 = "./Numeros/" + (Integer.toString(this.num3)) + ".png";
        this.strNum4 = "./Numeros/" + (Integer.toString(this.num4)) + ".png";
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
            try{
                this.coor1 = 240;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 200000;
                this.coor5 = 200000;
                this.maxNum1 = 8;
                this.maxNum2 = 8;
                this.maxNum3 = 0;
                do{
                    generarNumeros();
                }while((this.num1 + this.num2) > 10);

                this.imgNum = ImageIO.read(new File(this.strNum1));
                this.imgNum2 = ImageIO.read(new File(this.strNum2));
                this.imgNum3 = ImageIO.read(new File(this.strNum3));
                this.imgNum4 = ImageIO.read(new File(this.strNum4));
                this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
            }catch(IOException ex){
                System.out.println("Error con la Imagen: " + ex);
            }
        }else if(this.dificultad == "Sencillo"){//----------------------------------Sencillo----------------------------------------------
            try{
                this.coor1 = 240;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 240;
                this.coor5 = 445;
                this.maxNum1 = 8;
                this.maxNum2 = 8;
                this.maxNum3 = 1;
                do{
                    generarNumeros();
                }while((this.num1 + this.num2) < 10 || (this.num1 + this.num2) > 20);
                this.imgNum = ImageIO.read(new File(this.strNum1));
                this.imgNum2 = ImageIO.read(new File(this.strNum2));
                //this.imgNum3 = ImageIO.read(new File(this.strNum3));
                //this.imgNum4 = ImageIO.read(new File(this.strNum4));
                this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
            }catch(IOException ex){
                System.out.println("Error con la Imagen: " + ex);
            }
        }else if(dificultad == "Retador"){//----------------------------------Retador----------------------------------------------
            try{
                this.coor1 = 240;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 240;
                this.coor5 = 445;
                this.maxNum1 = 8;
                this.maxNum2 = 8;
                this.maxNum3 = 2;
                do{
                    generarNumeros();
                }while((this.num1 + this.num2 + this.num3 + this.num4) < 20 || (this.num1 + this.num2) > 30);
                this.imgNum = ImageIO.read(new File(this.strNum1));
                this.imgNum2 = ImageIO.read(new File(this.strNum2));
                this.imgNum3 = ImageIO.read(new File(this.strNum3));
                this.imgNum4 = ImageIO.read(new File(this.strNum4));
                this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
            }catch(IOException ex){
                System.out.println("Error con la Imagen: " + ex);
            }
        }else if(dificultad == "Avanzado"){//----------------------------------Avanzado----------------------------------------------
            try{
                this.coor1 = 240;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 240;
                this.coor5 = 445;
                this.maxNum1 = 8;
                this.maxNum2 = 8;
                this.maxNum3 = 3;
                do{
                    generarNumeros();
                }while((this.num1 + this.num2 + this.num3 + this.num4) < 30 || (this.num1 + this.num2) > 40);
                this.imgNum = ImageIO.read(new File(this.strNum1));
                this.imgNum2 = ImageIO.read(new File(this.strNum2));
                this.imgNum3 = ImageIO.read(new File(this.strNum3));
                this.imgNum4 = ImageIO.read(new File(this.strNum4));
                this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
            }catch(IOException ex){
                System.out.println("Error con la Imagen: " + ex);
            }
        }else if(dificultad == "DIOS"){//----------------------------------OH GOD WHY!?----------------------------------------------
            try{
                this.coor1 = 240;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 240;
                this.coor5 = 445;
                this.maxNum1 = 8;
                this.maxNum2 = 8;
                this.maxNum3 = 4;
                do{
                    generarNumeros();
                }while((this.num1 + this.num2 + this.num3 + this.num4) < 40 || (this.num1 + this.num2) > 50);
                this.imgNum = ImageIO.read(new File(this.strNum1));
                this.imgNum2 = ImageIO.read(new File(this.strNum2));
                this.imgNum3 = ImageIO.read(new File(this.strNum3));
                this.imgNum4 = ImageIO.read(new File(this.strNum4));
                this.imgSig = ImageIO.read(new File("./Numeros/+.png"));
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
        if(this.dificultad == "Principiante" || this.dificultad == "Sencillo"){
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
                System.out.println();
                Font myFont= new Font ("Comic Sans MS",1,22);
                JLabel texto1=new JLabel("asdasdasdasd");
                texto1.setFont(myFont);
                //this.add(texto1);
                //this.repaint();
                this.respuestaCorrecta = true;
            }else{
                    respUsr.setText(null);
                    System.out.println("incorrecto");
            }
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
                System.out.println();
                Font myFont= new Font ("Comic Sans MS",1,22);
                JLabel texto1=new JLabel("asdasdasdasd");
                texto1.setFont(myFont);
                //this.add(texto1);
                //this.repaint();
                this.respuestaCorrecta = true;
            }else{
                    respUsr.setText(null);
                    System.out.println("incorrecto");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(this.imgNum, this.coor1, 250, null);
        g.drawImage(this.imgNum2, this.coor2, 250, null);
        g.drawImage(this.imgNum3, this.coor4, 250, null);
        g.drawImage(this.imgNum4, this.coor5, 250, null);
        g.drawImage(this.imgSig, this.coor3, 250, null);

        g.drawString("Tu puntacion actual es de " + this.puntuacion,10,10);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == enviar || e.getSource() == respUsr){
            if(this.respuestaCorrecta == false){
                //System.out.println(this.respUsr.getText() + " respUsr");
                String respuestaUsuario = this.respUsr.getText();//<----------------------------- aqui falta un CATCH para si el usuario no captura un INT o no da ningun valor
                //System.out.println(respuestaUsuario + " respuestaUsuario");

                validarRespuesta(Integer.parseInt((respuestaUsuario)));
            }else{
                respUsr.setText(null);
                System.out.println("Siguiente Pregunta!");
                System.out.println();
                remove(reIniciar);
                pintarJuego();
                this.repaint();
                this.respuestaCorrecta = false;
            }
        }else if(e.getSource() == reIniciar){
            respUsr.setText(null);
            System.out.println("Siguiente Pregunta!");
            System.out.println();
            remove(reIniciar);
            pintarJuego();
            this.repaint();
            this.respuestaCorrecta = false;
        }
    }
}
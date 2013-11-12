import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Juego extends JPanel implements ActionListener{

        private int num1, num2, puntuacion;
        private String dificultad = "sencillo",  usuario;
        public JTextField respUsr;
        public JButton enviar, reIniciar, cerrar, aceptar,cancelar;
        public boolean respuestaCorrecta;
        private ventana ventana;
        JDialog dialogo;

        public Juego(String difi, String usuario){
                super();
                this.dificultad = difi;
                this.usuario=usuario;        
                this.setLayout(new BorderLayout());
                JPanel superior=new JPanel();
                JPanel inferior=new JPanel();
                JPanel derecha=new JPanel();
                JLabel texto=new JLabel("Usuario: ");
                JLabel nombre=new JLabel(this.usuario);
                pintarJuego lienzo=new pintarJuego();

                respUsr=new JTextField(5);
                enviar=new JButton("Aceptar");
                cerrar=new JButton("Salir");
                cerrar.addActionListener(this);
                enviar.addActionListener(this);

                Marcador tablero=new Marcador();
                MarcoCentral marco=new MarcoCentral();
                tablero.setPuntaje(this.puntuacion);
                marco.setDificultad(this.dificultad);        
                derecha.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
                derecha.setPreferredSize(new Dimension(150,100));
                derecha.setBackground(Color.DARK_GRAY);        
                texto.setForeground(Color.WHITE);
                nombre.setFont(new Font("Comic Sans Serif",1, 16));
                texto.setFont(new Font("Comic Sans Serif",1, 16));
                nombre.setForeground(new Color(0x7a7af1));
                derecha.add(texto);
                derecha.add(nombre);
                derecha.add(cerrar);        

                inferior.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10 ));
                inferior.setPreferredSize(new Dimension(800,75));
                inferior.add(respUsr);
                inferior.add(enviar);
                superior.setLayout(new BorderLayout());  
                superior.add(derecha, BorderLayout.EAST);     
                superior.add(tablero, BorderLayout.WEST);       
                superior.add(marco, BorderLayout.CENTER);
                superior.setPreferredSize(new Dimension(800,100));
                superior.setBackground(Color.GRAY);

                this.add(superior, BorderLayout.NORTH);
                this.add(inferior, BorderLayout.SOUTH);
                this.numerosRandom(this.dificultad);
                lienzo.setNumeros(num1, num2);
                this.add(lienzo, BorderLayout.CENTER);     

        }

        public class Marcador extends JPanel{
                private int puntuacion; 

                public Marcador(){
                        super();
                        this.setBackground(Color.LIGHT_GRAY);
                        this.setPreferredSize(new Dimension(150,100));
                }


                public void setPuntaje(int puntuacion){
                        this.puntuacion=puntuacion;

                }            

                public void paintComponent(Graphics g){
                        super.paintComponent(g);                   
                        String score="Puntuación:";

                        Font myFont=new Font("Comic Sans MS",1,26 );
                        Font myFont2=new Font("DigiFaceWide",1, 60);
                        g.setFont(myFont);
                        g.setColor(Color.YELLOW);                    
                        g.drawString(score,0, 25);
                        g.setFont(myFont2);
                        score=Integer.toString(this.puntuacion);
                        if(this.puntuacion==0)
                        {                            
                                g.setColor(Color.RED);
                                score="00";
                        }
                        if(this.puntuacion<100){
                                g.drawString(score, 20, 80);
                        }
                        else{
                                g.drawString(score, 0, 80);
                        }
                }

        }

        public class MarcoCentral extends JPanel{
                private String dificultad;

                public MarcoCentral(){
                        super();
                        this.setBackground(Color.GRAY);
                        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
                        this.setPreferredSize(new Dimension(150,100));                    
                }

                public void setDificultad(String dificultad){
                        this.dificultad=dificultad;                    
                }

                public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        Font myFont=new Font("Comic Sans MS",1,26 );
                        g.setFont(myFont);
                        g.setColor(Color.WHITE);
                        g.drawString("Dificultad:",this.getWidth()/2-75 , 30);        
                        myFont=new Font("Comic Sans MS",1,30);
                        if(this.dificultad=="sencillo"){
                                g.setColor(Color.BLUE);
                        }
                        if(this.dificultad=="facil"){
                                g.setColor(Color.GREEN);
                        }
                        if(this.dificultad=="retador"){
                                g.setColor(Color.ORANGE);
                        }
                        if(this.dificultad=="dificil"){
                                g.setColor(Color.RED);
                        }
                        g.drawString(this.dificultad.toUpperCase(), this.getWidth()/2-75, 60);
                }
        }


        public void setDificultad(String valor, String usuario){
                dificultad = valor;
                this.usuario=usuario;
        } 

        public int setPuntaje(){
                puntuacion=this.puntuacion;
                return puntuacion;
        }

        public void numerosRandom(String dificultad){
                Random ran=new Random();
                int maxNum;

                if(dificultad=="sencillo"){
                        maxNum=10;
                        do{
                                this.num1=ran.nextInt(10);
                                this.num2=ran.nextInt(10);
                        }while(num1+num2<=maxNum);
                }        
                if(dificultad=="facil"){
                        maxNum=20;        
                        do{
                                this.num1=ran.nextInt(20);
                                this.num2=ran.nextInt(20);
                        }while(num1+num2<=maxNum);

                }
                if(dificultad=="retador"){
                        maxNum=40;
                        do{
                                this.num1=ran.nextInt(40);
                                this.num2=ran.nextInt(40);
                        }while(num1+num2<=maxNum);

                }
                if(dificultad=="dificil"){
                        maxNum=50;
                        do{
                                this.num1=ran.nextInt(50);
                                this.num2=ran.nextInt(50);
                        }while(num1+num2<=maxNum);                        
                }

        }

        public void validar(int num1, int num2, JTextField respUsr) {
                int respuesta=Integer.parseInt(respUsr.getText());
                if((num1+num2)==respuesta){
                        System.out.println("Correcto!");
                }
                
        }


        public class pintarJuego extends JPanel{
                int unidad, unidad2, decena, decena2;
                BufferedImage uni, uni2, dec, dec2, imgSig;

                public pintarJuego(){
                        super();

                }

                public void setNumeros(int num1, int num2){
                        this.unidad=num1%10;
                        this.unidad2=num2%10;
                        this.decena=num1/10;
                        this.decena2=num2/10; 
                        this.crearNumeros(this.unidad,this.unidad2,this.decena,this.decena2); 
                }            

                public void crearNumeros(int unidad, int unidad2, int decena, int decena2){
                        try {
                                this.imgSig = ImageIO.read(new File("./Numeros/+.png"));

                                if(decena==0 || decena2==0){
                                        this.uni=ImageIO.read(new File("./Numeros/"+unidad+".png"));
                                        this.uni2=ImageIO.read(new File ("./Numeros/"+unidad2+".png"));
                                }
                                else{
                                        this.uni=ImageIO.read(new File("./Numeros/"+unidad+".png"));
                                        this.uni2=ImageIO.read(new File ("./Numeros/"+unidad2+".png"));
                                        this.dec=ImageIO.read(new File("./Numeros/"+decena+".png"));
                                        this.dec2=ImageIO.read(new File ("./Numeros/"+decena2+".png"));
                                }   

                        } catch (IOException e) {
                                e.printStackTrace();
                        }                    
                }

                public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        g.drawImage(this.dec, this.getWidth()/2-300, 125,null);
                        g.drawImage(this.uni, this.getWidth()/2-175, 125, null);
                        g.drawImage(this.imgSig,this.getWidth()/2-50,125,null);

                        if(this.decena2==0){
                                g.drawImage(this.uni2, this.getWidth()/2+75, 125,null);
                        }
                        else{  
                                g.drawImage(this.uni2, this.getWidth()/2+200, 125,null);
                                g.drawImage(this.dec2, this.getWidth()/2+75,125,null);

                        }

                }


        }


        @Override
        public void actionPerformed(ActionEvent e) {
                JPanel panel;                
                if(e.getSource()==cerrar){
                        JPanel advertencia=new JPanel(); 
                        JPanel superior= new JPanel();
                        JPanel inferior= new JPanel();
                        dialogo=new JDialog(ventana,"Espera...");
                        aceptar=new JButton("Aceptar");
                        cancelar=new JButton("Cancelar");
            advertencia.setLayout(new BorderLayout(10,10));
            superior.setPreferredSize(new Dimension(300,60));
            superior.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
            inferior.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
                                        
                        dialogo.setModal(true);
                        superior.add(new JLabel("¿Quieres salir del juego ahora?"));
                        superior.add(new JLabel( "Tu partida se guardará para que puedas"));
                        superior.add(new JLabel( " continuar más tarde."));
                        inferior.add(aceptar);
                        inferior.add(cancelar);
                        advertencia.add(superior,BorderLayout.NORTH);
                        advertencia.add(inferior, BorderLayout.SOUTH);
                        
                        cancelar.addActionListener(this);
                        aceptar.addActionListener(this);
                        dialogo.setBounds(this.getWidth()/2,this.getHeight()/2,300,140);                        
                        dialogo.add(advertencia);
                        dialogo.setAlwaysOnTop(true);
                        dialogo.setResizable(false);
                        dialogo.setVisible(true);
                }
                if(e.getSource()==enviar){
                        this.validar(this.num1,this.num2,this.respUsr);

                }
                if(e.getSource()==aceptar){
                        dialogo.dispose();
                        panel=new PartidaTerminada();
                        this.getParent().add(panel);
                        this.getParent().remove(this);
                        panel.getParent().validate();
                }
                if(e.getSource()==cancelar){
                        dialogo.dispose();
                }
        }
}

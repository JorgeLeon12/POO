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

<<<<<<< HEAD
=======
    private BufferedImage imgNum, imgNum2, imgNum3, imgNum4, imgSig, imgInt, imgCor;
    private int num1, num2, num3, num4, coor1, coor2, coor3, coor4, coor5, puntuacion, maxNum1, maxNum2, maxNum3, repeticiones = 0;
    private String dificultad = "", strNum1, strNum2, strNum3, strNum4;
    public JTextField respUsr;
    public JButton enviar, reIniciar, botCancelar;
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
        this.num1 = (int)Math.round((Math.random()*(this.maxNum1)));
        this.num2 = (int)Math.round((Math.random()*(this.maxNum2)));
        this.num3 = (int)Math.round((Math.random()*(this.maxNum3)));
        this.num4 = (int)Math.round((Math.random()*(this.maxNum3)));
        /*if(this.dificultad == "Sencillo" || this.dificultad == "Principiante"){
            System.out.println(this.num1 + ", " + this.num2 + " = " + (this.num1 + this.num2));
        }else{
            System.out.println(this.num1*10 + ", " + this.num2*10 + ", " + this.num3 + ", " + this.num4 + " = " + ((this.num1*10) + (this.num2*10) + this.num3 + this.num4));
        }*/
        this.strNum1 = "./Numeros/" + (Integer.toString(this.num1)) + ".png";
        this.strNum2 = "./Numeros/" + (Integer.toString(this.num2)) + ".png";
        this.strNum3 = "./Numeros/" + (Integer.toString(this.num3)) + ".png";
        this.strNum4 = "./Numeros/" + (Integer.toString(this.num4)) + ".png";
    }

    public void pintarJuego(){
        this.maxNum1 = 9;
        this.maxNum2 = 9;
        int cantidad;
        if(this.puntuacion == 0){
            respUsr = new JTextField(5);
            respUsr.addActionListener(this);
            respUsr.setLocation(2000,2000);
            this.add(respUsr);

            enviar = new JButton("Validar!");
            enviar.addActionListener(this);
            enviar.setBounds(690,530,100,30);
            this.add(enviar);

            botCancelar = new JButton("Cancelar");
            botCancelar.addActionListener(this);
            botCancelar.setBounds(590,430,000,30);
            this.add(botCancelar);
        }

        if(this.dificultad == "Principiante"){//----------------------------------Principiante----------------------------------------------
            try{
                this.coor1 = 240;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 200000;
                this.coor5 = 200000;
                this.maxNum3 = 0;
                do{
                    generarNumeros();
                }while((this.num1 + this.num2) > 10);

                this.imgNum = ImageIO.read(new File(this.strNum1));
                this.imgNum2 = ImageIO.read(new File(this.strNum2));
                //this.imgNum3 = ImageIO.read(new File(this.strNum3));
                //this.imgNum4 = ImageIO.read(new File(this.strNum4));
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
                this.maxNum3 = 0;
                do{
                    generarNumeros();
                    cantidad = this.num1 + this.num2;
                    if(cantidad < 20 && cantidad > 10){
                        break;
                    }
                }while(true);
                System.out.println("final" + cantidad);
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
                this.coor1 = 135;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 240;
                this.coor5 = 570;
                this.maxNum3 = 9;
                do{
                    generarNumeros();
                    cantidad = (this.num1*10) + (this.num2*10) + this.num3 + this.num4;
                    if(cantidad < 30 && cantidad > 20){
                        break;
                    }
                }while(true);
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
                this.coor1 = 135;
                this.coor2 = 455;
                this.coor3 = 345;
                this.coor4 = 240;
                this.coor5 = 570;
                this.maxNum3 = 9;
                do{
                    generarNumeros();
                    cantidad = (this.num1*10) + (this.num2*10) + this.num3 + this.num4;
                    if(cantidad < 40 && cantidad > 30){
                        break;
                    }
                }while(true);
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
                this.maxNum3 = 9;
                do{
                    generarNumeros();
                    cantidad = (this.num1*10) + (this.num2*10) + this.num3 + this.num4;
                    if(cantidad < 50 && cantidad > 40){
                        break;
                    }
                }while(true);
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
                

                this.respuestaCorrecta = true;
            }else{
                    respUsr.setText(null);
                    System.out.println("incorrecto");
            }
        }else{
            if(((this.num1*10) + (this.num2*10) + this.num3 + this.num4) == respuestaUsuario){
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
                

                this.respuestaCorrecta = true;
            }else{
                    respUsr.setText(null);
                    System.out.println("incorrecto");
            }
        }
    }

    public void clickCanselar(){
        JPanel panel=new JPanel();
        panel=new Niveles();
        this.getParent().add(panel);
        this.getParent().remove(this);
        panel.getParent().validate();
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
        g.drawString("Dificultad Actual: " + this.dificultad,10,35);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == enviar || e.getSource() == respUsr){
            if(this.respuestaCorrecta == false){
                //System.out.println(this.respUsr.getText() + " respUsr");
                //Character.isDigit('3')
               // String respuestaUsuario = this.respUsr.getText();//<----------------------------- aqui falta un CATCH para si el usuario no captura un INT o no da ningun valor
                //System.out.println(respuestaUsuario + " respuestaUsuario");
                //      System.out.println(Character.isDigit('5'));

                //boolean esNumero = ;
                int respuestaUsuario = Integer.parseInt(this.respUsr.getText());
                validarRespuesta(respuestaUsuario);
            }else{
            respUsr.setText(null);
            this.repeticiones = this.repeticiones + 1;
            System.out.println("Siguiente Pregunta!");
            System.out.println();
            remove(reIniciar);
            if(this.repeticiones > 2){
                clickCanselar();
            }else{
                pintarJuego();
            }
            this.repaint();
            this.respuestaCorrecta = false;
            }
        }else if(e.getSource() == reIniciar){
            respUsr.setText(null);
            this.repeticiones = this.repeticiones + 1;
            System.out.println("Siguiente Pregunta!");
            System.out.println();
            remove(reIniciar);
            if(this.repeticiones > 2){
                clickCanselar();
            }else{
                pintarJuego();
            }
            this.repaint();
            this.respuestaCorrecta = false;
        }else if(e.getSource() == botCancelar){
            clickCanselar();
        }
    }
>>>>>>> 63906942d12f14b8a79f27dc66a65c8390574d1e
}
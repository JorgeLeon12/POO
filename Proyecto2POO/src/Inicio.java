import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Inicio extends JPanel implements ActionListener{
        String texto="Hola, Bienvenido a Matemáticas, como nuevo jugador comenzarás en el nivel de principiante, según tu Score podrás subir de nivel";
        JButton guardar, cancelar, aceptar;
        JTextField usuario;
        ventana ventana;
        JDialog dialogo;

        public Inicio(){
                super();                
                this.setLayout(new BorderLayout());
                JPanel superior=new JPanel();
                JPanel contenedor=new JPanel();
                JPanel inferior=new JPanel();
                inferior.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
                                
                Font myFont= new Font ("Comic Sans MS",1,22);
                JLabel titulo=new JLabel("Juego Nuevo");
                JLabel texto2=new JLabel("Escribe tu nombre:");
                guardar=new JButton("Jugar");
                cancelar=new JButton("Cancelar");
                aceptar=new JButton("Aceptar");
                
                aceptar.addActionListener(this);
                guardar.addActionListener(this);
                cancelar.addActionListener(this);

                guardar.setBounds(350,350,100,40);
                cancelar.setBounds(690,530,100,30);

                titulo.setFont(myFont);
                titulo.setBounds(340, 10, 200, 50);
                texto2.setBounds(340,250,200,50);

                usuario=new JTextField(10);
                usuario.setBounds(300,300,200,30);
                usuario.setFont(myFont);
                usuario.setHorizontalAlignment(SwingConstants.CENTER);
                
                superior.add(titulo);
                contenedor.add(texto2);
                contenedor.add(usuario);
                contenedor.add(guardar);
                inferior.add(cancelar);
                this.add(superior, BorderLayout.NORTH);
                this.add(contenedor, BorderLayout.CENTER);
                this.add(inferior, BorderLayout.SOUTH);
        }
        


        @Override
        public void actionPerformed(ActionEvent e) {
                JPanel panel=new JPanel();
                JPanel advertencia=new JPanel();  
                advertencia.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
                
                if(e.getSource()==guardar){
                        String usuario=this.usuario.getText();
                        if(usuario.equals("")){
                        	dialogo=new JDialog(this.ventana,"�Error!");                
  	                        dialogo.setModal(true);
  		                    advertencia.add(new JLabel("Por favor especifique un nombre"));
  		                    advertencia.add(this.aceptar);
  		                    dialogo.setBounds(this.getWidth()/2,this.getHeight()/2,270,110);
  		                    dialogo.add(advertencia);
  	                        dialogo.setAlwaysOnTop(true);
  	                        dialogo.setVisible(true);
  	                        
                        }
                        else{                        	
                        	GuardarPartida partida=new GuardarPartida(this.usuario.getText(),"sencillo",0);
	                        panel=new Juego("sencillo", usuario, 0);	                   
	                        this.getParent().add(panel);
	                        this.getParent().remove(this);
	                        panel.getParent().validate();
	                    }
                }
                if(e.getSource()==cancelar){
                        panel=new PanelControl();
                        this.getParent().add(panel);
                        this.getParent().remove(this);
                        panel.getParent().validate();
                        
                }
                if(e.getSource()==aceptar){
                dialogo.dispose();
                }
        }
}
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Inicio extends JPanel implements ActionListener{
        String texto="Hola, Bienvenido a Matemáticas, como nuevo jugador comenzarás en el nivel de principiante, según tu Score podrás subir de nivel";
        JButton guardar, cancelar;
        JTextField usuario;

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
        
        public void guardarUs(String usuario){
                try {
                        String archivo=new File("").getAbsolutePath()+"//JuegosGuardados//"+usuario+".txt";
                        PrintWriter escritor=new PrintWriter(new FileWriter(archivo));
                        escritor.println(""+usuario);
                        escritor.println(0);
                        escritor.close();
                } catch (IOException e) {
                        File carpeta =new File(".//JuegosGuardados");
                        carpeta.mkdirs();
                        this.guardarUs(usuario);
                        
                }
        }


        @Override
        public void actionPerformed(ActionEvent e) {
                JPanel panel=new JPanel();                
                if(e.getSource()==guardar){
                        String usuario=this.usuario.getText();
                        this.guardarUs(usuario);
//                        JDialog dialogo=new JDialog(ventana.getFrames(),"¡Exito!",true);
//                        dialogo.setModal(true);
//                        this.add(dialogo);
                        panel=new Juego();
                }
                if(e.getSource()==cancelar){
                        panel=new PanelControl();
                        
                }
                this.getParent().add(panel);
                this.getParent().remove(this);
                panel.getParent().validate();
        }
}
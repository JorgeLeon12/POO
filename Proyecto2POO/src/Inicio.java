import java.awt.Font;
import java.awt.Frame;
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
	JButton guardar, cancelar;
	JTextField usuario;

	public Inicio(){
		super();
		this.setLayout(null);
		Font myFont= new Font ("Comic Sans MS",1,22);
		JLabel texto1=new JLabel("Juego Nuevo");
		JLabel texto2=new JLabel("Escribe tu nombre:");
		guardar=new JButton("Jugar");
		cancelar=new JButton("Cancelar");

		guardar.addActionListener(this);
		cancelar.addActionListener(this);

		guardar.setBounds(350,350,100,40);
		cancelar.setBounds(690,530,100,30);

		texto1.setFont(myFont);
		texto1.setBounds(340, 10, 200, 50);
		texto2.setBounds(340,250,200,50);

		usuario=new JTextField(10);
		usuario.setBounds(300,300,200,30);
		usuario.setFont(myFont);
		usuario.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(texto1);
		this.add(texto2);
		this.add(usuario);
		this.add(guardar);
		this.add(cancelar);
	}
	public void guardarUs(String usuario){
		try {
			String archivo=new File("").getAbsolutePath()+"//src//JuegosGuardados//"+usuario+".txt";
			PrintWriter escritor=new PrintWriter(new FileWriter(archivo));
			escritor.println(""+usuario);
			escritor.println(0);
			escritor.close();
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	
//	public void paint(Graphics g){
//		Font myFont= new Font ("Comic Sans MS",1,22);
//		String texto1="Juego Nuevo";
//		String texto2="Escribe Tu nombre:";
//		
//		g.setFont(myFont);
//		g.setColor(Color.BLUE);
//		g.drawString(texto1,340,30);
//		g.setColor(Color.BLACK);
//		g.drawString(texto2,300,250);
//		
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guardar){
			String usuario=this.usuario.getText();
			this.guardarUs(usuario);
//			JDialog dialogo=new JDialog(ventana.getFrames(),"¡Exito!",true);
//			dialogo.setModal(true);
//			this.add(dialogo);
			this.getParent().add(new Juego());
			this.getParent().remove(this);
		}
		if(e.getSource()==cancelar){
			this.getParent().add(new PanelControl());
			this.getParent().remove(this);
		}
	}
}

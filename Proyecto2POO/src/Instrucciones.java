import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Instrucciones extends JPanel implements ActionListener{
	private String texto=
			"<html><p>El menú cuenta con 3 opciones:</p> "
			+"<p> Nuevo Juego, Partida Rápida y Reanudar Juego.<p>"
			+"<p>Nuevo Juego podrás llevar un perfil, guardar progresos, y subir de nivel conforme vallas jugando./p>"
			+ "<p>En Partida Rápida te damos a elegir el nivel  pero no podrás grabar tu progreso.<p>"
			+ "<p>¿Tienes que irte y no has terminado el nivel? ¡No te preocupes! Has clic en Cancelar y cuando quieras</p>"
			+ "<p> continuar da clic en 'Reanudar Partida', tras elegir tu perfil podrás continuar ¡justo como dejaste tu partida!<p>"
			+ "<p>¿Quieres seguir practicando? En partida rápida puedes escojer el nivel en el que quieres seguir practicando.<p> "
			+ "<p>El juego cuenta con 4 niveles,con cada vez más difíciles y complicadas operaciones, ¡Cada respuesta correcta</p> "
			+ "<p>son 10 puntos que al juntar una cantidad de puntos pasaras de nivel! Pero cuidado, si contestas mal</p>"
			+ "<p>se te restarán 10 puntos.<p>"
			+ "<p>¡Buena suerte!</html>";
	
	
	public Instrucciones(){
		super();
		this.setLayout(new BorderLayout());
		JPanel superior=new JPanel();
		JPanel contenedor=new JPanel();
		JPanel inferior=new JPanel();
		JButton aceptar=new JButton();	
		JLabel cuadroTexto=new JLabel(this.texto);
		
		//cuadroTexto.setPreferredSize(new Dimension(800,500));
		JScrollPane scroll=new JScrollPane(contenedor);
		contenedor.setLayout(new FlowLayout(FlowLayout.CENTER,1000,20));
		contenedor.setPreferredSize(new Dimension(700,500));
		superior.setPreferredSize(new Dimension(800,50));
		superior.setLayout(new FlowLayout());
		inferior.setPreferredSize(new Dimension(800,50));
		
		contenedor.add(cuadroTexto);
		JLabel titulo=new JLabel("Instrucciones");
		Font myFont= new Font ("Comic Sans MS",1,22);		
		titulo.setFont(myFont);
		titulo.setBounds(800, 100,800,100);
		
		aceptar=new JButton("Aceptar");	
		aceptar.addActionListener(this);
	
		
		superior.add(titulo);
		inferior.add(aceptar);		
		this.add(superior, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(inferior, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel panel=new JPanel();		
		panel=new PanelControl();		
		this.getParent().add(panel);
		this.getParent().remove(this);
		panel.getParent().validate();
		
	}
	
}


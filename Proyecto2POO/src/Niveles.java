import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Niveles extends JPanel implements ActionListener {
	JButton principiante, facil, medio, dificil;

	public Niveles(){
		this.setLayout(null);
		
		principiante=new JButton("Principiante");
		facil=new JButton("Sencillo");
		medio=new JButton("Retador");
		dificil=new JButton("Avanzado");
		
		principiante.addActionListener(this);
		facil.addActionListener(this);
		medio.addActionListener(this);
		dificil.addActionListener(this);
		
		principiante.setBounds(300,130,200,30);
		facil.setBounds(300,220,200,30);
		medio.setBounds(300,310,200,30);
		dificil.setBounds(300,400,200,30);
		
		this.add(principiante);
		this.add(facil);
		this.add(medio);
		this.add(dificil);	
		
	}
	
	public void seleccionarDificultad(String dificultad){
		this.getParent().add(new Juego());
		this.getParent().remove(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String dificultad=e.getSource().toString();
		this.seleccionarDificultad(dificultad);
		
	}
	
}

import java.awt.Dimension;

import javax.swing.JFrame;


public class ventana extends JFrame{

	public ventana(){
		super("Matematicas");
		this.setSize(new Dimension(800,600));
		this.setMinimumSize(new Dimension(750,550));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void actualizar(){
		this.repaint();
	}
	public static void main(String[] args){
		ventana ventana=new ventana();

		PanelControl inicio=new PanelControl();
		ventana.add(inicio);
		ventana.setVisible(true);
	}
}

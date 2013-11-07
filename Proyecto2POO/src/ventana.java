import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ventana extends JFrame{

	public ventana(){
		super("Matematicas");
		this.setSize(new Dimension(800,600));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void niveles(){

		Niveles panel=new Niveles();
		this.add(panel);
		repaint();
		System.out.println("holis");
	}

	public void actualizar(){
		this.repaint();
	}
	public static void main(String[] args){
		ventana ventana=new ventana();

		PanelControl inicio=new PanelControl();
		ventana.add(inicio);
		try{
			while(true){
				ventana.actualizar();
				Thread.sleep(20);
				ventana.setVisible(true);
			}
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
	}
}

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelControl extends JPanel implements ActionListener{
	JButton niveles, inicio, continuar,instrucciones;

	public PanelControl(){
		super();
		this.setLayout(null);

		inicio=new JButton("Comenzar nuevo juego");
		continuar=new JButton("Continuar Juego");
		instrucciones=new JButton("Instrucciones");
		niveles=new JButton("Niveles");

		inicio.addActionListener(this);
		continuar.addActionListener(this);
		instrucciones.addActionListener(this);
		niveles.addActionListener(this);

		this.add(inicio);
		this.add(continuar);
		this.add(niveles);
		this.add(instrucciones);

		inicio.setBounds(300, 300, 200, 30);
		continuar.setBounds(300,340,200,30);
		niveles.setBounds(300,380,200,30);
		instrucciones.setBounds(300,420,200,30);
	}

	public void addPanel(JPanel panel){
		this.add(panel);
		System.out.println("listo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.niveles){
			this.getParent().add(new Niveles());
			this.getParent().remove(this);
		}
		if(e.getSource()==this.inicio){
			this.getParent().add(new Inicio());
			this.getParent().remove(this);
			System.out.println("inicio");
		}

	}
}
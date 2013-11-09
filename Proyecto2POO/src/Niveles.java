import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Niveles extends JPanel implements ActionListener {
	JButton principiante, facil, medio, dificil, cancelar;
	JPanel panel;

	private BufferedImage image;

	public Niveles(){
		super();
		this.setLayout(new BorderLayout());
		JPanel superior=new JPanel();
		JPanel contenedor=new JPanel();
		JPanel inferior=new JPanel();	
		contenedor.setLayout(new FlowLayout(FlowLayout.CENTER,1000,60));
		inferior.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
		Font myFont= new Font ("Comic Sans MS",1,22);
	
		superior.setPreferredSize(new Dimension(800,50));
		inferior.setPreferredSize(new Dimension(800,50));		
		JLabel titulo=new JLabel("Selecciona una partida");
		titulo.setFont(myFont);
		principiante=new JButton("Principiante");
		facil=new JButton("Sencillo");
		medio=new JButton("Retador");
		dificil=new JButton("Avanzado");
		cancelar=new JButton("Cancelar");
		
		principiante.setPreferredSize(new Dimension(200,30));
		facil.setPreferredSize(new Dimension(200,30));
		medio.setPreferredSize(new Dimension(200,30));
		dificil.setPreferredSize(new Dimension(200,30));
		cancelar.setPreferredSize(new Dimension(200,30));

		principiante.addActionListener(this);
		facil.addActionListener(this);
		medio.addActionListener(this);
		dificil.addActionListener(this);
		cancelar.addActionListener(this);
		
		contenedor.add(principiante);
		contenedor.add(facil);
		contenedor.add(medio);
		contenedor.add(dificil);
		inferior.add(cancelar);
		superior.add(titulo);
		this.add(superior, BorderLayout.NORTH);
		this.add(contenedor, BorderLayout.CENTER);
		this.add(inferior, BorderLayout.SOUTH);
	}

	public void seleccionarDificultad(String dificultad){
		Juego elJuego = new Juego(dificultad);
		//elJuego.setDificultad(dificultad);
		this.getParent().add(elJuego);
		this.getParent().remove(this);
		elJuego.getParent().validate();
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for morye info on the parameters            
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.cancelar){	
			this.panel=new PanelControl();
			this.getParent().add(panel);
			this.getParent().remove(this);
			this.panel.getParent().validate();
		}
		else{
			JButton origen = (JButton)e.getSource();
			String dificultad=origen.getText();
			this.seleccionarDificultad(dificultad);
			System.out.println(dificultad);			
		}
	}

}
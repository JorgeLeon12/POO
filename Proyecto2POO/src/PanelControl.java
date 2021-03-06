import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelControl extends JPanel implements ActionListener{
	JButton niveles, inicio, continuar,instrucciones;
	BufferedImage img;

	public PanelControl(){
		super();
		this.setLayout(new BorderLayout());
		
		JPanel superior=new JPanel();
		JPanel contenedor=new JPanel();
		
		superior.setPreferredSize(new Dimension(800,50));
		contenedor.setPreferredSize(new Dimension(800,500));
		contenedor.setPreferredSize(new Dimension(800,250));
		contenedor.setLayout(new FlowLayout(FlowLayout.CENTER, 1000,10));
		
		inicio=new JButton("Comenzar nuevo juego");
		continuar=new JButton("Continuar Juego");
		instrucciones=new JButton("Instrucciones");
		niveles=new JButton("Partida R�pida");
		
		try {
			img= ImageIO.read(new File(".//Imagenes//logo.png"));
		} catch (IOException e) {
			System.out.println("Error, imagen no encontrada");
		}

		inicio.addActionListener(this);
		continuar.addActionListener(this);
		instrucciones.addActionListener(this);
		niveles.addActionListener(this);
		
		inicio.setPreferredSize(new Dimension(200,30));
		continuar.setPreferredSize(new Dimension(200,30));
		instrucciones.setPreferredSize(new Dimension(200,30));
		niveles.setPreferredSize(new Dimension(200,30));
		
		contenedor.add(inicio);
		contenedor.add(continuar);
		contenedor.add(niveles);
		contenedor.add(instrucciones);
		this.add(superior, BorderLayout.NORTH);
		this.add(contenedor, BorderLayout.SOUTH);				
	}
	
	public void paint(Graphics g){		
		super.paint(g);		
		g.drawImage(img, (this.getWidth()/2)-160, (this.getParent().getHeight()/12),null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel=new JPanel();
		if(e.getSource()==this.niveles){
			panel=new Niveles();			
		}
		if(e.getSource()==this.inicio){
			panel=new Inicio();			
		}
		if(e.getSource()==this.continuar){
			panel=new ContinuarJuego();
		}		
		if(e.getSource()==this.instrucciones){
			panel=new Instrucciones();
		}
		this.getParent().add(panel);
		this.getParent().remove(this);
		panel.getParent().validate();
	}
}
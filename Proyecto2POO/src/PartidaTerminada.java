import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PartidaTerminada extends JPanel implements ActionListener{
		JButton aceptar;
		BufferedImage  star;
		int puntuacion=0;
	
	public PartidaTerminada(int puntuacion){
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,2000,500));	
		this.puntuacion=puntuacion;
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(this);
		this.add(aceptar);
		try {
			this.star= ImageIO.read(new File(".//Numeros//star.png"));
		} catch (IOException e) {
			System.out.println("Error, imagen no encontrada");
		}		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font myFont=new Font("Comic Sans Serif",1,30);
		g.setFont(myFont);
		g.drawString("Partida Terminada, Tu puntaje es:",this.getParent().getWidth()/2-250,50);
		g.drawImage(this.star,this.getParent().getWidth()/2-134,this.getParent().getHeight()/2-134, null);
		g.setColor(Color.ORANGE);
		g.drawString(Integer.toString(this.puntuacion),this.getParent().getWidth()/2-25,this.getParent().getHeight()/2-175);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel;
		
		if(e.getSource()==aceptar){
			panel=new PanelControl();
			this.getParent().add(panel);
			this.getParent().remove(this);
			panel.getParent().validate();
		}
		
	}

}

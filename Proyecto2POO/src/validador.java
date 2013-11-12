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

public class validador extends JPanel implements ActionListener{
		JButton aceptar;
		BufferedImage  img, img2;
		int puntuacion=0;
		JPanel panel;
		String valor;
	
	public validador(JPanel panel, String valor){
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,2000,300));	
		this.puntuacion=puntuacion;
		this.panel=panel;
		this.valor=valor;
		aceptar=new JButton("Continuar");
		aceptar.addActionListener(this);
		this.add(aceptar);
		try {
			this.img= ImageIO.read(new File(".//Numeros//false.png"));
			this.img2= ImageIO.read(new File(".//Numeros//true.png"));
		} catch (IOException e) {
			System.out.println("Error, imagen no encontrada");
		}		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font myFont=new Font("Comic Sans Serif",1,26);
		g.setFont(myFont);
		if(this.valor=="correcto"){
			g.drawString("¡Muy bien! Presiona Continuar para seguir jugando",this.getParent().getWidth()/2-250,30);
			g.drawImage(this.img2,this.getParent().getWidth()/2-82,this.getParent().getHeight()/2-155, null);
			g.setColor(Color.GREEN);
			g.drawString("+10 pts",this.getParent().getWidth()/2-25,this.getParent().getHeight()/2-195);
		}
		else{
			
			g.drawString("Te has equivocado, inténtalo de nuevo",this.getParent().getWidth()/2-250,30);
			g.drawImage(this.img,this.getParent().getWidth()/2-82,this.getParent().getHeight()/2-155, null);
			g.setColor(Color.RED);
			g.drawString("-10 pts",this.getParent().getWidth()/2-25,this.getParent().getHeight()/2-195);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aceptar){
			
			this.getParent().add(panel);
			this.getParent().remove(this);
			panel.getParent().validate();
			panel.repaint();
		}
		
	}

}

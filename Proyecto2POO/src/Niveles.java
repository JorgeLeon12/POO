import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Niveles extends JPanel implements ActionListener {
	JButton principiante, facil, medio, dificil;

	private BufferedImage image;

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
		Juego elJuego = new Juego(dificultad);
		//elJuego.setDificultad(dificultad);
		this.getParent().add(elJuego);
		this.getParent().remove(this);
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton origen = (JButton)e.getSource();
		String dificultad=origen.getText();
		this.seleccionarDificultad(dificultad);
		System.out.println(dificultad);
	}

}
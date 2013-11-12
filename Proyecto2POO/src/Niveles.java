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
	JButton sencillo, facil, retador, dificil, cancelar;
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
		JLabel titulo=new JLabel("Selecciona una dificultad");
		titulo.setFont(myFont);
		sencillo=new JButton("Sencillo");
		facil=new JButton("Facil");
		retador=new JButton("Retador");
		dificil=new JButton("Difícil");
		cancelar=new JButton("Cancelar");
		sencillo.setActionCommand("sencillo");
		facil.setActionCommand("facil");
		retador.setActionCommand("retador");
		dificil.setActionCommand("dificil");		
		
		sencillo.setPreferredSize(new Dimension(200,30));
		facil.setPreferredSize(new Dimension(200,30));
		retador.setPreferredSize(new Dimension(200,30));
		dificil.setPreferredSize(new Dimension(200,30));
		cancelar.setPreferredSize(new Dimension(200,30));

		sencillo.addActionListener(this);
		facil.addActionListener(this);
		retador.addActionListener(this);
		dificil.addActionListener(this);
		cancelar.addActionListener(this);
		
		contenedor.add(sencillo);
		contenedor.add(facil);
		contenedor.add(retador);
		contenedor.add(dificil);
		inferior.add(cancelar);
		superior.add(titulo);
		this.add(superior, BorderLayout.NORTH);
		this.add(contenedor, BorderLayout.CENTER);
		this.add(inferior, BorderLayout.SOUTH);
	}

	public void seleccionarDificultad(String dificultad){
		Juego elJuego = new Juego(dificultad, "Partida Rápida");
		this.getParent().add(elJuego);
		this.getParent().remove(this);
		elJuego.getParent().validate();
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);   
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
			String dificultad=e.getActionCommand();
			this.seleccionarDificultad(dificultad);
			System.out.println(dificultad);			
		}
	}

}
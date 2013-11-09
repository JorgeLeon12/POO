import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ContinuarJuego extends JPanel implements ActionListener{
	JButton cancelar, boton, nuevo;
	String[] usuario;
	int[] score;
	
	public ContinuarJuego(){
		super();		
		this.lector();
		this.setLayout(new BorderLayout());
		JPanel tituloPanel=new JPanel();
		JPanel contenedor=new JPanel();
		JPanel inferior=new JPanel();
		
		JScrollPane scroll=new JScrollPane(contenedor);
		contenedor.setLayout(new FlowLayout(FlowLayout.CENTER,1000,20));
		contenedor.setPreferredSize(new Dimension(700,500));
		tituloPanel.setPreferredSize(new Dimension(800,50));
		tituloPanel.setLayout(new FlowLayout());
		inferior.setPreferredSize(new Dimension(800,50));

		for(int i=0;this.usuario.length>i;i++){
			boton=new JButton("Usuario: "+usuario[i]+" Score: "+score[i]);
			boton.setActionCommand(usuario[i]);
			boton.setPreferredSize(new Dimension(400, 50));
			boton.addActionListener(this);
			contenedor.add(boton);			
		}		
		
		if(this.usuario.length==0){
			contenedor.add(new JLabel("No hay partidas guardadas actualmente, seleccione 'Crear Nueva Partida'"));
		}
		
		JLabel titulo=new JLabel("Selecciona una partida");
		Font myFont= new Font ("Comic Sans MS",1,22);		
		titulo.setFont(myFont);
		titulo.setBounds(800, 100,800,100);
		
		cancelar=new JButton("Cancelar");
		nuevo=new JButton("Nueva Partida");
		cancelar.addActionListener(this);
		nuevo.addActionListener(this);
		
		tituloPanel.add(titulo);
		inferior.add(nuevo);
		inferior.add(cancelar);		
		this.add(tituloPanel, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(inferior, BorderLayout.SOUTH);
	}

	public void lector(){
		String ruta=new File("").getAbsolutePath()+"//src//JuegosGuardados//";
		File archivo=new File(ruta);
		BufferedReader lector;
		String linea;
		
		if (archivo.exists()){ 
			File[] ficheros = archivo.listFiles();
			this.usuario=new String[ficheros.length];
			this.score=new int[ficheros.length];			
			for (int i=0;i<ficheros.length;i++){
				int j=0;
				try {
					lector= new BufferedReader(new FileReader(ficheros[i]));
					while((linea=lector.readLine())!=null){						
						if(j==0){
							this.usuario[i]=linea.toString();
							
						}
						if(j==1){
							this.score[i]=Integer.parseInt(linea);
							System.out.println(linea);
						}
						j++;						
					}					
					
				} catch (FileNotFoundException e) {
					System.out.println("No se encontró el archivo");
				} catch (IOException e) {
					e.printStackTrace();
				}										
			}
			
		}
		
		else{
			System.out.println("EL directorio no existe");
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel=new JPanel();	
		if(e.getSource()==this.cancelar){
			panel=new PanelControl();
			this.getParent().add(panel);
			this.getParent().remove(this);
			panel.getParent().validate();
		}
		else{
			System.out.println(e.getActionCommand());
			
		}
		if(e.getSource()==this.nuevo){
			panel=new Inicio();
			this.getParent().add(panel);
			this.getParent().remove(this);
			panel.getParent().validate();
		}
		if(e.getSource()==this.cancelar){
			
		}
	}
}

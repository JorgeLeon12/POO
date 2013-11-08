import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ContinuarJuego extends JPanel implements ActionListener{
	JButton cancelar;
	String[] usuario;
	int[] score;
	
	public ContinuarJuego(){
		super();
		
		this.setLayout(null);			
		JLabel titulo=new JLabel("Selecciona una Partida");
		cancelar=new JButton("Cancelar");
		cancelar.addActionListener(this);
		Box cajaV=Box.createVerticalBox();
		cajaV.setSize(600, 400);
		cajaV.setLocation(100, 100);
		cajaV.createGlue();
		this.lector();
		
		for(int i=0;this.usuario.length>i;i++){
			JButton boton=new JButton("Usuario: "+usuario[i]+" Score: "+score[i]);
			cajaV.add(boton);
		}		
		
		Font myFont= new Font ("Comic Sans MS",1,22);		
		titulo.setFont(myFont);
		titulo.setBounds(280, 10, 400, 50);
		cancelar.setBounds(690,530,100,30);
		
		
		this.add(titulo);
		this.add(cancelar, BorderLayout.SOUTH);		
		this.add(cajaV);		
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
		}
		
		this.getParent().add(panel);
		this.getParent().remove(this);
		panel.getParent().validate();
		
	}

	
	
}

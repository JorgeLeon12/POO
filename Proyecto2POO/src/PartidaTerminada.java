import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PartidaTerminada extends JPanel implements ActionListener{
		JButton aceptar;
	
	PartidaTerminada(){
		super();
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(this);
		this.add(aceptar);
		
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

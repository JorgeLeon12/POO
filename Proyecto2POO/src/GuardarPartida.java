import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class GuardarPartida {
	
    public GuardarPartida(String usuario, String dificultad, int score){
        try {
                String archivo=new File("").getAbsolutePath()+"//JuegosGuardados//"+usuario+".txt";
                PrintWriter escritor=new PrintWriter(new FileWriter(archivo));
                escritor.println(""+usuario);
                escritor.println(dificultad);
                escritor.println(score);
                escritor.close();
        } catch (IOException e) {
                File carpeta =new File(".//JuegosGuardados");
                carpeta.mkdirs();
                GuardarPartida partida=new GuardarPartida(usuario,dificultad,score);
                
        }
}

	
}

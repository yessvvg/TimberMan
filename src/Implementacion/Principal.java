package Implementacion;

import Clases.Inicio;
import Clases.ManejoSonido;
import Clases.Tiempo;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Principal {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
       Inicio wind = new Inicio();
        new Thread(wind).start();
     
  

    }

}

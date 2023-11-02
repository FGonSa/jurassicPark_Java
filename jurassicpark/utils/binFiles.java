package jurassicpark.utils;

import Clases.Dinosaurio;
import Clases.Fosil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank.Santos
 */
public class binFiles {

    public static void escribirDinosaurios(String rutaArchivo, List<Dinosaurio> dinosaurios) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile(rutaArchivo, "rw")) {

            // Escribir los datos de cada dinosaurio en el archivo
            for (Dinosaurio dino : dinosaurios) {
                raf.writeUTF(dino.getNombre());
                raf.writeUTF(dino.getEspecie());
                raf.writeFloat(dino.getAltura());
                raf.writeFloat(dino.getPeso());
                raf.writeInt(dino.getCantidadFosiles());

                // Escribir los datos de los fosiles asociados al dinosaurio en el archivo
                List<Fosil> fosiles = dino.getFosiles(); // Supongamos que cada Dinosaurio tiene una lista de fosiles
                
                //Si contiene fosiles, se escriben
                if(fosiles != null){
                for (Fosil fosil : fosiles) {
                    raf.writeUTF(fosil.getNombre());
                    raf.writeInt(fosil.getProfundidadDescubierto());
                    raf.writeUTF(fosil.getYacimiento());
                }
                }
            }
        }
    }

}

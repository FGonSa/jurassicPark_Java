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

    public static boolean procesoDino(String rutaArchivo, Dinosaurio dinosaurio) {

        boolean result;

        try (RandomAccessFile raf = new RandomAccessFile(rutaArchivo, "rw")) {
            // Escribir en el archivo
            escribirDinosaurio(raf, dinosaurio);

            // Leer del archivo
            raf.seek(0); // Establecer el puntero al principio del archivo
            leerDinosaurio(raf);

            System.out.println("Dinosaurio añadido al archivo y leído correctamente.");
            result = true;
        } catch (IOException e) {
            System.err.println("Error al escribir o leer en el archivo: " + e.getMessage());
            result = false;
        }
        return result;
    }

    private static void escribirDinosaurio(RandomAccessFile raf, Dinosaurio dinosaurio) throws IOException {
        // Escribir los datos del dinosaurio en el archivo
        raf.writeUTF(dinosaurio.getNombre());
        raf.writeUTF(dinosaurio.getEspecie());
        raf.writeFloat(dinosaurio.getAltura());
        raf.writeFloat(dinosaurio.getPeso());
        raf.writeInt(dinosaurio.getCantidadFosiles());

        // Supongamos que aquí también escribimos los datos de los fosiles asociados al dinosaurio
        List<Fosil> fosiles = new ArrayList<>(); // Supongamos que tienes una lista de fosiles asociados al dinosaurio
        for (Fosil fosil : fosiles) {
            escribirFosil(raf, fosil);
        }
    }

    private static void leerDinosaurio(RandomAccessFile raf) throws IOException {
        // Leer los datos del dinosaurio desde el archivo
        String nombre = raf.readUTF();
        String especie = raf.readUTF();
        float altura = raf.readFloat();
        float peso = raf.readFloat();
        int cantidadFosiles = raf.readInt();

        // Imprimir los datos leídos
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Cantidad de Fósiles: " + cantidadFosiles);

        // Supongamos que aquí también leemos los datos de los fosiles asociados al dinosaurio
        for (int i = 0; i < cantidadFosiles; i++) {
            Fosil fosil = leerFosil(raf);
            // Hacer algo con el fosil, como imprimir sus datos
            System.out.println("Fósil " + (i + 1) + ": " + fosil.toString());
        }
    }

    private static void escribirFosil(RandomAccessFile raf, Fosil fosil) throws IOException {
        // Escribir los datos del fosil en el archivo
        raf.writeUTF(fosil.getNombre());
        raf.writeInt(fosil.getProfundidadDescubierto());
        raf.writeUTF(fosil.getYacimiento());
        // Supongamos que aquí también escribimos los datos adicionales del fosil
    }

    private static Fosil leerFosil(RandomAccessFile raf) throws IOException {
        // Leer los datos del fosil desde el archivo
        String nombre = raf.readUTF();
        int profundidadDescubierto = raf.readInt();
        String yacimiento = raf.readUTF();
        // Supongamos que aquí también leemos los datos adicionales del fosil

        // Crear y devolver un objeto Fosil a partir de los datos leídos
        return new Fosil(nombre, profundidadDescubierto, yacimiento, null); // Debes proporcionar los valores adecuados
    }
}

package jurassicpark.utils;

import Clases.Dinosaurio;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Frank.Santos
 */
public class Utils {

    public static void menuPrincipal() {

        System.out.println("---------------");
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------");
        System.out.println("1. Añadir Dinosaurio");
        System.out.println("2. Añadir Fósil");
        System.out.println("3. Mostrar Dinosaurio");
        System.out.println("4. Mostrar Fósil");
        System.out.println("5. Generar informe");
        System.out.println("0. Salir");
    }

    public static int escogerOpcion(int minimum, int max) {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        System.out.println("Escoge una opción: ");

        try {
            option = scanner.nextInt();

            if (option > max || option < minimum) {
                System.out.println("Debes escoger una opción correcta.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("ERROR: Debes introducir un número.");
        }

        return option;
    }

    public static void creacionFicherosPrincipales(String rutaCompleta, String nombreDirectorio, String nombreFicheroDino, String nombreFicheroFosiles) {

        // Comprobar si el directorio Ficheros existe en la carpeta src
        //Hay que entender que TODO es un fichero, incluso una carpeta
        File directorio = new File(rutaCompleta + File.separator);

        if (!directorio.exists()) {
            // Si el directorio no existe, crearlo
            if (directorio.mkdir()) {
                System.out.println("Se ha creado el directorio " + nombreDirectorio + " en " +rutaCompleta);
            } else {
                System.err.println("No se ha podido crear el directorio " + nombreDirectorio);
                return;
            }
        } else {
            System.out.println("El directorio " + nombreDirectorio + " ya existe");
        }

        // Comprobar si el fichero existe dentro del directorio Ficheros
        File fichero = new File(directorio, nombreFicheroDino);

        if (fichero.exists()) {
            System.out.println("El fichero " + nombreFicheroDino + " ya existe en " + directorio);
        } else {
            try {
                // Si el fichero no existe, crearlo
                if (fichero.createNewFile()) {
                    System.out.println("Se ha creado el fichero " + nombreFicheroDino + " en " + directorio);
                } else {
                    System.err.println("No se ha podido crear el fichero " + nombreFicheroDino);
                }
            } catch (IOException e) {
                System.err.println("Error al crear el fichero: " + e.getMessage());
            }
        }

        //Creación del segundo fichero
        // Comprobar si el fichero existe dentro del directorio Ficheros
        fichero = new File(directorio, nombreFicheroFosiles);

        if (fichero.exists()) {
            System.out.println("El fichero " + nombreFicheroFosiles + " ya existe en " + directorio);
        } else {
            try {
                // Si el fichero no existe, crearlo
                if (fichero.createNewFile()) {
                    System.out.println("Se ha creado el fichero " + nombreFicheroFosiles + " en " + directorio);
                } else {
                    System.err.println("No se ha podido crear el fichero " + nombreFicheroFosiles);
                }
            } catch (IOException e) {
                System.err.println("Error al crear el fichero: " + e.getMessage());
            }
        }
    }

    public static Dinosaurio crearDino(Dinosaurio obj_dino) {

        Scanner scanner = new Scanner(System.in);
        String nombre;
        String especie;
        float altura;
        float peso;

        System.out.println("Introduce nombre:");
        nombre = scanner.nextLine();

        System.out.println("Introduce especie:");
        especie = scanner.nextLine();
        
        System.out.println("Introduce altura:");
        altura = scanner.nextFloat();
        
        System.out.println("Introduce peso:");
        peso= scanner.nextFloat();
        
        obj_dino = new Dinosaurio(nombre, especie, altura, peso, 0, null);

        return obj_dino;
    }

    public static void addDino(List<Dinosaurio> dinosaurios, Dinosaurio obj_dino) {
        
        dinosaurios.add(obj_dino);
    }
    
    
}

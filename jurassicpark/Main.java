package jurassicpark;

import jurassicpark.utils.Utils;
import Clases.Dinosaurio;
import Clases.Fosil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jurassicpark.utils.binFiles;

/**
 *
 * @author Frank.Santos
 */
public class Main {

    public static void main(String[] args) throws IOException {

        int optionMenu = -1;
        int optionDino = -1;
        int optionFosil= -1;
        Dinosaurio obj_dino = null;
        List<Dinosaurio> dinosaurios = new ArrayList<>();
        List<Fosil> fosiles = new ArrayList<>();
        boolean result;

        //START
        // Obtener la ruta de la carpeta src del proyecto
        String rutaProyecto = System.getProperty("user.dir");
        String rutaSrc = rutaProyecto + File.separator + "src" + File.separator;

        // Nombre del directorio y de los ficheros
        //La aplicación utilizará dos archivos binarios, `dinosaurs.bin` y `fosiles.bin`
        String nombreDirectorio = "datafiles";
        String nombreFicheroDino = "dinosaurs.bin";
        String nombreFicheroFosiles = "fosiles.bin";
        String rutaCompleta = rutaSrc + nombreDirectorio + File.separator;
        String rutaDinos = rutaCompleta + nombreFicheroDino + File.separator;
        String rutaFosiles = rutaCompleta + nombreFicheroFosiles + File.separator;

        //Creamos el directorio y ficheros binarios
        System.out.println("Iniciando programa...");
        Utils.creacionFicherosPrincipales(rutaCompleta, nombreDirectorio, nombreFicheroDino, nombreFicheroFosiles);

        //MENU PRINCIPAL
        do {
            Utils.menuPrincipal();
            optionMenu = Utils.escogerOpcion(Constantes.MIN_MENU_OPTION, Constantes.MAX_MENU_OPTION);

            switch (optionMenu) {

                //Añadir Dinosaurio
                case 1:
                    obj_dino = Utils.crearDino(obj_dino);
                    Utils.addDino(dinosaurios, obj_dino);
                    binFiles.escribirDinosaurios(rutaDinos, dinosaurios);

                    break;

                //Añadir Fósil
                case 2:
                    
                    do{
                    if (dinosaurios.size() != 0) {
                        System.out.println("Escoge un dinosaurio para asignarle Fósil: ");
                        Utils.listarDinos(dinosaurios);
                        optionDino = Utils.escogerOpcion(Constantes.MIN_MENU_OPTION, dinosaurios.size());
                    } else {
                        System.out.println("Todavía no hay dinosaurios registrados.");
                        System.out.println("Debe haber almenos un dinosaurio registrado para poder añadir un fósil.");
                        optionDino = 0;
                    }
                    }while(optionDino != 0);
                    break;

                //Mostrar Dinosaurio
                case 3:
                     do{
                    if (dinosaurios.size() != 0) {
                        System.out.println("Escoge un dinosaurio para asignarle Fósil: ");
                        Utils.listarDinos(dinosaurios);
                        optionDino = Utils.escogerOpcion(Constantes.MIN_MENU_OPTION, dinosaurios.size());
                    } else {
                        System.out.println("Todavía no hay dinosaurios registrados.");
                        System.out.println("Debe haber almenos un dinosaurio registrado para poder añadir un fósil.");
                        optionDino = 0;
                    }
                    }while(optionDino != 0);
                    break;

                //Mostrar Fósil
                case 4:
                    do{
                     if (fosiles.size() != 0) {
                        System.out.println("Escoge un fósil para ver sus datos: ");
                        Utils.listarDinos(dinosaurios);
                        optionFosil = Utils.escogerOpcion(Constantes.MIN_MENU_OPTION, fosiles.size());
                    } else {
                        System.out.println("Todavía no hay fósiles registrados.");
                        optionFosil = 0;
                    }
                    }while(optionFosil != 0);
                    break;

                //Generar Informe
                case 5:
                    break;

                //Salir
                case 0:
                    break;
            }

        } while (optionMenu != 0);

        System.out.println("Aplicación Cerrada."); //Exit

    } //FIN MAIN

}

package jurassicpark;

import Clases.Dinosaurio;
import java.io.File;

/**
 *
 * @author Frank.Santos
 */
public class Main {

    public static void main(String[] args) {
        int optionMenu = -1;
        Dinosaurio obj_dino = null;

        //START
        // Obtener la ruta de la carpeta src del proyecto
        String rutaProyecto = System.getProperty("user.dir");
        String rutaSrc = rutaProyecto + File.separator + "src" + File.separator;

        // Nombre del directorio y de los ficheros
        //La aplicación utilizará dos archivos binarios, `dinosaurs.bin` y `fosiles.bin`
        String nombreDirectorio = "datafiles";
        String nombreFicheroDino = "dinosaurs.bin";
        String nombreFicheroFosiles = "fosiles.bin";

        //Creamos el directorio y ficheros binarios
        System.out.println("Iniciando programa...");
        Utils.creacionFicherosPrincipales(rutaSrc, nombreDirectorio, nombreFicheroDino, nombreFicheroFosiles);

        //MENU PRINCIPAL
        do {
            Utils.menuPrincipal();
            optionMenu = Utils.escogerOpcion(Constantes.MIN_MENU_OPTION, Constantes.MAX_MENU_OPTION);
            
            switch(optionMenu){
                
                //Añadir Dinosaurio
                case 1: 
                    obj_dino = Utils.crearDino();
                    break;
                
                //Añadir Fósil
                case 2: break;
                
                //Mostrar Dinosaurio
                case 3: break;
                
                //Mostrar Fósil
                case 4: break;
                
                //Generar Informe
                case 5: break;
                
                //Salir
                case 0: break;
            }
            
        } while (optionMenu < Constantes.MIN_MENU_OPTION || optionMenu > Constantes.MAX_MENU_OPTION);

        System.out.println("Aplicación Cerrada."); //Exit

    } //FIN MAIN

}

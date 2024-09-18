package UD1.Actividad1;

import java.io.IOException;
import java.nio.file.*;

/**
 * Rafael Reina Ferrández
 * 15/09/2024
 */
public class Ejercicio6 {
    public static void main(String[] args) {
//Creamos inicialmente un archivo con el nombre que queramos
        //Creamos la ruta inicial
        Path pathInicio = Paths.get(args[0]);
        //Creamos la ruta final
        Path pathDestino=Paths.get("Files/Files2/Prueba2.txt");

        //Verificamos si la ruta inicial existe y si el directorio final también
        if (Files.exists(pathInicio) && Files.isDirectory(pathDestino.getParent())) {
            try {
                //Si existe se mueve el archivo 1 al archivo 2
                Files.move(pathInicio,pathDestino);
                //Comprobamos que no existe en el directorio inicial y si existe en el final
                if(!Files.exists(pathInicio) && Files.exists(pathDestino)){
                    //Imprimimos ruta y mensaje
                    System.out.println("Archivo movido recientemente: "+pathDestino);
                    System.out.println("Archivo movido correctamente." );
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}

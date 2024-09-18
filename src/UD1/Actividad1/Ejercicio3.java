package UD1.Actividad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Rafael Reina Ferrández
 * 15/09/2024
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        //Obtenemos la ruta
        Path path= Paths.get(args[0]);
        //Se comprueba si existe el archivo
        //Si el archivo existe
        if(Files.exists(path)){
            try{
                //Se escribe en la ruta seleccionada la frase insertada en el arhivo que ha sido previamente borrado por el Truncate_Existing
                Files.writeString(path,"Se ha borrado el anterior archivo y se ha escrito la nueva frase", StandardOpenOption.TRUNCATE_EXISTING);
                //Se imprime por consola
                System.out.println("Se ha completado la reescritura de tu archivo. Comprueba el archivo");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }
}

package UD1.Actividad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Rafael Reina Ferrández
 * 15/09/2024
 */

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        //Obtenemos la ruta
        Path path= Paths.get(args[0]);
        //Se activa el Scanner
        Scanner sc=new Scanner(System.in);
        //Solicitamos al usuario la palabra que desea buscar
        System.out.println("Inserta la palabra que desea buscar:");
        //Pasamos la palabra a minuscula
        String palabra=sc.nextLine().toLowerCase();
        //Se comprueba si esta creado
        if(Files.exists(path)){
            System.out.println("Archivo disponible");
            //Llamamos al método donde se cuentan la palabra deseada
            System.out.println("Las veces que aparecen es de: "+ contadorPalabras(path, palabra));
        }else{
            System.out.println("Archivo no localizado en el sistema");
        }


    }

    /**
     * Método utilizado para ver cuantas veces se repite la palabra deseada en el archivo
     * @param path ruta del archivo
     * @param palabra que se desea buscar
     * @return se devuelve el numero de veces
     * @throws IOException
     */
    public static long contadorPalabras(Path path, String palabra) throws IOException{
        //Creamos un array para dividir la cadena en fragmentos separados por la palabra deseada
        String[]partes=Files.readString(path).split(palabra);
        //Devolvemos el tamaño del array con el numero de apariciones del array-1
        return partes.length-1;
    }
}

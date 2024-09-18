package UD1.Actividad1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Rafael Reina Ferrández
 * 15/09/2024
 */
public class Actividad1 {
    public static void main(String[] args) throws IOException {
        //Obtenemos la ruta
        Path path= Paths.get(args[0]);
        //Se comprueba si el archivo existe
        if(Files.exists(path)){
            System.out.println("El archivo se encuentra disponible");
            //Si existe
            try{
                //Se crea una lista de Strings a partir de todas las lineas del Archivo
                List<String> lineas=Files.readAllLines(path);
                //Imprimimos cada linea
                lineas.forEach(linea-> System.out.println(linea));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            //Si no existe
            try{
                //Creamos el archivo
                Files.createFile(path);

                //Activamos el Scanner
                Scanner sc=new Scanner((System.in));
                System.out.println("Escribe hasta que pongas <FIN>");
               String respuesta="";
                do{
                    //Leemos la respuesta del usuario
                    respuesta =sc.nextLine();
                    //Introducimos esta frase
                    Files.writeString(path,"Este es el nuevo archivo creado", StandardOpenOption.APPEND);
                    //Escribe cada frase introducida hasta que sea "FIN"
                    /**
                     * He buscado como crear lineas de texto separadas (System.lineSeparator()) porque cuando las introducía salían seguidas y se leía mal
                     */
                    Files.writeString(path, respuesta+System.lineSeparator(),StandardOpenOption.APPEND);

                }while(!respuesta.equalsIgnoreCase("FIN"));


           }catch (IOException e){
                throw new RuntimeException(e);

           }

        }

    }
}

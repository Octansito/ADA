package UD1.Actividad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio2 {
        public static void main(String[] args) {

           Path path=Path.of("Directorio1");
            Scanner sc=new Scanner(System.in);

            System.out.println("Introduce el nombre del fichero que desea buscar");
            String nombreFichero=sc.nextLine();


            if(Files.exists(path)){
                boolean existe=existeFichero(path,nombreFichero);
                System.out.println("El archivo "+nombreFichero+" ha sido encontrado en la carperta? "+ existe);
            }else{
                System.out.println("Directorio no encontrado");
            }

        }

        public static boolean existeFichero(Path path, String nombreFichero){

            boolean existeArchiv;

            try(Stream<Path> archivosDirectorio= Files.walk(path, Integer.MAX_VALUE)){
                existeArchiv=archivosDirectorio
                        .filter(archivo->archivo.getFileName().toString().equals(nombreFichero))
                        .findFirst()
                        .isPresent();

            }catch (IOException e){
                throw new RuntimeException(e);
            }

            return existeArchiv;
        }
    }



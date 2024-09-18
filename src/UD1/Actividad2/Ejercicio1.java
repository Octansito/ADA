package UD1.Actividad2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Ejercicio1 {

    public static void main(String[] args) {
        Path path=Path.of("Directorio1");
        Path path1=Path.of("Directorio2");

        if(Files.exists(path) && Files.exists(path1)){
            compararDirectorios(path,path1);
        }
    }

    public static void compararDirectorios(Path ruta1, Path ruta2){

        if(Files.isDirectory(ruta1) && Files.isDirectory(ruta2)){

            try(Stream<Path> archivosDirectorio1 = Files.walk(ruta1, 1);
                Stream<Path> archivosDirectorio2 = Files.walk(ruta2, 1)){

                List<String> listaArchivosDir1= archivosDirectorio1
                        .map(archivo -> archivo.getFileName().toString())
                        .toList();

                List<String>listaArchivDir2=archivosDirectorio2
                        .map(archivo2->archivo2.getFileName().toString())
                        .toList();

                List<String> elementos=new ArrayList<>();

                listaArchivosDir1.forEach(elemento->{
                   if( !listaArchivDir2.contains(elemento)){
                       elementos.add(elemento);
                   };

                });
                for(int i=0; i<elementos.size();i++){
                    System.out.println(elementos.get(i));
                }



            }catch (IOException e){
                throw new RuntimeException(e);
            }

        }

    }
}

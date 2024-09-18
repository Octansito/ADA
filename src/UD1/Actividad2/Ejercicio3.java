package UD1.Actividad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ejercicio3 {
    public static void main(String[] args) {
        Path path= Paths.get(args[0]);

        if(Files.exists(path)){
            //Transformamos el Stream en una lista
            try(Stream<Path>archivos=Files.walk(path,Integer.MAX_VALUE)){
                    List<Path> lista=archivos.toList();

                    Long tamanoTotal= lista.stream()
                          .filter(archivo->Files.isRegularFile(archivo))

                          .mapToLong(archivo-> {
                              try {
                                  return Files.size(archivo);
                              } catch (IOException e) {
                                  throw new RuntimeException();
                              }

                          })

                            .sum();
                    int numFicheros=lista.size();
                    Long numTotalDirectorios=lista.stream()
                            .filter(directorio->Files.isDirectory(directorio))
                            .count();

                System.out.printf("Tienes un total de "+numTotalDirectorios+" directorios.El tamaño de los archivos es de "+tamanoTotal+" bytes y contiene un total de "+numFicheros+ " ficheros");


            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}

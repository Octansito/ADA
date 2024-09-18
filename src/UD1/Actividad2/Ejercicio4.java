package UD1.Actividad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio4 {
    public static void main(String[] args) {
        Path path= Paths.get(args[0]);
        if(Files.exists(path)){
            try(Stream<Path> archivos=Files.find(path, Integer.MAX_VALUE,(p, attr)->Files.isRegularFile(p))){

                List<String> listaArchivos = archivos
                        .map(archivo -> archivo.getFileName().toString())
                        .toList();
                Set<String> listaSinRepetir=new HashSet<>(listaArchivos);


                int cantidadRepetidos=listaArchivos.size()-listaSinRepetir.size();
                System.out.println("La cantidad de repetidos es: "+cantidadRepetidos);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

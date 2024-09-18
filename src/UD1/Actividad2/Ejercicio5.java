package UD1.Actividad2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio5 {
    public static void main(String[] args) {
        Path path = Path.of("Directorio1");
        if (Files.exists(path)) {
            System.out.println(contadorDirectoriosVacios(path));
        } else {
            System.err.println("Error de Directorio");
        }
    }

    public static int contadorDirectoriosVacios(Path path) {
        int contador = 0;
        try (Stream<Path> directorios = Files.find(path, Integer.MAX_VALUE, (p, attr) -> Files.isDirectory(p))) {

            List<Path> listaDirectorios = directorios.toList();

            for (Path directorio : listaDirectorios) {
                try (Stream<Path> contenido = Files.list(directorio)) {
                    if (contenido.findAny().isEmpty()) {
                        contador++;
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }
}

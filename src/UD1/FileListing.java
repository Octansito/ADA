package UD1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Filtrar y listar ficheros
 */
public class FileListing {
    //BiPredicate <Path, atributo>
    //(path, atributo)->
    public static void main(String[] args) {
        //Antes de java.nio
        File file=new File("files");
        //Te devuelve un array
        File[] files=file.listFiles();
        for(File f:files){
            System.out.println(f.getName());
        }


        //Nuevos métodos
        //Files.list-->Devuelve un stream<Path> "no lee contenido dentro del archivo, lee archivos y carpetos. No es recursivo (devuelve en donde estoy)"
        //Files.walk-->Devuelve un stream<Path> "si es recursivo, entra en todo"
        //Files.find-->Devuelve un stream<Path> "si es recursivo. Presenta un predicate que te ayuda a buscar"
        /**
         * Path path= Path.of("files");
         *         try(Stream<Path> stream= Files.list(path)){
         *             stream.forEach(System.out::println);
         *         }catch (IOException e){
         *             System.err.println("Error...");
         *         }
         */

        /**
         * Path path= Path.of("files");
         *          //Si pongo 0 se queda en la base, 1 muestra el contenido del directorio, y Integer.Max_Value es la maxima profundidad
         *         try(Stream<Path> stream= Files.walk(path, 0)){
         *             stream.forEach(path1-->System.out.println(path1.getFileName().toString() + " " + Files.size(path) + " " + Files.getModifiedTime(path1);
         *         }catch (IOException e){
         *             System.err.println("Error...");
         *         }
         */
        /**
         * Path path= Path.of("files");
         *         try(Stream<Path> stream= Files.find(path, Integer.MaxValue, (p, attr)->Files.isRegularFile(p){
         *             stream.forEach(System.out::println);
         *         }catch (IOException e){
         *             System.err.println("Error...");
         *         }
         */





    }
}

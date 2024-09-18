package UD1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AccesoFicher {
    public static void main(String[] args){
        //FileReader,FileWriter,File,BufferedReader,BufferedWriter
        //Files, Path
        /**
         * imports io es un import viejo
         * imports nio es un import nuevo
         */
        //Primer tipo de try-catch
        //Para crear el import de file. Hacer el try cacth no el throwable en el main
        try{
            FileWriter fw2=new FileWriter("Archivo1.txt");
            //El problema de este try catch es que si erra el "Hola", no se cierra y se ejecuta siempre la excepción
            fw2.write("Hola");
            //Ahora cerramos el filewriter
            fw2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        //Try with resources.
        //Segundo tipo de try-catch, se instancia el File y no se ejecuta
        try (FileWriter fw = new FileWriter("files/fichero1.txt")){
            fw.write("texto de prueba");
        } catch (IOException e) {
            System.err.println("Error");
        }

        //File --> sirve para gestionar rutas , directorios y ficheros
        File file = new File("files/fichero1.txt");
        if (file.exists()){
            System.out.println("El fichero existe");
        }
        System.out.println(file.getAbsoluteFile());





        //Files, Path, Paths
        Path path2 = Paths.get("files");

        //USAR ESTE
        //Cuando crear Files, es OBLIGATORIO crear un objeto path (es la ruta del fichero)
        Path path = Path.of("files/fichero1.txt");
        if (Files.exists(path)){
            System.out.println("si");
        }
        try{
            //Si no pones el append, el archivo de sobreescribe
            //Transformas el String en Bytes
            Files.write(path,"Soy Patri".getBytes(), StandardOpenOption.APPEND);
            //Pasas el String de manera directa
            Files.writeString(path,"estoy en clase de ada", StandardOpenOption.APPEND);
            //Para saber el numero total de lines primera forma
            List<String> lines=Files.readAllLines(path);
            System.out.println(lines.size());
            //Obtner numero total de lineas segunda forma
            System.out.println(Files.readAllLines(path).stream().count());
            String textoTotal=Files.readString(path, StandardCharsets.UTF_8);
            //Borrar ficher -->Files.delete();
            //Copiar el fichero a otro lado-->Files.copy();
            
            /**Formas de buscar en un fichero
             * Files.readAllLines(path).stream()
             *      .count()
             * Files.readAllLines(path).stream()
             *      .filter(linea-->linea.contains("ADA")
             *      .toList();
             * **/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

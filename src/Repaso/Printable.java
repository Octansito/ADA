package Repaso;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.*;


public interface Printable {
    /**
     * Método sin cuerpo. Para implementar este método de diferentes frases se usan los lambdas
     * @return
     */
     String print (int data, String data2);

     //Todas las variables que me creo en una interfaz son public static final
     int NUM_PAGINAS=2;
     //final --> constante
    //static --> no hace falta crear un objeto para llamar al método o variable

    /**
     *  Para crear método con cuerpo se usa "default"
     *     default void test(){
     */






    /**
     * Mirar primero la clase Repaso.Impresora
     */
    class TestPrintable{
        public static void main(String[] args) {
            //No puedo crear un objeto de la interfaz porque no tiene cuerpo de constructor y no se ejectuará nada
            //Se puede crear un objeto Repaso.Impresora con la interfaz Repaso.Printable porque la clase Repaso.Impresora le aporta el el cuerpo

            Printable p= (Printable) new Impresora();

            //Para implementar un lambda. Solo se implementan en interfaces funcionales, que solamente tienen un único método abstracto
            //Nombre del objeto    (elementos que recibe el método) flecha paréntesis y devuelve lo que quieres imprimir
            Printable p2= (x,x1) -> {
                return "";
            };
            /** Si se devuelve en la misma linea se podría escribir asi y solo tiene un parámetro
            Repaso.Printable p3= y -> "";
             **/

            Predicate<Integer> pre= x -> x==0;

            Consumer<String> frase=(x)-> System.out.println();
            frase.accept("Hoy es maetes");

            Supplier<String>proveedor=()->"t";

            Function<String, Boolean> esIgualHola= str->str.equals("hola");

            //Ejectuamos el function
             boolean resultado=esIgualHola.apply("Adios");

             //Implementa un lambda que devuelva el doble de un numero
            Function<Integer, Integer>dobleNum=valor->valor*2;

            //Crea un lamdba que devuelva true o false si un numero es par
            Function<Integer,Boolean>esPar=num->num%2==0;
            boolean resultado1=esPar.apply(0);
            System.out.println(resultado1);
            Predicate<Integer> esPar2=valor1-> valor1%2==0;

            //Crea un lambda que sume dos numeros
            BiConsumer<Integer, Integer>sumaNum=(num1, num2)-> System.out.print(num1+num2);
            sumaNum.accept(10,16);
            BiFunction<Integer, Integer, Integer>sumaTotal=(num3,num4)-> {
                return num3+num4;

            };
            int resultado2=sumaTotal.apply(43,67);
            System.out.println(resultado2);

            //Crea un lambda que convierta y devuelva una cadena en minúsculas
            Function<String, String> convertirFrase=frase1-> frase1.toLowerCase();

            String resultFrase=convertirFrase.apply("EMPEZAMOS");
            System.out.println(resultFrase);

            //Crea un lambda que compare la longitud de dos cadenas y devuelva la más larga
            BiFunction<String, String, String> cadenaLarga=(frase2, frase3)->{

                if(frase2.length()>frase3.length()){
                    return frase2;
                }
                return frase3;
            };
            String oracion=cadenaLarga.apply("Programacion", "Programacion");
            System.out.println(oracion);

            //Lambda de comparación y ordenación
            Comparator<Double>sort=(n1,n2)->{
                if(n1==2) return 0;
                else if(n1<n2) return -1;
                else return 1;
            };
            Comparator<Integer>sort1=(n3,n4)-> n3-n4;
            Comparator<String> sortSrt=(s1,s2)-> s2.compareTo(s1);

            //Streams
            //Necesito unacoleccion, operaciones,intermedias, operaciones terminal
            List<Integer> enteros= Arrays.asList(1,2,4,5,6,67,7,3,-8,-24,10);
            enteros.forEach(num-> System.out.print(num +" "));
            enteros.stream()
                    .filter(num->num>0)
                    //Referencia de métodos
                    .map(n->n*2)
                    .toList();
            /**
             * Operacioes intermedias
             * filter, sorted, limit, skip, peek,map
             */

            /**Operaciones terminales
             * forEach, max, min, count, findAny, collect, toList
             */

            //flatmap
            List<List<Integer>>listaDeList=Arrays.asList(
                    Arrays.asList(1,2,3),
                    Arrays.asList(-44,-5,6)
            );
            listaDeList.stream()
                    .flatMap(list->list.stream())
                    .map(n->n+1)
                    .toList();

            Libreria carrus=new Libreria("Carrus","Plaza Madrid");
            Libro harryPotter=new Libro("Harry Potter","JK Rowling", 569);
            carrus.addLibro(harryPotter);
            Libro lasBrujas=new Libro("Las Brujas","Roald",7);
            carrus.addLibro(lasBrujas);
            Libro troll=new Libro("Troll","Anónimo", 190);
            carrus.addLibro(troll);

            //mostrar todos los libros dela libreria de carrus, el autor
            carrus.getLibros().stream().forEach(libro-> System.out.println(libro.getAutoor()));

            //mostrar los libros ordeandos por autor descendente que tengan mas de 10 paginas y el titulo del ISBN
            carrus.getLibros().stream()
                    .sorted((lb1,lb2)->lb2.getAutoor().compareTo(lb1.getAutoor()))
                    .filter(libro->libro.getNumPag()>10)
                    .forEach(libro -> System.out.println(libro.getISBN()));


            Libreria Altabix =new Libreria("Altabix","Altabix");
            Libro elPlanetaTesoro=new Libro("El planeta del tesoro", "Not found", 1603);
            Libro elPrincipito=new Libro("elPrincipito", "Rafa", 8);
            Libro DiarioAnneFrank=new Libro("DiarioAnneFrank", "Test", 235);
            Altabix.addLibro(elPrincipito);
            Altabix.addLibro(elPlanetaTesoro);
            Altabix.addLibro(DiarioAnneFrank);

            List<Libreria>libreriasELCHE=Arrays.asList(carrus,Altabix);

            /**
             * Contar el numero total de libros totales de las librerias
             */
            long cantidadLibros= libreriasELCHE.stream()
                    .flatMap(listaLibros->listaLibros.getLibros().stream())
                    .count();
            System.out.println(cantidadLibros);

            /**
             * De todos los libros con menos de 10 pag, actualizarlos y ponerlos a 0
             *Recoger en una lista con solo el nombre de esos libros con 0 hojas
             */

            libreriasELCHE.stream().flatMap(listaLibros->listaLibros.getLibros().stream())
                    .filter(libro -> libro.getNumPag()<10)
                    .peek(libro -> libro.setNumPag(0))
                    .forEach(libro-> System.out.println(libro.getISBN()+" "+libro.getNumPag()));






























































        }

    }

}
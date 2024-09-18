package Repaso;

import java.util.ArrayList;
import java.util.List;

class Libro{
    private String ISBN;
    private String autoor;
    private int numPag;

    public Libro(String ISBN, String autoor, int numPag) {
        this.ISBN = ISBN;
        this.autoor = autoor;
        this.numPag = numPag;
    }

    public String getISBN() {
        return ISBN;
    }



    public String getAutoor() {
        return autoor;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public int getNumPag() {
        return numPag;
    }


}


public class Libreria {
    private String nombre;
    private String direccion;
    private List<Libro> libros;

    public Libreria(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
        libros=new ArrayList<>();
    }
    public void addLibro(Libro libro){
        this.libros.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }
}

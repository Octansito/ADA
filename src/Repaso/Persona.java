package Repaso;

public class Persona {
    private String nombre;
    //Ojo vale lo mismo para todos los objetos persona. Todos los objetos comparten esta variable aunque se creen 50 personas
    //Static solo pertenece a la clase, no al objeto
    private static int numOjos;

    public Persona(String nombre) {
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void main (String[] args){
        //Para acceder a la variable nombre he de crear un objeto
        Persona p=new Persona("Rafa");
        Persona p2=new Persona("Andrea");

    }
}

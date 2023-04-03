
package clases;
public class Cliente {
    private String nombre;
    private String direccion;
    private String dni;
    private Animal animal;

    public Cliente(String nombre, String direccion, String dni, Animal animal) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.animal = animal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public Animal getAnimal() {
        return animal;
    }
}
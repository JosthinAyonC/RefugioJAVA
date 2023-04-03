
package clases;
public class Perro extends Animal {
    public Perro(String nombre, int edad, double peso, String raza) {
        super(nombre, edad, peso, raza);
    }

    @Override
    public String getTipo() {
        return "Perro";
    }
}
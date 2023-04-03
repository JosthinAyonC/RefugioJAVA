
package clases;

public class Hamster extends Animal {
    public Hamster(String nombre, int edad, double peso, String raza) {
        super(nombre, edad, peso, raza);
    }

    @Override
    public String getTipo() {
        return "Hamster";
    }
}
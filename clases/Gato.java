
package clases;
public class Gato extends Animal {
    public Gato(String nombre, int edad, double peso, String raza) {
        super(nombre, edad, peso, raza);
    }

    @Override
    public String getTipo() {
        return "Gato";
    }
}

package clases;

public abstract class Animal {
    private String nombre;
    private int edad;
    private double peso;
    private String raza;

    public Animal(String nombre, int edad, double peso, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", raza=" + raza + '}';
    }

    public abstract String getTipo();
}
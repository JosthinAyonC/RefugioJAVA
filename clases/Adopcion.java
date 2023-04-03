
package clases;

import java.time.LocalDate;

public class Adopcion {
    private Cliente cliente;
    private Animal animal;
    private LocalDate fechaAdopcion;

    public Adopcion(Cliente cliente, Animal animal) {
        this.cliente = cliente;
        this.animal = animal;
        this.fechaAdopcion = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalDate getFechaAdopcion() {
        return fechaAdopcion;
    }

    @Override
    public String toString() {
        return "Adopcion{" +
                "cliente=" + cliente.getNombre() +
                ", animal=" + animal.getNombre() +
                ", fechaAdopcion=" + fechaAdopcion +
                '}';
    }
}
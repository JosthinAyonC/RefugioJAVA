package clases;

import Exepciones.AnimalInvalidoException;
import Exepciones.AnimalNoEncontradoException;
import Exepciones.ClienteInvalidoException;
import Exepciones.ClienteNoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class Refugio {

    private List<Animal> animales;
    private List<Cliente> clientes;
    private List<Adopcion> adopciones;

    public Refugio() {
        this.animales = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.adopciones = new ArrayList<>();
    }

    public List<Animal> getAnimales() {
        return animales;
    }
    

    public void registrarAdopcion(Cliente cliente) throws ClienteInvalidoException, AnimalInvalidoException {
        if (cliente == null) {
            throw new ClienteInvalidoException("El cliente es nulo");
        }
        if (cliente.getAnimal() == null) {
            throw new AnimalInvalidoException("El animal es nulo");
        }
        if (!animales.contains(cliente.getAnimal())) {
            throw new AnimalInvalidoException("El animal no se encuentra en el refugio");
        }
        clientes.add(cliente);
        animales.remove(cliente.getAnimal());
        Adopcion adopcion = new Adopcion(cliente, cliente.getAnimal());
        adopciones.add(adopcion);
    }

    public List<Animal> buscarPorRaza(String raza) throws AnimalNoEncontradoException {
        List<Animal> resultado = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getRaza().equals(raza)) {
                resultado.add(animal);
            }
        }
        if (resultado.isEmpty()) {
            throw new AnimalNoEncontradoException("No se encontraron animales con la raza especificada");
        }
        return resultado;
    }

    public List<Animal> buscarPorTipo(String tipo) throws AnimalNoEncontradoException {
        List<Animal> resultado = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getTipo().equals(tipo)) {
                resultado.add(animal);
            }
        }
        if (resultado.isEmpty()) {
            throw new AnimalNoEncontradoException("No se encontraron animales del tipo especificado");
        }
        return resultado;
    }

    public List<Cliente> buscarClientesPorAnimal(Animal animal) throws ClienteNoEncontradoException {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getAnimal().equals(animal)) {
                resultado.add(cliente);
            }
        }
        if (resultado.isEmpty()) {
            throw new ClienteNoEncontradoException("No se encontraron clientes que adoptaron el animal especificado");
        }
        return resultado;
    }

    public List<Animal> buscarPorEdad(int edad) throws AnimalNoEncontradoException {
        List<Animal> resultado = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getEdad() == edad) {
                resultado.add(animal);
            }
        }
        if (resultado.isEmpty()) {
            throw new AnimalNoEncontradoException("No se encontraron animales de la edad especificada");
        }
        return resultado;
    }

    public List<Adopcion> getAdopciones() {
        return adopciones;
    }
}

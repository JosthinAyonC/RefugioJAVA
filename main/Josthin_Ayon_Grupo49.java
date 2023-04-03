package main;

import Exepciones.AnimalInvalidoException;
import Exepciones.AnimalNoEncontradoException;
import Exepciones.ClienteInvalidoException;
import clases.Adopcion;
import clases.Animal;
import clases.Cliente;
import clases.Gato;
import clases.Hamster;
import clases.Perro;
import clases.Refugio;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Josthin_Ayon_Grupo49 {

    public static void main(String[] args) throws AnimalInvalidoException, AnimalNoEncontradoException {
        Scanner sc = new Scanner(System.in);

        Refugio refugio = new Refugio();

        int opcion;

        do {
            System.out.println("------- MENU -------");
            System.out.println("1. Registrar animal");
            System.out.println("2. Registrar adopcion");
            System.out.println("3. Buscar animales por raza");
            System.out.println("4. Buscar animales por tipo de animal");
            System.out.println("5. Buscar animales por edad");
            System.out.println("6. Buscar clientes que han adoptado un animal");
            System.out.println("0. Salir");

            do {
                System.out.print("Ingrese la opcion que desea: \n");

                try {
                    opcion = sc.nextInt();
                    if (opcion == 0) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("///Ingrese una opcion valida.///");
                    sc.next();
                    opcion = -1;
                }

            } while (opcion < 1 || opcion > 5);

            switch (opcion) {
                case 1 -> {
                    String nombre, raza, tipo;
                    int edad;
                    double peso;

                    sc.nextLine();
                    System.out.print("Ingrese nombre del animal: ");
                    nombre = sc.nextLine();

                    System.out.print("Ingrese edad del animal: \n");
                    edad = sc.nextInt();
                    
                    sc.nextLine();
                    System.out.print("Ingrese peso del animal: \n");
                    peso = sc.nextDouble();
                    
                    sc.nextLine();
                    System.out.print("Ingrese raza del animal: ");
                    raza = sc.nextLine();

                    Animal animal;

                    while (true) {
                        tipo = null;
                        System.out.print("Ingrese tipo de animal (Perro/Gato/Hamster): ");
                        tipo = sc.nextLine();

                        if (tipo.equalsIgnoreCase("Perro")) {

                            animal = new Perro(nombre, edad, peso, raza);

                            System.out.println("=============================ANIMAL RECIBIDO!============================== \n");
                            break;

                        } else if (tipo.equalsIgnoreCase("Gato")) {

                            animal = new Gato(nombre, edad, peso, raza);
                            System.out.println("=============================ANIMAL RECIBIDO!============================== \n");
                            break;

                        } else if (tipo.equalsIgnoreCase("Hamster")) {

                            animal = new Hamster(nombre, edad, peso, raza);
                            System.out.println("=============================ANIMAL RECIBIDO!============================== \n");
                            break;

                        } else {
                            System.out.println("///Ingrese un animal valido valida.///");
                        }
                    }

                }
                case 2 -> {

                    sc.nextLine();
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese direccion del cliente: ");
                    String direccion = sc.nextLine();
                    
                    System.out.print("Ingrese DNI del cliente: ");
                    String dni = sc.nextLine();

                    System.out.println("Seleccione el animal que desea adoptar:");

                    List<Animal> animales = refugio.getAnimales();

                    for (int i = 0; i < animales.size(); i++) {
                        Animal animal = animales.get(i);
                        System.out.println((i + 1) + ". " + animal.getNombre() + " (" + animal.getTipo() + ")\n");
                    }
                    sc.nextLine();
                    int opc = sc.nextInt();

                    if (opc < 1 || opc > animales.size()) {
                        System.out.println("Opción inválida.");
                        return;
                    }

                    Animal animal = animales.get(opc - 1);

                    try {
                        refugio.registrarAdopcion(new Cliente(nombre, direccion, dni, animal));
                        System.out.println("Adopción registrada con éxito.");
                    } catch (ClienteInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese la raza de los animales que desea buscar: ");
                    String raza = sc.nextLine();

                    List<Animal> animales = refugio.buscarPorRaza(raza);

                    if (animales.isEmpty()) {
                        System.out.println("No se encontraron animales de la raza especificada.");
                    } else {
                        System.out.println("Animales de la raza " + raza + ":");
                        for (Animal animal : animales) {
                            System.out.println(animal);
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el nombre del animal: ");
                    String nombreAnimal = sc.nextLine();

                    List<Adopcion> adopciones = refugio.getAdopciones();

                    boolean encontrado = false;

                    for (Adopcion adopcion : adopciones) {
                        if (adopcion.getAnimal().getNombre().equalsIgnoreCase(nombreAnimal)) {
                            System.out.println("Cliente: " + adopcion.getCliente().getNombre());
                            System.out.println("DNI: " + adopcion.getCliente().getDni() + "\n");
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontraron adopciones para el animal ingresado.\n");
                    }
                }

                case 5 -> {
                    System.out.print("Ingrese la edad del animal que desea buscar: ");
                    int ed = sc.nextInt();
                    List<Animal> animales = refugio.buscarPorEdad(ed);
                    if (animales.isEmpty()) {
                        System.out.println("No se encontraron animales con la edad ingresada");
                    } else {
                        System.out.println("Animales con edad " + ed + ":");
                        for (Animal animal : animales) {
                            System.out.println(animal);
                        }
                    }
                }

                case 6 -> {
                    System.out.print("Ingrese el nombre del animal: ");
                    String nombreAnimal = sc.nextLine();

                    List<Adopcion> adopciones = refugio.getAdopciones();

                    boolean encontrado = false;

                    for (Adopcion adopcion : adopciones) {
                        if (adopcion.getAnimal().getNombre().equalsIgnoreCase(nombreAnimal)) {
                            System.out.println("Cliente: " + adopcion.getCliente().getNombre() );
                            System.out.println("DNI: " + adopcion.getCliente().getDni() + "\n");
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontraron adopciones para el animal ingresado.\n");
                    }
                }
                case 0 ->
                    System.out.println("Saliendo del programa...");
                default ->
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

}

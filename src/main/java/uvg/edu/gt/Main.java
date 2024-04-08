package uvg.edu.gt;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase principal que maneja el programa de atención de emergencias.
 * 
 * @author Cristian Túnchez
 * @version 1.0
 * @since 08/04/2024
 */
public class Main {
    /**
     * Método principal que inicia el programa.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Se crea una instancia de la clase Emergencias para manejar las operaciones
        // relacionadas con las emergencias.
        Emergencias emergencias = new Emergencias();
        // Se crea un objeto Scanner para leer la entrada del usuario desde la consola.
        Scanner entradas = new Scanner(System.in);
        // Variables booleanas para controlar los menús.
        boolean menu1 = true;
        boolean menu2 = false;
        // Variable para almacenar la opción seleccionada por el usuario.
        String opcion = "";

        // Ciclo para mostrar el primer menú y validar la selección del usuario.
        while (menu1) {
            System.out.println("\n----------------------| Programa de Atención de Emergencias |----------------------");
            System.out.println(
                    "\n[Sistema]: ¿Qué implementación desea usar?\n1. Priority Queue JCF\n2. Priority Queue con VectorHeap");
            opcion = entradas.nextLine();

            // Si la opción es válida, se cambia el estado de los menús para avanzar al
            // siguiente paso.
            if (opcion.equals("1") || opcion.equals("2")) {
                menu1 = false;
                menu2 = true;
                break;
            }
            System.out.println("\n[Sistema]: Ingrese una opción válida del menú.");
        }

        // Switch para manejar las diferentes opciones seleccionadas por el usuario.
        switch (opcion) {
            case "1": {
                try {
                    // Se llama al método para agregar pacientes utilizando la implementación de
                    // Priority Queue de la Java Collections Framework (JCF).
                    emergencias.agregarPacientesJCF();
                    // Ciclo para mostrar el segundo menú y realizar las operaciones según la
                    // selección del usuario.
                    while (menu2) {
                        System.out.println(
                                "\n[Sistema]: ¿Qué desea hacer?\n1. Ver la lista de Pacientes\n2. Pedir al siguiente Paciente\n3. Salir");
                        opcion = entradas.nextLine();
                        switch (opcion) {
                            case "1": {
                                // Mostrar la lista de pacientes en espera.
                                System.out.println(
                                        "\n----------------------| Lista de Pacientes en Espera |----------------------\n");
                                System.out.println(emergencias.listaDePacientesJCF());
                                break;
                            }
                            case "2": {
                                // Pedir al siguiente paciente.
                                System.out.println("\n[Sistema]: El siguiente paciente es:");
                                System.out.println(emergencias.siguientePacienteJCF());
                                break;
                            }
                            case "3": {
                                // Salir del programa.
                                System.out.println(
                                        "\n[Sistema]: Gracias por usar el sistema de emergencias PriorityQueue :)\n");
                                menu2 = false;
                                break;
                            }
                            default: {
                                // Mensaje de error para opciones inválidas.
                                System.out.println("\n[Sistema]: Elige una opción válida del menú.");
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    // Manejo de excepciones en caso de que no se pueda encontrar el archivo
                    // pacientes.txt.
                    System.out.println("\n[Sistema]: No se pudo encontrar el archivo pacientes.txt");
                    e.printStackTrace();
                }
                break;
            }
            case "2": {
                try {
                    // Se llama al método para agregar pacientes utilizando la implementación de
                    // Priority Queue con VectorHeap.
                    emergencias.agregarPacientes();
                    // Ciclo para mostrar el segundo menú y realizar las operaciones según la
                    // selección del usuario.
                    while (menu2) {
                        System.out.println(
                                "\n[Sistema]: ¿Qué desea hacer?\n1. Ver la lista de Pacientes\n2. Pedir al siguiente Paciente\n3. Salir");
                        opcion = entradas.nextLine();
                        switch (opcion) {
                            case "1": {
                                // Mostrar la lista de pacientes en espera.
                                System.out.println(
                                        "\n----------------------| Lista de Pacientes en Espera |----------------------\n");
                                System.out.println(emergencias.listaDePacientes());
                                break;
                            }
                            case "2": {
                                // Pedir al siguiente paciente.
                                System.out.println("\n[Sistema]: El siguiente paciente es:");
                                System.out.println(emergencias.siguientePaciente());
                                break;
                            }
                            case "3": {
                                // Salir del programa.
                                System.out.println(
                                        "\n[Sistema]: Gracias por usar el sistema de emergencias PriorityQueue :)\n");
                                menu2 = false;
                                break;
                            }
                            default: {
                                // Mensaje de error para opciones inválidas.
                                System.out.println("\n[Sistema]: Elige una opción válida del menú.");
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    // Manejo de excepciones en caso de que no se pueda encontrar el archivo
                    // pacientes.txt.
                    System.out.println("\n[Sistema]: No se pudo encontrar el archivo pacientes.txt");
                    e.printStackTrace();
                }
                break;
            }
            default: {
                // Mensaje de error para opciones no válidas.
                System.out.println("\n[Sistema]: Este es un código inalcanzable. No deberías estar aquí.");
                break;
            }
        }
        // Se cierra el Scanner después de su uso para liberar recursos.
        entradas.close();
    }
}
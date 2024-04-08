package uvg.edu.gt;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Emergencias emergencias = new Emergencias();
        Scanner entradas = new Scanner(System.in);
        boolean menu1 = true;
        boolean menu2 = false;
        String opcion = "";

        while (menu1) {
            System.out.println("\n----------------------| Programa de Atención de Emergencias |----------------------");
            System.out.println(
                    "\n[Sistema]: ¿Qué implementación desea usar?\n1. Priority Queue JCF\n2. Priority Queue con VectorHeap");
            opcion = entradas.nextLine();

            if (opcion.equals("1") || opcion.equals("2")) {
                menu1 = false;
                menu2 = true;
                break;
            }
            System.out.println("\n[Sistema]: Ingrese una opción válida del menú.");
        }

        switch (opcion) {
            case "1": {
                try {
                    emergencias.agregarPacientesJCF();
                    while (menu2) {
                        System.out.println(
                                "\n[Sistema]: ¿Qué desea hacer?\n1. Ver la lista de Pacientes\n2. Pedir al siguiente Paciente\n3. Salir");
                        opcion = entradas.nextLine();
                        switch (opcion) {
                            case "1": {
                                System.out.println(
                                        "\n----------------------| Lista de Pacientes en Espera |----------------------\n");
                                System.out.println(emergencias.listaDePacientesJCF());
                                break;
                            }
                            case "2": {
                                System.out.println("\n[Sistema]: El siguiente paciente es:");
                                System.out.println(emergencias.siguientePacienteJCF());
                                break;
                            }
                            case "3": {
                                System.out.println(
                                        "\n[Sistema]: Gracias por usar el sistema de emergencias PriorityQueue :)\n");
                                menu2 = false;
                                break;
                            }
                            default: {
                                System.out.println("\n[Sistema]: Elige una opción válida del menú.");
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("\n[Sistema]: No se pudo encontrar el archivo pacientes.txt");
                    e.printStackTrace();
                }
                break;
            }
            case "2": {
                try {
                    emergencias.agregarPacientes();
                    while (menu2) {
                        System.out.println(
                                "\n[Sistema]: ¿Qué desea hacer?\n1. Ver la lista de Pacientes\n2. Pedir al siguiente Paciente\n3. Salir");
                        opcion = entradas.nextLine();
                        switch (opcion) {
                            case "1": {
                                System.out.println(
                                        "\n----------------------| Lista de Pacientes en Espera |----------------------\n");
                                System.out.println(emergencias.listaDePacientes());
                                break;
                            }
                            case "2": {
                                System.out.println("\n[Sistema]: El siguiente paciente es:");
                                System.out.println(emergencias.siguientePaciente());
                                break;
                            }
                            case "3": {
                                System.out.println(
                                        "\n[Sistema]: Gracias por usar el sistema de emergencias PriorityQueue :)\n");
                                menu2 = false;
                                break;
                            }
                            default: {
                                System.out.println("\n[Sistema]: Elige una opción válida del menú.");
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("\n[Sistema]: No se pudo encontrar el archivo pacientes.txt");
                    e.printStackTrace();
                }
                break;
            }
            default: {
                System.out.println("\n[Sistema]: Este es un código inalcanzable. No beerías estar aquí.");
                break;
            }
        }
        entradas.close();
    }
}
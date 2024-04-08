package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Clase que gestiona el manejo de pacientes en una cola de emergencias.
 * 
 * @author Cristian Túnchez
 * @version 1.0
 * @since 08/04/2024
 */
public class Emergencias {
    // Cola de pacientes usando VectorHeap
    private VectorHeap<Paciente> pacientes = new VectorHeap<>();
    // Cola de pacientes usando PriorityQueue de Java Collections Framework
    private PriorityQueue<Paciente> pacientesJCF = new PriorityQueue<>();

    /**
     * Constructor de la clase Emergencias.
     */
    public Emergencias() {
    }

    /**
     * Método para agregar pacientes a la cola de emergencias utilizando
     * VectorHeap.
     * Lee los datos desde un archivo "pacientes.txt".
     *
     * @throws FileNotFoundException si no se puede encontrar el archivo.
     */
    public void agregarPacientes() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/main/java/uvg/edu/gt/pacientes.txt"))) {
            System.out.println("\n[Sistema]: Leyendo 'pacientes.txt'...");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                pacientes.add(new Paciente(parts[0], parts[1], parts[2]));
            }
        }
    }

    /**
     * Obtiene y remueve el siguiente paciente de la cola de emergencias utilizando
     * VectorHeap.
     *
     * @return representación en String del siguiente paciente.
     */
    public String siguientePaciente() {
        if (pacientes.isEmpty()) {
            return "[Sistema]: No hay pacientes.";
        }
        return pacientes.poll().toString();
    }

    /**
     * Genera una lista de todos los pacientes en espera de atención.
     *
     * @return representación en String de la cola de pacientes.
     */
    public String listaDePacientes() {
        if (pacientes.isEmpty()) {
            return "[Sistema]: No hay pacientes.";
        }
        String listaDePacientes = "";
        int contador = 0;
        for (Paciente paciente : pacientes.getHeap()) {
            contador++;
            listaDePacientes += contador + ". " + paciente.toString() + "\n";
        }
        return listaDePacientes;
    }

    /**
     * Método para agregar pacientes a la cola de emergencias utilizando
     * PriorityQueue de Java Collections Framework.
     * Lee los datos desde un archivo "pacientes.txt".
     *
     * @throws FileNotFoundException si no se puede encontrar el archivo.
     */
    public void agregarPacientesJCF() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/main/java/uvg/edu/gt/pacientes.txt"))) {
            System.out.println("\n[Sistema]: Leyendo 'pacientes.txt'...");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                pacientesJCF.add(new Paciente(parts[0], parts[1], parts[2]));
            }
        }
    }

    /**
     * Obtiene y remueve el siguiente paciente de la cola de emergencias utilizando
     * PriorityQueue de Java Collections Framework.
     *
     * @return representación en String del siguiente paciente.
     */
    public String siguientePacienteJCF() {
        if (pacientesJCF.isEmpty()) {
            return "\n[Sistema]: No hay pacientes.";
        }
        return pacientesJCF.poll().toString();
    }

    /**
     * Genera una lista de todos los pacientes en espera de atención utilizando
     * PriorityQueue de Java Collections Framework.
     *
     * @return representación en String de la cola de pacientes.
     */
    public String listaDePacientesJCF() {
        if (pacientesJCF.isEmpty()) {
            return "\n[Sistema]: No hay pacientes.";
        }
        PriorityQueue<Paciente> copiaPacientesJCF = new PriorityQueue<>(pacientesJCF);
        StringBuilder listaDePacientes = new StringBuilder();
        int contador = 0;
        while (!copiaPacientesJCF.isEmpty()) {
            contador++;
            Paciente paciente = copiaPacientesJCF.poll();
            listaDePacientes.append(contador).append(". ").append(paciente.toString()).append("\n");
        }
        return listaDePacientes.toString();
    }
}
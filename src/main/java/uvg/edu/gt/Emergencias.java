package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Emergencias {
    private VectorHeap<Paciente> pacientes = new VectorHeap<>();
    private PriorityQueue<Paciente> pacientesJCF = new PriorityQueue<>();

    public Emergencias() {
    }

    public void agregarPacientes() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/main/java/uvg/edu/gt/pacientes.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                pacientes.add(new Paciente(parts[0], parts[1], parts[2]));
            }
        }
    }

    public String siguientePaciente() {
        if (pacientes.isEmpty()) {
            return "[Sistema]: No hay pacientes.";
        }
        return pacientes.poll().toString();
    }

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

    public void agregarPacientesJCF() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/main/java/uvg/edu/gt/pacientes.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                pacientesJCF.add(new Paciente(parts[0], parts[1], parts[2]));
            }
        }
    }

    public String siguientePacienteJCF() {
        if (pacientesJCF.isEmpty()) {
            return "\n[Sistema]: No hay pacientes.";
        }
        return pacientesJCF.poll().toString();
    }

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
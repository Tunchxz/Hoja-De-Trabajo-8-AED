package uvg.edu.gt;

/**
 * Clase que representa a un paciente en el sistema de atención de emergencias.
 * Implementa la interfaz Comparable para permitir la comparación entre
 * pacientes.
 * 
 * @author Cristian Túnchez
 * @version 1.0
 * @since 08/04/2024
 */
public class Paciente implements Comparable<Paciente> {
    // Nombre del paciente.
    private String nombre;
    // Síntomas del paciente.
    private String sintomas;
    // Código del paciente.
    private String codigo;

    /**
     * Constructor de la clase Paciente.
     * 
     * @param nombre   Nombre del paciente.
     * @param sintomas Síntomas del paciente.
     * @param codigo   Código del paciente.
     */
    public Paciente(String nombre, String sintomas, String codigo) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.codigo = codigo;
    }

    /**
     * Método getter para obtener el código del paciente.
     * 
     * @return El código del paciente.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método toString para representar el objeto Paciente como una cadena de texto.
     * 
     * @return Una cadena que contiene el nombre, los síntomas y el código del
     *         paciente.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Síntomas: " + sintomas + " | Código: " + codigo;
    }

    /**
     * Método compareTo para comparar dos pacientes basándose en sus códigos.
     * 
     * @param paciente El paciente con el que se compara.
     * @return Un valor negativo si este paciente es "menor" que el paciente dado,
     *         un valor positivo si es "mayor", o cero si son iguales.
     */
    @Override
    public int compareTo(Paciente paciente) {
        return this.codigo.compareTo(paciente.getCodigo());
    }
}
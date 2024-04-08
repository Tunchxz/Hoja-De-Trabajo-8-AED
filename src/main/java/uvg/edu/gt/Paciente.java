package uvg.edu.gt;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintomas;
    private String codigo;

    public Paciente(String nombre, String sintomas, String codigo) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Sintomas: " + sintomas + " | Código: " + codigo;
    }

    @Override
    public int compareTo(Paciente paciente) {
        return this.codigo.compareTo(paciente.getCodigo());
    }
}
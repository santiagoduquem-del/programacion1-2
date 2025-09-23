package co.edu.uniquindio.universidad.model;

// Rector.java
public class Rector {

    private String nombre;
    private String apellido;

    public Rector(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    @Override
    public String toString() {
        return "Rector{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}

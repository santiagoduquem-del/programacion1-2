package co.edu.uniquindio.universidad.model;

public class Rector {

    String nombre;
    String apellido;
    Universidad ownedByUniversidad;

    public Rector() {}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
}
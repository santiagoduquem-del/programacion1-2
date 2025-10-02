package co.edu.uniquindio.universidad.model;

public class Estudiante {

    String nombre;
    String apellido;
    String identificacion;
    int edad;
    double nota1;
    double nota2;
    double nota3;
    Universidad ownedByUniversidad;

    public Estudiante() {}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getIdentificacion() {return identificacion;}
    public void setIdentificacion(String identificacion) {this.identificacion = identificacion;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public double getNota1() {return nota1;}
    public void setNota1(double nota1) {this.nota1 = nota1;}
    public double getNota2() {return nota2;}
    public void setNota2(double nota2) {this.nota2 = nota2;}
    public double getNota3() {return nota3;}
    public void setNota3(double nota3) {this.nota3 = nota3;}
    public Universidad getOwnedByUniversidad() {return ownedByUniversidad;}
    public void setOwnedByUniversidad(Universidad ownedByUniversidad) {this.ownedByUniversidad = ownedByUniversidad;}



}

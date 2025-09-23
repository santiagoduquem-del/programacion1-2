package co.edu.uniquindio.universidad.model;

// Estudiante.java
public class Estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String semestre;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;

    public Estudiante(String nombre, String apellido, int edad, String correo, String semestre, double nota1, double nota2, double nota3, double nota4, double nota5) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.semestre = semestre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.nota5 = nota5;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public String getSemestre() { return semestre; }
    public double getNota1() { return nota1; }
    public double getNota2() { return nota2; }
    public double getNota3() { return nota3; }
    public double getNota4() { return nota4; }
    public double getNota5() { return nota5; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public void setNota1(double nota1) { this.nota1 = nota1; }
    public void setNota2(double nota2) { this.nota2 = nota2; }
    public void setNota3(double nota3) { this.nota3 = nota3; }
    public void setNota4(double nota4) { this.nota4 = nota4; }
    public void setNota5(double nota5) { this.nota5 = nota5; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", semestre='" + semestre + '\'' +
                ", notas=[" + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + ", " + nota5 + ']' +
                '}';
    }
}

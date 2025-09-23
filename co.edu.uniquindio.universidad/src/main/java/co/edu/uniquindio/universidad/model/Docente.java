package co.edu.uniquindio.universidad.model;

// Docente.java
import java.util.ArrayList;
import java.util.List;

public class Docente {

    private String nombre;
    private String apellido;
    private int edad;
    private String correo;

    public Docente(String nombre, String apellido, int edad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setCorreo(String correo) { this.correo = correo; }

    public double calcularDefinitivaEstudiante(Estudiante estudiante) {
        return (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3() + estudiante.getNota4() + estudiante.getNota5()) / 5.0;
    }
    public double calcularPromedioCurso(Curso curso) {
        if (curso.getListaEstudiantes().isEmpty()) { return 0.0; }
        double sumaDefinitivas = 0;
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            sumaDefinitivas += calcularDefinitivaEstudiante(estudiante);
        }
        return sumaDefinitivas / curso.getListaEstudiantes().size();
    }
    public double calcularPromedioEdad(Curso curso) {
        if (curso.getListaEstudiantes().isEmpty()) { return 0.0; }
        int sumaEdades = 0;
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            sumaEdades += estudiante.getEdad();
        }
        return (double) sumaEdades / curso.getListaEstudiantes().size();
    }
    public double calcularPromedioNota1(Curso curso) {
        if (curso.getListaEstudiantes().isEmpty()) { return 0.0; }
        double sumaNota1 = 0;
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            sumaNota1 += estudiante.getNota1();
        }
        return sumaNota1 / curso.getListaEstudiantes().size();
    }
    public double calcularNotaMayorDelCurso(Curso curso) {
        if (curso.getListaEstudiantes().isEmpty()) { return 0.0; }
        double notaMayor = 0.0;
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            double notaDefinitiva = calcularDefinitivaEstudiante(estudiante);
            if (notaDefinitiva > notaMayor) {
                notaMayor = notaDefinitiva;
            }
        }
        return notaMayor;
    }
    public double calcularNotaMenorCurso(Curso curso) {
        if (curso.getListaEstudiantes().isEmpty()) { return 0.0; }
        double notaMenor = 5.0;
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            double notaDefinitiva = calcularDefinitivaEstudiante(estudiante);
            if (notaDefinitiva < notaMenor) {
                notaMenor = notaDefinitiva;
            }
        }
        return notaMenor;
    }
    public boolean aprobacionCurso(Curso curso) {
        return calcularPorcentajeGanaronCurso(curso) > 60.0;
    }
    public double calcularPorcentajeGanaronCurso(Curso curso) {
        if (curso.getListaEstudiantes().isEmpty()) { return 0.0; }
        int ganaron = 0;
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            if (calcularDefinitivaEstudiante(estudiante) >= 3.0) {
                ganaron++;
            }
        }
        return (double) ganaron / curso.getListaEstudiantes().size() * 100;
    }
    public double calcularPorcentajePerdieronCurso(Curso curso) {
        return 100.0 - calcularPorcentajeGanaronCurso(curso);
    }
    public List<Estudiante> obtenerEstudianteNotasMayor4(Curso curso) {
        List<Estudiante> estudiantesDestacados = new ArrayList<>();
        for (Estudiante estudiante : curso.getListaEstudiantes()) {
            if (calcularDefinitivaEstudiante(estudiante) > 4.0) {
                estudiantesDestacados.add(estudiante);
            }
        }
        return estudiantesDestacados;
    }
    public double notaMaxima(Estudiante estudiante) {
        return Math.max(estudiante.getNota1(), Math.max(estudiante.getNota2(), Math.max(estudiante.getNota3(), Math.max(estudiante.getNota4(), estudiante.getNota5()))));
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

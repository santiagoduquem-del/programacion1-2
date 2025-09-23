package co.edu.uniquindio.universidad.model;

// Curso.java
import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private String semestre;
    private String grupo;
    private int creditos;
    private String jornada;
    private List<Estudiante> listaEstudiantes;

    public Curso(String nombre, String semestre, String grupo, int creditos, String jornada) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.grupo = grupo;
        this.creditos = creditos;
        this.jornada = jornada;
        this.listaEstudiantes = new ArrayList<>();
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getSemestre() { return semestre; }
    public String getGrupo() { return grupo; }
    public int getCreditos() { return creditos; }
    public String getJornada() { return jornada; }
    public List<Estudiante> getListaEstudiantes() { return listaEstudiantes; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public void setJornada(String jornada) { this.jornada = jornada; }
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) { this.listaEstudiantes = listaEstudiantes; }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", semestre='" + semestre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", estudiantes=" + listaEstudiantes.size() +
                '}';
    }
}

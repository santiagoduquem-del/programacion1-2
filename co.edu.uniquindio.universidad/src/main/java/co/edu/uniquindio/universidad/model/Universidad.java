package co.edu.uniquindio.universidad.model;

// Universidad.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Universidad {

    private String nombre;
    private Rector rector;
    private List<Estudiante> listaEstudiantes;
    private List<Curso> listaCursos;
    private List<Docente> listaDocentes;

    public Universidad(String nombre, Rector rector) {
        this.nombre = nombre;
        this.rector = rector;
        this.listaEstudiantes = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
        this.listaDocentes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Rector getRector() { return rector; }
    public void setRector(Rector rector) { this.rector = rector; }
    public List<Estudiante> getListaEstudiantes() { return listaEstudiantes; }
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) { this.listaEstudiantes = listaEstudiantes; }
    public List<Curso> getListaCursos() { return listaCursos; }
    public void setListaCursos(List<Curso> listaCursos) { this.listaCursos = listaCursos; }
    public List<Docente> getListaDocentes() { return listaDocentes; }
    public void setListaDocentes(List<Docente> listaDocentes) { this.listaDocentes = listaDocentes; }

    // Métodos para agregar elementos
    public void agregarEstudiante(Estudiante estudiante) { listaEstudiantes.add(estudiante); }
    public void agregarCurso(Curso curso) { listaCursos.add(curso); }
    public void agregarDocente(Docente docente) { listaDocentes.add(docente); }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", rector=" + rector.getNombre() +
                ", numEstudiantes=" + listaEstudiantes.size() +
                ", numCursos=" + listaCursos.size() +
                ", numDocentes=" + listaDocentes.size() +
                '}';
    }


}

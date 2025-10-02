package co.edu.uniquindio.universidad.model;

// import org.w3c.dom.css.Rect;

import java.util.ArrayList;

public class Universidad {

    private String nombre;

    private ArrayList<Estudiante> listaEstudiantes = new ArrayList();
    private ArrayList<Curso> listaCursos = new ArrayList();
    private ArrayList<Docente> listaDocentes = new ArrayList();
    private Rector rector;

    public Universidad() {
    }

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public ArrayList<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public Rector getRector() {
        return rector;
    }

    public void setRector(Rector rector) {
        this.rector = rector;
    }

    public boolean crearEstudiante(String nombre,
                                   String apellido,
                                   String identificacion,
                                   int edad,
                                   double nota1,
                                   double nota2,
                                   double nota3) {
        //Obtener el estduiante
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setEdad(edad);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);
            estudiante.setIdentificacion(identificacion);
            getListaEstudiantes().add(estudiante);

            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarEstudiante(String identificacion) {
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if (estudianteEncontrado != null) {
            return getListaEstudiantes().remove(estudianteEncontrado);
        }
        return false;
    }

    public Estudiante consultarEstudiante(String identificacion) {
        return obtenerEstudiante(identificacion);
    }

    public boolean actualizarEstudiante(String identificacion,
                                        String nombre,
                                        String apellido,
                                        int edad,
                                        double nota1,
                                        double nota2,
                                        double nota3) {
        Estudiante estudiante = obtenerEstudiante(identificacion);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setEdad(edad);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);
            return true;
        }
        return false;
    }

    private Estudiante obtenerEstudiante(String identificacion) {
        Estudiante estudianteEncontrado =  null;
        for (Estudiante estudiante : getListaEstudiantes()) {
            if(estudiante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }

        return estudianteEncontrado;
    }
    // ... existing code ...
    // CRUD Docente
    public boolean crearDocente(String nombre,
                                String apellido,
                                String email,
                                String identificacion,
                                int edad) {
        Docente existente = obtenerDocente(email);
        if (existente == null) {
            Docente d = new Docente();
            d.setNombre(nombre);
            d.setApellido(apellido);
            d.setEmail(email);
            d.setEdad(edad);
            getListaDocentes().add(d);
            return true;
        }
        return false;
    }

    public Docente consultarDocente(String identificacion) {
        return obtenerDocente(identificacion);
    }

    public boolean actualizarDocente(String email,
                                     String nombre,
                                     String apellido,
                                     String identificacion,
                                     int edad) {
        Docente d = obtenerDocente(email);
        if (d != null) {
            d.setNombre(nombre);
            d.setApellido(apellido);
            d.setEdad(edad);
            return true;
        }
        return false;
    }

    public boolean eliminarDocente(String identificacion) {
        Docente d = obtenerDocente(identificacion);
        if (d != null) {
            return getListaDocentes().remove(d);
        }
        return false;
    }

    private Docente obtenerDocente(String email) {
        for (Docente d : getListaDocentes()) {
            if (d.getEmail() != null && d.getEmail().equalsIgnoreCase(email)) {
                return d;
            }
        }
        return null;
    }

    public boolean crearCurso(String nombre,
                              String semestre,
                              String grupo,
                              String creditos,
                              String jornada) {
        Curso existente = obtenerCurso(grupo);
        if (existente == null) {
            Curso c = new Curso();
            c.setNombre(nombre);
            c.setSemestre(semestre);
            c.setGrupo(grupo);
            c.setCreditos(creditos);
            c.setJornada(jornada);
            c.setOwnedByUniversidad(this);
            getListaCursos().add(c);
            return true;
        }
        return false;
    }

    public Curso consultarCurso(String grupo) {
        return obtenerCurso(grupo);
    }

    public boolean actualizarCurso(String grupo,
                                   String nombre,
                                   String semestre,
                                   String creditos,
                                   String jornada) {
        Curso c = obtenerCurso(grupo);
        if (c != null) {
            c.setNombre(nombre);
            c.setSemestre(semestre);
            c.setCreditos(creditos);
            c.setJornada(jornada);
            return true;
        }
        return false;
    }

    public boolean eliminarCurso(String grupo) {
        Curso c = obtenerCurso(grupo);
        if (c != null) {
            return getListaCursos().remove(c);
        }
        return false;
    }

    private Curso obtenerCurso(String grupo) {
        for (Curso c : getListaCursos()) {
            if (c.getGrupo() != null && c.getGrupo().equalsIgnoreCase(grupo)) {
                return c;
            }
        }
        return null;
    }

    public boolean crearRector(String nombre, String apellido) {
        if (this.rector == null) {
            Rector r = new Rector();
            r.setNombre(nombre);
            r.setApellido(apellido);
            this.rector = r;
            return true;
        }
        return false;
    }

    public Rector consultarRector() {
        return this.rector;
    }

    public boolean actualizarRector(String nombre, String apellido) {
        if (this.rector != null) {
            this.rector.setNombre(nombre);
            this.rector.setApellido(apellido);
            return true;
        }
        return false;
    }

    public boolean eliminarRector() {
        if (this.rector != null) {
            this.rector = null;
            return true;
        }
        return false;
    }

    public void calcularDefinitivaEstudiante(String cedulaDocente) {
        Docente docenteEncontrado = obtenerDocente(cedulaDocente);
        if(docenteEncontrado != null) {
            for (Estudiante estudiante : getListaEstudiantes()) {
                double definitiva = docenteEncontrado.calcularNotaDefinitiva(
                        estudiante.getNota1(),
                        estudiante.getNota2(),
                        estudiante.getNota3());
                System.out.println("Nota definitiva del estudiante: " + estudiante.getNombre() + " es: " + definitiva);
            }
        }
    }
}
package co.edu.uniquindio.universidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase Estudiante
class Estudiante {
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
        return "Estudiante{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", edad=" + edad + ", correo='" + correo + '\'' + ", semestre='" + semestre + '\'' + ", notas=[" + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + ", " + nota5 + ']' + '}';
    }
}

// Clase Curso
class Curso {
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

    public String getNombre() { return nombre; }
    public String getSemestre() { return semestre; }
    public String getGrupo() { return grupo; }
    public int getCreditos() { return creditos; }
    public String getJornada() { return jornada; }
    public List<Estudiante> getListaEstudiantes() { return listaEstudiantes; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public void setJornada(String jornada) { this.jornada = jornada; }
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) { this.listaEstudiantes = listaEstudiantes; }

    public void agregarEstudiante(Estudiante estudiante) { listaEstudiantes.add(estudiante); }

    @Override
    public String toString() {
        return "Curso{" + "nombre='" + nombre + '\'' + ", semestre='" + semestre + '\'' + ", grupo='" + grupo + '\'' + ", estudiantes=" + listaEstudiantes.size() + '}';
    }
}

// Clase Docente
class Docente {
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

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }

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
    public boolean aprobacionCurso(Curso curso) { return calcularPorcentajeGanaronCurso(curso) > 60.0; }
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
        return "Docente{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", correo='" + correo + '\'' + '}';
    }
}

// Clase Rector
class Rector {
    private String nombre;
    private String apellido;

    public Rector(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    @Override
    public String toString() {
        return "Rector{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + '}';
    }
}

// Clase Universidad
class Universidad {
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

    public void agregarEstudiante(Estudiante estudiante) { listaEstudiantes.add(estudiante); }
    public void agregarCurso(Curso curso) { listaCursos.add(curso); }
    public void agregarDocente(Docente docente) { listaDocentes.add(docente); }

    @Override
    public String toString() {
        return "Universidad{" + "nombre='" + nombre + '\'' + ", rector=" + rector.getNombre() + ", numEstudiantes=" + listaEstudiantes.size() + ", numCursos=" + listaCursos.size() + ", numDocentes=" + listaDocentes.size() + '}';
    }
}

// Clase Principal con el método main
public class Main {
    public static void main(String[] args) {
        Rector rector = new Rector("Juan", "Pérez");
        Universidad universidad = new Universidad("Universidad Nacional", rector);
        Docente docente = new Docente("Ana", "Gómez", 45, "ana.gomez@mail.com");

        Estudiante estudiante1 = new Estudiante("Carlos", "Ruiz", 20, "carlos@mail.com", "Segundo", 4.5, 3.8, 5.0, 4.2, 4.8);
        Estudiante estudiante2 = new Estudiante("Luisa", "Diaz", 21, "luisa@mail.com", "Segundo", 2.0, 1.5, 3.0, 2.5, 3.0);
        Estudiante estudiante3 = new Estudiante("Pedro", "López", 22, "pedro@mail.com", "Segundo", 3.5, 4.0, 3.2, 3.8, 4.1);

        Curso matematicas = new Curso("Matemáticas", "Segundo", "Grupo A", 4, "Diurna");

        matematicas.agregarEstudiante(estudiante1);
        matematicas.agregarEstudiante(estudiante2);
        matematicas.agregarEstudiante(estudiante3);

        universidad.agregarCurso(matematicas);
        universidad.agregarDocente(docente);
        universidad.agregarEstudiante(estudiante1);
        universidad.agregarEstudiante(estudiante2);
        universidad.agregarEstudiante(estudiante3);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Mostrar información del curso de Matemáticas");
            System.out.println("2. Ver estadísticas del curso");
            System.out.println("3. Calcular definitiva de un estudiante");
            System.out.println("4. Mostrar estudiantes destacados (Nota > 4.0)");
            System.out.println("5. Listar todos los estudiantes, cursos, y docentes");
            System.out.println("6. Crear un nuevo Estudiante");
            System.out.println("7. Crear un nuevo Curso");
            System.out.println("8. Crear un nuevo Docente");
            System.out.println("9. Crear un nuevo Rector");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = -1;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\nInformación del Curso:");
                    System.out.println(matematicas.toString());
                    System.out.println("Estudiantes inscritos: " + matematicas.getListaEstudiantes());
                    break;
                case 2:
                    System.out.println("\n--- Estadísticas del Curso ---");
                    System.out.println("Promedio del curso: " + String.format("%.2f", docente.calcularPromedioCurso(matematicas)));
                    System.out.println("Porcentaje de aprobados: " + String.format("%.2f", docente.calcularPorcentajeGanaronCurso(matematicas)) + "%");
                    System.out.println("Porcentaje de reprobados: " + String.format("%.2f", docente.calcularPorcentajePerdieronCurso(matematicas)) + "%");
                    System.out.println("Nota más alta: " + docente.calcularNotaMayorDelCurso(matematicas));
                    System.out.println("Nota más baja: " + docente.calcularNotaMenorCurso(matematicas));
                    break;
                case 3:
                    System.out.print("\nIngrese el nombre del estudiante para calcular su definitiva: ");
                    String nombreEstudiante = scanner.nextLine();
                    Estudiante estEncontrado = null;
                    for (Estudiante est : matematicas.getListaEstudiantes()) {
                        if (est.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                            estEncontrado = est;
                            break;
                        }
                    }
                    if (estEncontrado != null) {
                        System.out.println("La nota definitiva de " + estEncontrado.getNombre() + " es: " + String.format("%.2f", docente.calcularDefinitivaEstudiante(estEncontrado)));
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Estudiantes con nota mayor a 4.0 ---");
                    List<Estudiante> destacados = docente.obtenerEstudianteNotasMayor4(matematicas);
                    if (destacados.isEmpty()) {
                        System.out.println("No hay estudiantes con nota definitiva superior a 4.0.");
                    } else {
                        for (Estudiante est : destacados) {
                            System.out.println(est.toString() + " - Definitiva: " + String.format("%.2f", docente.calcularDefinitivaEstudiante(est)));
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n--- Listado de la Universidad ---");
                    System.out.println("Rector: " + universidad.getRector().getNombre() + " " + universidad.getRector().getApellido());
                    System.out.println("\nEstudiantes:");
                    for (Estudiante est : universidad.getListaEstudiantes()) {
                        System.out.println(est.toString());
                    }
                    System.out.println("\nCursos:");
                    for (Curso cur : universidad.getListaCursos()) {
                        System.out.println(cur.toString());
                    }
                    System.out.println("\nDocentes:");
                    for (Docente doc : universidad.getListaDocentes()) {
                        System.out.println(doc.toString());
                    }
                    break;
                case 6:
                    System.out.println("\n--- Creación de un nuevo Estudiante ---");
                    System.out.print("Ingrese nombre: ");
                    String nNombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String nApellido = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    int nEdad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese correo: ");
                    String nCorreo = scanner.nextLine();
                    System.out.print("Ingrese semestre: ");
                    String nSemestre = scanner.nextLine();
                    System.out.print("Ingrese nota 1: ");
                    double nNota1 = scanner.nextDouble();
                    System.out.print("Ingrese nota 2: ");
                    double nNota2 = scanner.nextDouble();
                    System.out.print("Ingrese nota 3: ");
                    double nNota3 = scanner.nextDouble();
                    System.out.print("Ingrese nota 4: ");
                    double nNota4 = scanner.nextDouble();
                    System.out.print("Ingrese nota 5: ");
                    double nNota5 = scanner.nextDouble();
                    scanner.nextLine();
                    Estudiante nuevoEstudiante = new Estudiante(nNombre, nApellido, nEdad, nCorreo, nSemestre, nNota1, nNota2, nNota3, nNota4, nNota5);
                    universidad.agregarEstudiante(nuevoEstudiante);
                    System.out.println("¡Estudiante creado y agregado a la universidad!");
                    break;
                case 7:
                    System.out.println("\n--- Creación de un nuevo Curso ---");
                    System.out.print("Ingrese nombre del curso: ");
                    String cNombre = scanner.nextLine();
                    System.out.print("Ingrese semestre: ");
                    String cSemestre = scanner.nextLine();
                    System.out.print("Ingrese grupo: ");
                    String cGrupo = scanner.nextLine();
                    System.out.print("Ingrese creditos: ");
                    int cCreditos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese jornada: ");
                    String cJornada = scanner.nextLine();
                    Curso nuevoCurso = new Curso(cNombre, cSemestre, cGrupo, cCreditos, cJornada);
                    universidad.agregarCurso(nuevoCurso);
                    System.out.println("¡Curso creado y agregado a la universidad!");
                    break;
                case 8:
                    System.out.println("\n--- Creación de un nuevo Docente ---");
                    System.out.print("Ingrese nombre: ");
                    String dNombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String dApellido = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    int dEdad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese correo: ");
                    String dCorreo = scanner.nextLine();
                    Docente nuevoDocente = new Docente(dNombre, dApellido, dEdad, dCorreo);
                    universidad.agregarDocente(nuevoDocente);
                    System.out.println("¡Docente creado y agregado a la universidad!");
                    break;
                case 9:
                    System.out.println("\n--- Creación de un nuevo Rector ---");
                    System.out.print("Ingrese nombre: ");
                    String rNombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String rApellido = scanner.nextLine();
                    Rector nuevoRector = new Rector(rNombre, rApellido);
                    universidad.setRector(nuevoRector);
                    System.out.println("¡Rector creado y asignado a la universidad!");
                    break;
                case 10:
                    continuar = false;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }
}
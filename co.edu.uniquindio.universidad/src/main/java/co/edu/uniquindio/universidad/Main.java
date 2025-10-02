package co.edu.uniquindio.universidad;

import co.edu.uniquindio.universidad.model.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Universidad universidad = inicializarDatos();

        Estudiante estudiante = universidad.getListaEstudiantes().get(0);
        estudiante.getOwnedByUniversidad();
        calcularDefinitivaEstudiante(universidad);

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Ingrese la opción del menú");
            switch (opcion) {
                case 1:
                    String resultado = crearEstudiante(universidad);
                    System.out.println("Información del estudiante: " + resultado);
                    break;
                case 2:
                    obtenerEstudiante(universidad);
                    break;
                case 3:
                    actualizarEstudiante(universidad);
                    break;
                case 4:
                    eliminarEstudiante(universidad);
                    break;
                case 5:
                    String resultado2 = crearDocente(universidad);
                    System.out.println("Información del docente: " + resultado2);
                    break;
                case 6:
                    obtenerDocente(universidad);
                    break;
                case 7:
                    actualizarDocente(universidad);
                    break;
                case 8:
                    eliminarDocente(universidad);
                    break;
                case 9:
                    String resultado3 = crearCurso(universidad);
                    System.out.println("Información del curso: " + resultado3);
                    break;
                case 10:
                    obtenerCurso(universidad);
                    break;
                case 11:
                    actualizarCurso(universidad);
                    break;
                case 12:
                    eliminarCurso(universidad);
                    break;
                case 13:
                    String resultado4 = crearRector(universidad);
                    System.out.println("Información del rector: " + resultado4);
                    break;
                case 14:
                    obtenerRector(universidad);
                    break;
                case 15:
                    actualizarRector(universidad);
                    break;
                case 16:
                    eliminarRector(universidad);
                    break;
                case 00:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 00);

    }

    private static void calcularDefinitivaEstudiante(Universidad universidad) {
        String cedulaDocente = "1094";
        universidad.calcularDefinitivaEstudiante(cedulaDocente);
    }

    private static String crearEstudiante(Universidad universidad) {
        // Ahora solicita los datos por consola
        String nombre = leerCadena("Ingrese el nombre:");
        String apellido = leerCadena("Ingrese el apellido:");
        String identificacion = leerCadena("Ingrese la identificación:");
        int edad = leerEntero("Ingrese la edad:");
        double nota1 = leerDouble("Ingrese la nota 1:");
        double nota2 = leerDouble("Ingrese la nota 2:");
        double nota3 = leerDouble("Ingrese la nota 3:");

        boolean resultado = universidad.crearEstudiante(
                nombre, apellido, identificacion, edad, nota1, nota2, nota3
        );

        if (resultado) {
            System.out.println("Estudiante creado exitosamente.");
        } else {
            System.out.println("No se puede crear el estudiante porque ya hay uno con la misma identificación.");
        }
        return String.format("%s %s | ID: %s | Edad: %d | Notas: %.2f, %.2f, %.2f",
                nombre, apellido, identificacion, edad, nota1, nota2, nota3);
    }



    private static void eliminarEstudiante(Universidad universidad) {
        String identificacion = leerCadena("Ingrese la identificación del estudiante a eliminar:");
        boolean eliminado = universidad.eliminarEstudiante(identificacion);
        if (eliminado) {
            System.out.println("Estudiante eliminado exitosamente");
        } else {
            System.out.println("No se encontró el estudiante con identificación: " + identificacion);
        }
    }

    private static void actualizarEstudiante(Universidad universidad) {
        String identificacion = leerCadena("Ingrese la identificación del estudiante a actualizar:");
        String nuevoNombre = leerCadena("Ingrese el nuevo nombre:");
        String nuevoApellido = leerCadena("Ingrese el nuevo apellido:");
        int nuevaEdad = leerEntero("Ingrese la nueva edad:");
        double nuevaNota1 = leerDouble("Ingrese la nueva nota 1:");
        double nuevaNota2 = leerDouble("Ingrese la nueva nota 2:");
        double nuevaNota3 = leerDouble("Ingrese la nueva nota 3:");

        boolean actualizado = universidad.actualizarEstudiante(
                identificacion, nuevoNombre, nuevoApellido, nuevaEdad, nuevaNota1, nuevaNota2, nuevaNota3
        );

        if (actualizado) {
            System.out.println("Estudiante actualizado exitosamente");
        } else {
            System.out.println("No se pudo actualizar. Estudiante no encontrado con identificación: " + identificacion);
        }
    }

    private static void obtenerEstudiante(Universidad universidad) {
        String identificacion = leerCadena("Ingrese la identificación del estudiante a consultar:");
        Estudiante estudiante = universidad.consultarEstudiante(identificacion);
        if (estudiante != null) {
            System.out.printf("Estudiante encontrado:%n");
            System.out.printf("Nombre: %s %s%n", estudiante.getNombre(), estudiante.getApellido());
            System.out.printf("ID: %s%n", estudiante.getIdentificacion());
            System.out.printf("Edad: %d%n", estudiante.getEdad());
            System.out.printf("Notas: %.2f, %.2f, %.2f%n", estudiante.getNota1(), estudiante.getNota2(), estudiante.getNota3());
        } else {
            System.out.printf("No se encontró estudiante con identificación: %s%n", identificacion);
        }
    }

    public static String crearDocente(Universidad universidad) {
        String nombre = leerCadena("Ingrese el nombre del docente:");
        String apellido = leerCadena("Ingrese el apellido del docente:");
        String email = leerCadena("Ingrese el email:");
        String identificacion = leerCadena("Ingrese la identificación del docente (identificador único):");
        int edad = leerEntero("Ingrese la edad del docente:");

        boolean creado = universidad.crearDocente(nombre, apellido, email, identificacion, edad);
        if (creado) {
            System.out.println("Docente creado exitosamente.");
        } else {
            System.out.println("No se puede crear: ya existe un docente con ese email.");
        }
        return String.format("%s %s | ID: %s | Edad: %d", nombre, apellido, identificacion, edad);
    }

    public static void obtenerDocente(Universidad universidad) {
        String identificacion = leerCadena("Ingrese la identificacion del docente a consultar:");
        Docente docente = universidad.consultarDocente(identificacion);
        if (docente != null) {
            System.out.printf("Docente encontrado:%n");
            System.out.printf("Nombre: %s %s%n", docente.getNombre(), docente.getApellido());
            System.out.printf("Email: %s%n", docente.getEmail());
            System.out.printf("Edad: %d%n", docente.getEdad());
        } else {
            System.out.printf("No se encontró docente con identificación: %s%n", identificacion);
        }
    }

    public static void actualizarDocente(Universidad universidad) {
        String identificacion = leerCadena("Ingrese la identificacion del docente a actualizar:");
        String nombre = leerCadena("Ingrese el nuevo nombre:");
        String apellido = leerCadena("Ingrese el nuevo apellido:");
        String email = leerCadena("Ingrese el nuevo email:");
        int edad = leerEntero("Ingrese la nueva edad:");

        boolean actualizado = universidad.actualizarDocente(email, nombre, apellido, identificacion, edad);
        if (actualizado) {
            System.out.println("Docente actualizado exitosamente.");
        } else {
            System.out.println("No se pudo actualizar. Docente no encontrado con identificacion: " + identificacion);
        }
    }

    public static void eliminarDocente(Universidad universidad) {
        String identificacion = leerCadena("Ingrese la identificacion del docente a eliminar:");
        boolean eliminado = universidad.eliminarDocente(identificacion);
        if (eliminado) {
            System.out.println("Docente eliminado exitosamente.");
        } else {
            System.out.println("No se encontró docente con email: " + identificacion);
        }
    }

    public static String crearCurso(Universidad universidad) {
        String nombre = leerCadena("Ingrese el nombre del curso:");
        String semestre = leerCadena("Ingrese el semestre del curso:");
        String grupo = leerCadena("Ingrese el grupo del curso (identificador único):");
        String creditos = leerCadena("Ingrese los créditos del curso:");
        String jornada = leerCadena("Ingrese la jornada del curso:");

        boolean creado = universidad.crearCurso(nombre, semestre, grupo, creditos, jornada);
        if (creado) {
            System.out.println("Curso creado exitosamente.");
        } else {
            System.out.println("No se puede crear: ya existe un curso con ese grupo.");
        }
        return String.format("Nombre: %s | Semestre: %s | Grupo: %s | Creditos: %s | Jornada: %s",
                nombre, semestre, grupo, creditos, jornada);
    }

    public static void obtenerCurso(Universidad universidad) {
        String grupo = leerCadena("Ingrese el grupo del curso a consultar:");
        Curso curso = universidad.consultarCurso(grupo);
        if (curso != null) {
            System.out.printf("Curso encontrado:%n");
            System.out.printf("Nombre: %s%n", curso.getNombre());
            System.out.printf("Semestre: %s%n", curso.getSemestre());
            System.out.printf("Grupo: %s%n", curso.getGrupo());
            System.out.printf("Créditos: %s%n", curso.getCreditos());
            System.out.printf("Jornada: %s%n", curso.getJornada());
        } else {
            System.out.println("No se encontró curso con el grupo: " + grupo);
        }
    }

    public static void actualizarCurso(Universidad universidad) {
        String grupo = leerCadena("Ingrese el grupo del curso a actualizar (identificador único):");
        String nombre = leerCadena("Ingrese el nuevo nombre:");
        String semestre = leerCadena("Ingrese el nuevo semestre:");
        String creditos = leerCadena("Ingrese los nuevos créditos:");
        String jornada = leerCadena("Ingrese la nueva jornada:");

        boolean actualizado = universidad.actualizarCurso(grupo, nombre, semestre, creditos, jornada);
        if (actualizado) {
            System.out.println("Curso actualizado exitosamente.");
        } else {
            System.out.println("No se pudo actualizar. No existe un curso con ese grupo.");
        }
    }

    public static void eliminarCurso(Universidad universidad) {
        String grupo = leerCadena("Ingrese el grupo del curso a eliminar:");
        boolean eliminado = universidad.eliminarCurso(grupo);
        if (eliminado) {
            System.out.println("Curso eliminado exitosamente.");
        } else {
            System.out.println("No se encontró curso con el grupo: " + grupo);
        }
    }

    public static String crearRector(Universidad universidad) {
        String nombre = leerCadena("Ingrese el nombre del rector:");
        String apellido = leerCadena("Ingrese el apellido del rector:");
        boolean creado = universidad.crearRector(nombre, apellido);
        if (creado) {
            System.out.println("Rector creado/asignado exitosamente.");
        } else {
            System.out.println("Ya existe un rector asignado. Actualícelo o elimínelo antes de crear uno nuevo.");
        }
        return String.format("%s %s", nombre, apellido);
    }

    public static void obtenerRector(Universidad universidad) {
        Rector rector = universidad.consultarRector();
        if (rector != null) {
            System.out.printf("Rector actual:%n");
            System.out.printf("Nombre: %s %s%n", rector.getNombre(), rector.getApellido());
        } else {
            System.out.println("No hay rector asignado actualmente.");
        }
    }

    public static void actualizarRector(Universidad universidad) {
        String nombre = leerCadena("Ingrese el nuevo nombre del rector:");
        String apellido = leerCadena("Ingrese el nuevo apellido del rector:");
        boolean actualizado = universidad.actualizarRector(nombre, apellido);
        if (actualizado) {
            System.out.println("Rector actualizado exitosamente.");
        } else {
            System.out.println("No hay rector para actualizar. Créalo primero.");
        }
    }

    public static void eliminarRector(Universidad universidad) {
        boolean eliminado = universidad.eliminarRector();
        if (eliminado) {
            System.out.println("Rector eliminado exitosamente.");
        } else {
            System.out.println("No hay rector asignado para eliminar.");
        }
    }

    public static Universidad inicializarDatos() {
        Universidad universidad = new Universidad();
        Estudiante e1 = new Estudiante();
        e1.setNombre("Juan");
        e1.setApellido("Sanchez");
        e1.setIdentificacion("1234");
        e1.setEdad(20);
        e1.setNota1(5);
        e1.setNota2(5);
        e1.setNota3(5);
        universidad.getListaEstudiantes().add(e1);

        Estudiante e2 = new Estudiante();
        e2.setNombre("Juan");
        e2.setApellido("Sanchez");
        e2.setIdentificacion("12343");
        e2.setEdad(20);
        e2.setNota1(5);
        e2.setNota2(5);
        e2.setNota3(5);
        universidad.getListaEstudiantes().add(e2);

        Docente d1 = new Docente();
        d1.setNombre("Juan");
        d1.setApellido("Sanchez");
        d1.setEmail("docente1@email.com");
        d1.setEdad(20);
        universidad.getListaDocentes().add(d1);

        Docente d2 = new Docente();
        d2.setNombre("dsfsdf 3");
        d2.setApellido("dfsfds 3");
        d2.setEmail("dsfdsf 3");
        d2.setEdad(1000);
        universidad.getListaDocentes().add(d2);

        Docente d3 = new Docente();
        d3.setNombre("dsfsdf");
        d3.setApellido("dfsfds");
        d3.setEmail("dsfdsf");
        d3.setEdad(20);
        universidad.getListaDocentes().add(d3);

        Curso c1 = new Curso();
        c1.setNombre("Curso de Java");
        c1.setSemestre("5");
        c1.setGrupo("A");
        c1.setCreditos("4");
        c1.setJornada("2");
        c1.setOwnedByUniversidad(universidad);
        universidad.getListaCursos().add(c1);

        universidad.getListaEstudiantes().add(e1);
        universidad.getListaEstudiantes().add(e2);
        universidad.getListaDocentes().add(d1);
        return universidad;
    }

    public static void mostrarMenu() {
        System.out.println("1 - Crear Estudiante");
        System.out.println("2 - Obtener Estudiante");
        System.out.println("3 - Actualizar Estudiante");
        System.out.println("4 - Eliminar Estudiante\n");

        System.out.println("5 - Crear docente");
        System.out.println("6 - Obtener docente");
        System.out.println("7 - Actualizar docente");
        System.out.println("8 - Eliminar docente\n");

        System.out.println("9 - Crear curso");
        System.out.println("10 - Obtener curso");
        System.out.println("11 - Actualizar curso");
        System.out.println("12 - Eliminar curso\n");

        System.out.println("13 - Crear rector");
        System.out.println("14 - Obtener rector");
        System.out.println("15 - Actualizar rector");
        System.out.println("16 - Eliminar rector\n");
        System.out.println("00 - Salir");
    }

    private static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }

    private static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static double leerDouble(String mensaje) {
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        String captura = teclado.nextLine();
        return Double.parseDouble(captura);
    }


//  private static void imprimirEstudiantes(Universidad universidad) {
//        System.out.println("\nLista de estudiantes:");
//        for (Estudiante listaEstudiantes : universidad.getListaEstudiantes()) {
//            String nombre = listaEstudiantes.getNombre();
//            String apellido = listaEstudiantes.getApellido();
//            Integer edad = listaEstudiantes.getEdad();
//
//            System.out.printf("- %s %s | Edad: %d%n%n",nombre, apellido, edad);
//        }
//    }
//
//    private static void imprimirDocentes(Universidad universidad) {
//        System.out.println("\nLista de docentes:");
//        for (Docente listaDocentes : universidad.getListaDocentes()) {
//            String nombre = listaDocentes.getNombre();
//            String apellido = listaDocentes.getApellido();
//            String email = listaDocentes.getEmail();
//            Integer edad = listaDocentes.getEdad();
//
//            System.out.printf("- %s %s | Email: %s | Edad: %d%n",nombre, apellido, email, edad);
//        }
//    }
//
//    private static void imprimirCursos(Universidad universidad) {
//        System.out.println("\nLista de cursos:");
//        for (Curso listaCursos : universidad.getListaCursos()) {
//            String nombre = listaCursos.getNombre();
//            String semestre = listaCursos.getSemestre();
//            String grupo = listaCursos.getGrupo();
//            String creditos = listaCursos.getCreditos();
//            String jornada = listaCursos.getJornada();
//
//            System.out.printf("- %s | Semestre: %s | Grupo: %s | Créditos: %s | Jornada: %s%n",nombre, semestre, grupo, creditos, jornada);
//        }
//    }
}
package co.edu.uniquindio.universidad;


import co.edu.uniquindio.universidad.model.Curso;
import co.edu.uniquindio.universidad.model.Docente;
import co.edu.uniquindio.universidad.model.Estudiante;
import co.edu.uniquindio.universidad.model.Rector;
import co.edu.uniquindio.universidad.model.Universidad;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Objeto Scanner para la entrada de datos
    private static final Scanner teclado = new Scanner(System.in);

    
    public static void mostrarMenu() {
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
    }

    private static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        captura = teclado.nextLine();
        try {
            dato = Integer.parseInt(captura);
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            return -1;
        }
        return dato;
    }

    public static double leerDoubleConsola(String mensaje) {
        double dato = 0;
        String captura = "";
        System.out.println(mensaje);
        captura = teclado.nextLine();
        try {
            dato = Double.parseDouble(captura);
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
            return -1.0;
        }
        return dato;
    }

    public static String leerStringConsola(String mensaje) {
        System.out.println(mensaje);
        return teclado.nextLine();
    }
    // Fin de las funciones reutilizables

    public static void main(String[] args) {
        // Inicialización de objetos
        Rector rector = new Rector("Juan", "Pérez");
        Universidad universidad = new Universidad("Universidad Nacional", rector);
        Docente docente = new Docente("Ana", "Gómez", 45, "ana.gomez@mail.com");

        Estudiante estudiante1 = new Estudiante("Carlos", "Ruiz", 20, "carlos@mail.com", "Segundo", 4.5, 3.8, 5.0, 4.2, 4.8);
        Estudiante estudiante2 = new Estudiante("Luisa", "Diaz", 21, "luisa@mail.com", "Segundo", 2.0, 1.5, 3.0, 2.5, 3.0);
        Estudiante estudiante3 = new Estudiante("Pedro", "López", 22, "pedro@mail.com", "Segundo", 3.5, 4.0, 3.2, 3.8, 4.1);

        Curso matematicas = new Curso("Matemáticas", "Segundo", "Grupo A", 4, "Diurna");

        // Agregar estudiantes al curso
        matematicas.agregarEstudiante(estudiante1);
        matematicas.agregarEstudiante(estudiante2);
        matematicas.agregarEstudiante(estudiante3);

        // Agregamos el curso y el docente a la universidad
        universidad.agregarCurso(matematicas);
        universidad.agregarDocente(docente);
        universidad.agregarEstudiante(estudiante1);
        universidad.agregarEstudiante(estudiante2);
        universidad.agregarEstudiante(estudiante3);

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción:");

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
                    String nombreEstudiante = leerStringConsola("Ingrese el nombre del estudiante para calcular su definitiva: ");
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
                    String nNombre = leerStringConsola("Ingrese nombre: ");
                    String nApellido = leerStringConsola("Ingrese apellido: ");
                    int nEdad = leerEntero("Ingrese edad: ");
                    String nCorreo = leerStringConsola("Ingrese correo: ");
                    String nSemestre = leerStringConsola("Ingrese semestre: ");
                    double nNota1 = leerDoubleConsola("Ingrese nota 1: ");
                    double nNota2 = leerDoubleConsola("Ingrese nota 2: ");
                    double nNota3 = leerDoubleConsola("Ingrese nota 3: ");
                    double nNota4 = leerDoubleConsola("Ingrese nota 4: ");
                    double nNota5 = leerDoubleConsola("Ingrese nota 5: ");
                    Estudiante nuevoEstudiante = new Estudiante(nNombre, nApellido, nEdad, nCorreo, nSemestre, nNota1, nNota2, nNota3, nNota4, nNota5);
                    universidad.agregarEstudiante(nuevoEstudiante);
                    System.out.println("¡Estudiante creado y agregado a la universidad!");
                    break;
                case 7:
                    System.out.println("\n--- Creación de un nuevo Curso ---");
                    String cNombre = leerStringConsola("Ingrese nombre del curso: ");
                    String cSemestre = leerStringConsola("Ingrese semestre: ");
                    String cGrupo = leerStringConsola("Ingrese grupo: ");
                    int cCreditos = leerEntero("Ingrese creditos: ");
                    String cJornada = leerStringConsola("Ingrese jornada: ");
                    Curso nuevoCurso = new Curso(cNombre, cSemestre, cGrupo, cCreditos, cJornada);
                    universidad.agregarCurso(nuevoCurso);
                    System.out.println("¡Curso creado y agregado a la universidad!");
                    break;
                case 8:
                    System.out.println("\n--- Creación de un nuevo Docente ---");
                    String dNombre = leerStringConsola("Ingrese nombre: ");
                    String dApellido = leerStringConsola("Ingrese apellido: ");
                    int dEdad = leerEntero("Ingrese edad: ");
                    String dCorreo = leerStringConsola("Ingrese correo: ");
                    Docente nuevoDocente = new Docente(dNombre, dApellido, dEdad, dCorreo);
                    universidad.agregarDocente(nuevoDocente);
                    System.out.println("¡Docente creado y agregado a la universidad!");
                    break;
                case 9:
                    System.out.println("\n--- Creación de un nuevo Rector ---");
                    String rNombre = leerStringConsola("Ingrese nombre: ");
                    String rApellido = leerStringConsola("Ingrese apellido: ");
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
        teclado.close();
    }
}
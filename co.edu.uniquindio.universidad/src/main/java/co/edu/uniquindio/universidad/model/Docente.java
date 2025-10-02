package co.edu.uniquindio.universidad.model;

import java.util.ArrayList;

public class Docente {

    String nombre;
    String apellido;
    String email;
    String identificacion;
    int edad;
    Universidad ownedByUniversidad;

    public Docente() {}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getIdentificacion() {return identificacion;}
    public void setIdentificacion(String identificacion) {this.identificacion = identificacion;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public Universidad getOwnedByUniversidad() {return ownedByUniversidad;}

    @Override
    public String toString() {
        String nom = nombre != null ? nombre : "(sin nombre)";
        String ape = apellido != null ? apellido : "(sin apellido)";
        String mail = email != null ? email : "(sin email)";
        return String.format("- %s %s | Email: %s | Edad: %d", nom, ape, mail, edad);
    }

    public String verificarEdadEsPrimo(Estudiante estudiante1, Estudiante estudiante2, Estudiante estudiante3) {
        //VERIFICAR SI LAS EDADES DE LOS ESTUDIANTES SON PRIMOS
        String resultado = "";
        if(estudiante1.getEdad() % 2 != 0 && estudiante1.getEdad() % 3 != 0 && estudiante1.getEdad() % 5 != 0 && estudiante1.getEdad() % 7 != 0) {
            resultado += estudiante1.getNombre() + " " + estudiante1.getApellido() + " es primo\n";
        } else {
            resultado += estudiante1.getNombre() + " " + estudiante1.getApellido() + " no es primo\n";
        }
        return resultado;
    }

    public String verificarNombreEsPalindromo(ArrayList<Estudiante> estudiantes) {
        //VERIFICAR SI LOS NOMBRES DE LOS ESTUDIANTES ES PALINDROMO
        String resultado = "";
        for (Estudiante e : estudiantes) {
            String nombre = e.getNombre();
            String nombreInvertido = "";
            for (int i = nombre.length() - 1; i >= 0; i--) {
                nombreInvertido += nombre.charAt(i);
            }
            if (nombre.equals(nombreInvertido)) {
                resultado += e.getNombre() + " es palindromo\n";
            } else {
                resultado += e.getNombre() + " no es palindromo\n";
            }
        }
        return resultado;
    }

    public double calcularNotaDefinitiva(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3.0;
    }
}
package co.edu.uniquindio.universidad.model;

public class Curso {

    String nombre;
    String semestre;
    String grupo;
    String creditos;
    String jornada;
    Universidad ownedByUniversidad;

    public Curso() {}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getSemestre() {return semestre;}
    public void setSemestre(String semestre) {this.semestre = semestre;}
    public String getGrupo() {return grupo;}
    public void setGrupo(String grupo) {this.grupo = grupo;}
    public String getCreditos() {return creditos;}
    public void setCreditos(String creditos) {this.creditos = creditos;}
    public String getJornada() {return jornada;}
    public void setJornada(String jornada) {this.jornada = jornada;}
    public Universidad getOwnedByUniversidad() {return ownedByUniversidad;}
    public void setOwnedByUniversidad(Universidad ownedByUniversidad) {this.ownedByUniversidad = ownedByUniversidad;}

    //3177638962

    @Override
    public String toString() {
        String nom = nombre != null ? nombre : "(sin nombre)";
        String sem = semestre != null ? semestre : "(sin semestre)";
        String grp = grupo != null ? grupo : "(sin grupo)";
        String cred = creditos != null ? creditos : "(sin créditos)";
        String jorn = jornada != null ? jornada : "(sin jornada)";
        return String.format("- %s | Semestre: %s | Grupo: %s | Créditos: %s | Jornada: %s", nom, sem, grp, cred, jorn);
    }
}
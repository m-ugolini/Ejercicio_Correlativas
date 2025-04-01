package domain;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>();
    }

    public void agregarMateriaAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }

    public Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public boolean cumpleCorrelativas(Materia materia){
        return materiasAprobadas.containsAll(materia.correlativas);
    }
}

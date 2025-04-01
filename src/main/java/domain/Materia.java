package domain;
import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    public Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public void agregarCorrelativa(Materia materia){
        correlativas.add(materia);
    }
}
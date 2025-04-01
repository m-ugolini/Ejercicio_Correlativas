package domain;
import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasACursar;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasACursar = new HashSet<>();
    }

    public boolean aprobada(){
        for(Materia materia : materiasACursar){
            if(!alumno.cumpleCorrelativas(materia)){
                return false;
            }
        }
        return true;
    }

    public void agregarMateriaACursar(Materia materia){
        materiasACursar.add(materia);
    }
}


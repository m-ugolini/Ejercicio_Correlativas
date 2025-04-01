package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
        Materia am1;
        Materia am2;
        Materia aed;
        Materia pdp;
        Alumno maca;
        Alumno franco;
        Inscripcion inscripcionMaca;
        Inscripcion inscripcionFranco;

    @BeforeEach
    public void setUp() {
            am1 = new Materia("am1");
            am2 = new Materia("am2");
            am2.agregarCorrelativa(am1);
            aed = new Materia("aed");
            pdp = new Materia("pdp");
            pdp.agregarCorrelativa(aed);

            maca = new Alumno("maca", "ugolini");
            maca.agregarMateriaAprobada(am1);
            maca.agregarMateriaAprobada(aed);

            franco = new Alumno("franco", "andino");
            franco.agregarMateriaAprobada(am1);
        }
    @Test
    public void inscripcionBuena1(){
        inscripcionMaca = new Inscripcion(maca);
        inscripcionMaca.agregarMateriaACursar(am2);

        Assertions.assertTrue(inscripcionMaca.aprobada());
    }

    @Test
    public void inscripcionMala1(){
        inscripcionFranco = new Inscripcion(franco);
        inscripcionFranco.agregarMateriaACursar(pdp);

        Assertions.assertFalse(inscripcionFranco.aprobada());
    }

    @Test
    public void inscripcionBuena2(){
        inscripcionMaca = new Inscripcion(maca);
        inscripcionMaca.agregarMateriaACursar(am2);
        inscripcionMaca.agregarMateriaACursar(pdp);

        Assertions.assertTrue(inscripcionMaca.aprobada());
    }

    @Test
    public void inscripcionMala2(){
        inscripcionFranco = new Inscripcion(franco);
        inscripcionFranco.agregarMateriaACursar(am2);
        inscripcionFranco.agregarMateriaACursar(pdp);

        Assertions.assertFalse(inscripcionFranco.aprobada());
    }
}
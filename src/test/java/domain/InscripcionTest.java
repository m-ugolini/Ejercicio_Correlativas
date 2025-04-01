package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InscripcionTest {
        private Materia am1;
        private Materia am2;
        private Materia aed;
        private Materia pdp;
        private Alumno maca;
        private Alumno juan;
        private Inscripcion inscripcionMaca;
        private Inscripcion inscripcionJuan;

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

            juan = new Alumno("juan", "perez");
            juan.agregarMateriaAprobada(am1);
        }
    @Test
    public void inscripcionBuena1(){
        inscripcionMaca = new Inscripcion(maca);
        inscripcionMaca.agregarMateriaACursar(am2);

        Assertions.assertTrue(inscripcionMaca.aprobada());
    }

    @Test
    public void inscripcionMala1(){
        inscripcionJuan = new Inscripcion(juan);
        inscripcionJuan.agregarMateriaACursar(pdp);

        Assertions.assertFalse(inscripcionJuan.aprobada());
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
        inscripcionJuan = new Inscripcion(juan);
        inscripcionJuan.agregarMateriaACursar(am2);
        inscripcionJuan.agregarMateriaACursar(pdp);

        Assertions.assertFalse(inscripcionJuan.aprobada());
    }
}
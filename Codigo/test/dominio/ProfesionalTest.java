package dominio;

import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfesionalTest {
    
    final String nombreMartin = "Martin";
    final String apellidoGomez = "Gómez";
    final String fechaNacimiento = "11/02/98";
    final String fechaGraduacion = "11/02/2016";
    final String paisGraduacion = "Uruguay";
    final String titulo = "Doctor";

    @Test
    public void testGetsSetsDatosCorrectosGraduacion() {
        String nombre = nombreMartin;
        String apellido = apellidoGomez;
        String fechaNacimiento = this.fechaNacimiento;
        ImageIcon fotoPerfil = null;
        String tituloProf = titulo;
        String fechaGrad = fechaGraduacion;
        String paisGraduacion = this.paisGraduacion;
        Profesional prof = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil,
                tituloProf, fechaGrad, paisGraduacion);
        assertEquals(prof.getFechaGraduacion(), fechaGrad);
    }

    @Test
    public void testGetsDatosCorrectossVaciosPais() {
        String nombre = nombreMartin;
        String apellido = apellidoGomez;
        String fechaNacimiento = this.fechaNacimiento;
        ImageIcon fotoPerfil = null;
        String tituloProf = titulo;
        String fechaGrad = fechaGraduacion;
        String paisGraduacion = this.paisGraduacion;
        Profesional prof = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil,
                tituloProf, fechaGrad, paisGraduacion);
        assertEquals(prof.getPaisGraduacion(), paisGraduacion);
    }

    @Test
    public void testGetsSetsDatosCorrectostitulo() {
        String nombre = nombreMartin;
        String apellido = apellidoGomez;
        String fechaNacimiento = this.fechaNacimiento;
        ImageIcon fotoPerfil = null;
        String tituloProf = titulo;
        String fechaGrad = fechaGraduacion;
        String paisGraduacion = this.paisGraduacion;
        Profesional prof = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil,
                tituloProf, fechaGrad, paisGraduacion);
        assertEquals(prof.getTituloProfesional(), tituloProf);
    }

    @Test
    public void testToStringDatosCorrectos() {
        String nombre = nombreMartin;
        String apellido = apellidoGomez;
        String fechaNacimiento = this.fechaNacimiento;
        ImageIcon fotoPerfil = null;
        String tituloProf = titulo;
        String fechaGrad = fechaGraduacion;
        String paisGraduacion = this.paisGraduacion;
        Profesional prof = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil,
                tituloProf, fechaGrad, paisGraduacion);
        String toStringEperado = nombre + " " + apellido;
        assertEquals(prof.toString(), toStringEperado);
    }

    @Test
    public void testToStringDatosNull() {
        String nombre = null;
        String apellido = null;
        String fechaNacimiento = null;
        ImageIcon fotoPerfil = null;
        String tituloProf = null;
        String fechaGrad = null;
        String paisGraduacion = null;
        Profesional prof = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil,
                tituloProf, fechaGrad, paisGraduacion);
        String toStringEperado = "Nombre no ingresado";
        assertEquals(prof.toString(), toStringEperado);
    }

    public void testToStringDatosVacios() {
        String nombre = "";
        String apellido = "";
        String fechaNacimiento = "";
        ImageIcon fotoPerfil = null;
        String tituloProf = "";
        String fechaGrad = "";
        String paisGraduacion = "";
        Profesional prof = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil,
                tituloProf, fechaGrad, paisGraduacion);
        String toStringEperado = "Nombre no ingresado";
        assertEquals(prof.toString(), toStringEperado);
    }
}

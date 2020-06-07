package dominio;

import javax.swing.ImageIcon;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanAlimentacionTest {

    final String planAlimentacion = "Plan de alimentación";
    final String planDown = "Plan 2 Dias DOWN";
    final String fotoUsuario = "Imagenes/fotoDeUsuarioStandard.png";
    final String nacionalidadUruguay = "Uruguayo";
    final String nombreMartin = "Martin";
    final String nombreAlejandro = "Alejandro";
    final String fechaNacimiento = "11/02/98";
    final String apellidoGomez = "Gómez";
    final String apellidoFernandez = "Fernandez";
    final String alimento = "Manzana";
    
    @Test
    public void testGetsSetsNullToString() {
        String nombrePlan = null;
        Usuario usuario = null;
        Profesional profesional = null;
        boolean fueAtendido = false;
        String[][] planDiaADia = null;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.toString(), planAlimentacion);
    }

    @Test
    public void testGetsSetsDatosVaciosNombre() {
        String nombrePlan = "";
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional = new Profesional(null, null, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[0][0];
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.getNombreDelPlan(), planAlimentacion);
    }

    @Test
    public void testGetsSetsDatosVaciosUsuario() {
        String nombrePlan = "";
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional = new Profesional(null, null, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[0][0];
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        Usuario usuarioEsperado = new Usuario("", "", null, null, null, null, null, null);
        assertEquals(planATestear.getUsuario(), usuarioEsperado);
    }

    @Test
    public void testGetsSetsDatosVaciosProfesional() {
        String nombrePlan = "";
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional = new Profesional(null, null, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[0][0];
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        Profesional profesionalEsperado = new Profesional("", "", null, null, null, null, null);
        assertEquals(planATestear.getProfesional(), profesionalEsperado);
    }

    @Test
    public void testGetsSetsDatosVaciosFueAtendido() {
        String nombrePlan = "";
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional = new Profesional(null, null, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[0][0];
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.getFueAtendidoElPlan(), fueAtendido);
    }

    @Test
    public void testGetsSetsDatosVaciosPlanDiaADia() {
        String nombrePlan = "";
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional = new Profesional(null, null, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[0][0];
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        String[][] planEsperado = new String[0][0];
        Assert.assertArrayEquals(planATestear.getPlanDiaADia(), planEsperado);
    }

    @Test
    public void testGetsSetsDatosVaciosToString() {
        String nombrePlan = "";
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional = new Profesional(null, null, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[0][0];
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.toString(), planAlimentacion);
    }

    @Test
    public void testGetsSetsDatosCorrectosNombre() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.getNombreDelPlan(), nombrePlan);
    }

    @Test
    public void testGetsSetsDatosCorrectosProfesional() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        Profesional profesionalEsperado = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        assertEquals(planATestear.getProfesional(), profesionalEsperado);
    }

    @Test
    public void testGetsSetsDatosCorrectosFueAtendido() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.getFueAtendidoElPlan(), fueAtendido);
    }

    @Test
    public void testGetsSetsDatosCorrectosUsuario() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        Usuario usuarioEsperado = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        assertEquals(planATestear.getUsuario(), usuarioEsperado);
    }

    @Test
    public void testGetsSetsDatosCorrectosPlanDiaADia() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        Assert.assertArrayEquals(planATestear.getPlanDiaADia(), planDiaADia);
    }

    @Test
    public void testGetsSetsDatosCorrectosToString() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.toString(), nombrePlan);
    }

    @Test
    public void testEqualsIguales() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        PlanAlimentacion planAComparar = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear, planAComparar);
    }

    @Test
    public void testEqualsDiferentes() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        String nombrePlan2 = "Plan 2 Dias UP";
        PlanAlimentacion planAComparar = new PlanAlimentacion(nombrePlan2, usuario, profesional,
                fueAtendido, planDiaADia);
        assertNotEquals(planATestear, planAComparar);
    }
    
    @Test
    public void  testEqualsNull(){
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
         PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
         boolean resultadoEsperado = false;
         assertEquals(planATestear.equals(null), resultadoEsperado);
    }
    
     @Test
    public void  testEqualsTipoDiferente(){
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
         PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
         boolean resultadoEsperado = false;
         assertEquals(planATestear.equals(usuario), resultadoEsperado);
    }
    
    @Test
    public void testHashCode() {
        String nombrePlan = planDown;
        Usuario usuario = new Usuario(nombreMartin, apellidoGomez, fechaNacimiento, new ImageIcon(fotoUsuario), nacionalidadUruguay, null, null, null);
        Profesional profesional = new Profesional(nombreAlejandro, apellidoFernandez, null, null, null, null, null);
        boolean fueAtendido = true;
        String[][] planDiaADia = new String[2][2];
        planDiaADia[0][0] = alimento;
        planDiaADia[0][1] = alimento;
        planDiaADia[1][0] = alimento;
        planDiaADia[1][1] = alimento;
        PlanAlimentacion planATestear = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        PlanAlimentacion planATestear2 = new PlanAlimentacion(nombrePlan, usuario, profesional,
                fueAtendido, planDiaADia);
        assertEquals(planATestear.hashCode(), planATestear2.hashCode());
    }
    
  
    
}

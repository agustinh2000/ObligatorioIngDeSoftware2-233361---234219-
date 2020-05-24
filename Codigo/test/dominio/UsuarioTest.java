package dominio;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {
    @Test
    public void testGetsSetsVaciosListaAlimentos() {
        Usuario usuario = new Usuario("", "", "", null, "", null, null, null);
        assertEquals(usuario.getAlimentosIngeridos().size(), 0);
    }

    @Test
    public void testGetsSetsVaciosRestricciones() {
        Usuario usuario = new Usuario("", "", "", null, "", null, null, null);
        assertEquals(usuario.getRestricciones().size(), 0);
    }

    @Test
    public void testGetsSetsVaciosPreferencias() {
        Usuario usuario = new Usuario("", "", "", null, "", null, null, null);
        assertEquals(usuario.getPreferencias().size(), 0);
    }

    @Test
    public void testGetsSetsNullNombre() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getNombre(), "Nombre no ingresado");
    }

    @Test
    public void testGetsSetsNullApellido() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getApellido(), "Apellido no ingresado");
    }

    @Test
    public void testGetsSetsNullFechaNacimiento() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getFechaNacimiento(), "Fecha no ingresada");
    }

    @Test
    public void testGetsSetsNullNacionalidad() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getNacionalidad(), "Nacionalidad no ingresada");
    }

    @Test
    public void testGetsSetsNullListaAlimentos() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getAlimentosIngeridos().size(), 0);
    }

    @Test
    public void testGetsSetsNullRestricciones() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getRestricciones().size(), 0);
    }

    @Test
    public void testGetsSetsNullPreferencias() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(usuario.getPreferencias().size(), 0);
    }

    //NUEVAS PRUEBAS - mantenimiento
    @Test
    public void testSetPreferenciasNoNulas() {
        ArrayList<String> listaPreferencias = new ArrayList();
        listaPreferencias.add("lentejas");
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        usuario.setPreferencias(listaPreferencias);
        boolean resultadoEsperado = true;
        boolean resultado = usuario.getPreferencias().contains("lentejas");
        assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testGetArrayAlimentosIngeridosNulo() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        usuario.setAlimentosIngeridos(null);
        String[] resultadoEsperado = new String[0];
        String[] resultado = usuario.getArrayAlimentosIngeridos();
        assertArrayEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testGetArrayRestriccionesNulo() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        usuario.setRestricciones(null);
        String[] resultadoEsperado = new String[0];
        String[] resultado = usuario.getArrayRestricciones();
        assertArrayEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testGetArrayPreferenciasNulo() {
        Usuario usuario = new Usuario(null, null, null, null, null, null, null, null);
        usuario.setPreferencias(null);
        String[] resultadoEsperado = new String[0];
        String[] resultado = usuario.getArrayPreferencias();
        assertArrayEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testToString() {
        Usuario usuario = new Usuario("Juan", "Perez", null, null, null, null, null, null);
        String resultadoEsperado = "Juan Perez";
        String resultado = usuario.toString();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testActualizarPreferenciasUsuario() {
        Usuario usuario = new Usuario("Juan", "Perez", null, null, null, null, null, null);
        ArrayList<String> listaPreferencias = new ArrayList();
        listaPreferencias.add("lentejas");
        usuario.actualizarPreferenciasUsuario(usuario, listaPreferencias);
        ArrayList resultadoEsperado = listaPreferencias;
        ArrayList resultado = usuario.getPreferencias();
        assertEquals(resultadoEsperado, resultado);
    }
}

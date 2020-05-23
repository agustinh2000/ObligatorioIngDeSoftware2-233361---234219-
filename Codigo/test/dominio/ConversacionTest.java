package dominio;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConversacionTest {

    public ConversacionTest() {
    }

    @Test
    public void testGetSetsNullUsuario() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        Persona usuarioEsperado = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(conversacionATestear.getUsuario(), usuarioEsperado);
    }

    @Test
    public void testGetSetsNullProfesional() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        Persona profesionalEsperado = new Profesional(null, null, null, null, null, null, null);
        assertEquals(conversacionATestear.getProfesional(), profesionalEsperado);
    }

    @Test
    public void testGetSetsNullLsitaMensajes() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.getListaMensajes().size(), 0);
    }

    @Test
    public void testGetSetsNullToString() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.toString(), "No hay mensajes para mostrar");
    }

    @Test
    public void testGetSetsDatosVaciosProfesional() {
        Persona usuario = new Usuario(null, null, null, null, null, null, null, null);
        Persona profesional = new Profesional(null, null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        Persona profesionalEsperado = new Profesional(null, null, null, null, null, null, null);
        assertEquals(conversacionATestear.getProfesional(), profesionalEsperado);
    }

    @Test
    public void testGetSetsDatosVaciosListaMensajes() {
        Persona usuario = new Usuario(null, null, null, null, null, null, null, null);
        Persona profesional = new Profesional(null, null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.getListaMensajes().size(), 0);
    }

    @Test
    public void testGetSetsDatosVaciosToString() {
        Persona usuario = new Usuario(null, null, null, null, null, null, null, null);
        Persona profesional = new Profesional(null, null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.toString(), "No hay mensajes para mostrar");
    }

    //NUEVAS PRUEBAS - mantenimiento
    @Test
    public void testGetFueAtendidaConsulta() {
        Conversacion conversacion = new Conversacion(null, null, null);
        boolean resultadoEsperado = false;
        boolean resultado = conversacion.getFueAtendidaConsulta();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAgregarMensaje() {
        Conversacion conversacion = new Conversacion(null, null, null);
        boolean resultadoEsperado = true;
        boolean resultado = conversacion.agregarMensaje("", true);
        assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testEquals(){
        Persona profesional = new Profesional(null, null, null, null, null,
                null, null);
        Usuario usuario = new Usuario(null, null, null, null, null, null, 
                null, null);
        Conversacion conversacion = new Conversacion(usuario, profesional, null);
        boolean resultadoEsperado = true;
        boolean resultado = conversacion.equals(conversacion);
        assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testNotEquals(){
        Persona profesional = new Profesional("Jose", null, null, null, null,
                null, null);
        Usuario usuario = new Usuario("Juan", null, null, null, null, null, 
                null, null);
        Conversacion conversacion = new Conversacion(usuario, profesional, null);
        Conversacion conversacionAComparar = new Conversacion(null, null, null);
        boolean resultadoEsperado = false;
        boolean resultado = conversacion.equals(conversacionAComparar);
        assertEquals(resultadoEsperado, resultado);
    }
}

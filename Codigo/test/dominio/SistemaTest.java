package dominio;

import dominio.Sistema.DiasDeLaSemana;
import dominio.Sistema.IngestasPorDia;
import dominio.Sistema.Paises;
import dominio.Sistema.Preferencias;
import dominio.Sistema.Restricciones;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    final String nombreMartin = "Martin";
    final String apellidoGomez = "Gómez";
    final String nombreSandra = "Sandra";
    final String nombreMaria = "Maria";
    final String apellidoPazos = "Pazos";
    final String fechaIngesta = "11/02/17";
    final String fechaIngestaDos = "11/02/16";
    final String nombrePlanPrueba = "plan prueba";
    final String nombrePlan = "Plan de alimentación";
    final String apellidoRodriguez = "Rodriguez";
    final String paisGraduacion = "Argentina";
    final String paisGraduacionDos = "Uruguay";
    final String alimentoLegumbre = "legumbre";
    final String alimentoLentejas = "lentejas";
    final String apellidoPerez = "Perez";
    final String nombreMarcos = "Marcos";
    final String fechaNacimiento = "1/5/1998";
    final String fechaNacimientoDos = "1/5/1978";
    final String fechaGraduacion = "7/8/2018";
    final String titulo = "nutricionista";

    @Test
    public void testGetsSetsNullListaAlimentos() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaAlimentos().size(), 0);
    }

    @Test
    public void testGetsSetsNullListaPlanes() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaPlanesAlimentacion().size(), 0);
    }

    @Test
    public void testGetsSetsNullListaConversaciones() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaConversaciones().size(), 0);
    }

    @Test
    public void testGetsSetsNullPersonaLogueada() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        Persona personaLogueadaEsperada = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(sistemaATestear.getPersonaLogueada(), personaLogueadaEsperada);
    }

    @Test
    public void testGetsSetsDatosVaciosListaUsuarios() {
        Sistema sistemaATestear = new Sistema();
        assertEquals(sistemaATestear.getListaUsuarios().size(), 0);
    }

    @Test
    public void testGetsSetsDatosVaciosListaAlimentos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Profesional> listaProfesionales = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        ArrayList<Conversacion> listaConversaciones = new ArrayList<>();
        Persona personaLogueada = new Usuario(null, null, null, null, null, null, null, null);
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaAlimentos().size(), 0);
    }

    @Test
    public void testAgregarMensajeConversacionListaVacia() {
        Sistema sistemaATestear = new Sistema();
        boolean pudeAgregarMensaje = sistemaATestear.agregarMensajeConversacion(nombreMartin, "Lucia", "aa", false, false);
        assertFalse(pudeAgregarMensaje);
    }

    @Test
    public void testAgregarMensajeConversacionNull() {
        Sistema sistemaATestear = new Sistema();
        boolean pudeAgregarMensaje = sistemaATestear.agregarMensajeConversacion("Luis", "Diaz", "Segundo mensaje", false, false);
        assertFalse(pudeAgregarMensaje);
    }

    @Test
    public void testDevolverAlimentoNull() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Alimento alimentoEsperado = new Alimento(null, null, null, null);
        assertEquals(sistemaATestear.devolverAlimentoDadoNombre(null), alimentoEsperado);
    }

    @Test
    public void testDevolverAlimentoDatosVacios() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Alimento alimentoEsperado = new Alimento("", "", null, null);
        assertEquals(sistemaATestear.devolverAlimentoDadoNombre(""), alimentoEsperado);
    }

    @Test
    public void testDevolverAlimentoDatosCorrectos() {
        ArrayList listaAlimentos = new ArrayList<>();
        Alimento alimentoEsperado = new Alimento("Papa", "Verdura", null, null);
        listaAlimentos.add(alimentoEsperado);
        Sistema sistemaATestear = new Sistema(null, null, listaAlimentos, null, null, null);
        assertEquals(sistemaATestear.devolverAlimentoDadoNombre("Papa"), alimentoEsperado);
    }

    @Test
    public void testDevolverAlimentoDatosErroneos() {
        ArrayList listaAlimentos = new ArrayList<>();
        Alimento alimentoEsperado = new Alimento("Papa", "Verdura", null, null);
        listaAlimentos.add(alimentoEsperado);
        Sistema sistemaATestear = new Sistema(null, null, listaAlimentos, null, null, null);
        assertNotEquals(sistemaATestear.devolverAlimentoDadoNombre("Luca"), alimentoEsperado);
    }

    @Test
    public void testUsuarioDevolverPorNombreNull() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuarioEsperado = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(sistemaATestear.getUsuarioPorNombre(null), usuarioEsperado);
    }

    @Test
    public void testProfesionalDevolverPorNombreNull() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Profesional profesionalEsperado = new Profesional(null, null, null, null, null, null, null);
        assertEquals(sistemaATestear.getProfesionalPorNombre(null), profesionalEsperado);
    }

    @Test
    public void testDevolverProfesionalPorNombreDatosVacios() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Profesional profesionalEsperado = new Profesional(null, null, null, null, null, null, null);
        assertEquals(sistemaATestear.getProfesionalPorNombre(""), profesionalEsperado);
    }

    @Test
    public void testDevolverProfesionalPorNombreDatosErroneos() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Profesional profesionalEsperado = new Profesional(nombreMartin, null, null, null, null, null, null);
        sistemaATestear.agregarProfesionalALaLista(profesionalEsperado);
        assertEquals(sistemaATestear.getProfesionalPorNombre(nombreMartin), profesionalEsperado);
    }

    @Test
    public void testDevolverUsuarioPorNombreDatosVacios() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuarioEsperado = new Usuario(null, null, null, null, null, null, null, null);
        assertEquals(sistemaATestear.getUsuarioPorNombre(""), usuarioEsperado);
    }

    @Test
    public void testDevolverUsuarioPorNombreDatosErroneos() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuario = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        sistemaATestear.agregarUsuarioALaLista(usuario);
        assertEquals(sistemaATestear.getUsuarioPorNombre(nombreMartin), usuario);
    }

    @Test
    public void testAgregarPlanAlimentacionUsuarioNull() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuario1 = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional1 = new Profesional(null, null, null, null, null, null, null);
        assertTrue(sistemaATestear.agregarPlanSolicitado(usuario1, profesional1));
    }

    @Test
    public void testAgregarPlanAlimentacionRepetidos() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuario1 = new Usuario(null, null, null, null, null, null, null, null);
        Profesional profesional1 = new Profesional(null, null, null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertFalse(sistemaATestear.agregarPlanSolicitado(usuario1, profesional1));
    }

    @Test
    public void testPlanesPendientes() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuario1 = new Usuario(nombreMartin, apellidoGomez, null, null, null, null, null, null);
        Profesional profesional1 = new Profesional(nombreSandra, apellidoPazos, null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertEquals(sistemaATestear.getListaUsuariosConPlanesPendientes(profesional1).length, 1);
    }

    @Test
    public void testPlanesPendientes2() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuario1 = new Usuario(nombreMartin, apellidoGomez, null, null, null, null, null, null);
        Profesional profesional1 = new Profesional(nombreSandra, apellidoPazos, null, null, null, null, null);
        Profesional profesional2 = new Profesional("Joaquin", "Bardanca", null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertEquals(sistemaATestear.getListaUsuariosConPlanesPendientes(profesional2).length, 0);
    }

    @Test
    public void testPlanesPendientesNull() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        Usuario usuario1 = new Usuario(nombreMartin, apellidoGomez, null, null, null, null, null, null);
        Profesional profesional1 = new Profesional(nombreSandra, apellidoPazos, null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertEquals(sistemaATestear.getListaUsuariosConPlanesPendientes(null).length, 0);
    }

    @Test
    public void testAgregarAListaConversacionesDatosErroneos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Profesional> listaProfesionales = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        ArrayList<Conversacion> listaConversaciones = new ArrayList<>();
        Persona personaLogueada = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        Persona usuarioConversacion = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Persona profesionalConversacion = new Profesional("Luis", null, null, null, null, null, null);
        sistemaATestear.crearConversacion(usuarioConversacion, profesionalConversacion, "Hola", true);
        boolean agregoConversacionRepetida = sistemaATestear.crearConversacion(usuarioConversacion, profesionalConversacion, "Hola", true);
        assertFalse(agregoConversacionRepetida);
    }

    @Test
    public void testAgregarIngestaDatosCorrectos() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        Ingesta ingesta1 = new Ingesta(fechaIngesta, null);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        sistemaATestear.crearUsuario(nombreMartin, null, null, null, null, null, null, null);
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(listaIngestas, fechaIngestaDos, "Papa");
        assertTrue(retorno);
    }

    @Test
    public void testAgregarIngestaRepetida() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Papa", null, null, null));
        Ingesta ingesta1 = new Ingesta(fechaIngesta, listaAlimentos);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        sistemaATestear.crearUsuario(nombreMartin, null, null, null, null, null, null, null);
        sistemaATestear.agregarIngestaAUsuario(listaIngestas, fechaIngesta, "Papa");
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre(nombreMartin);
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), fechaIngestaDos, "Papa");
        assertTrue(retorno);
    }

    @Test
    public void testAgregarIngestaFechaRepetida() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Papa", null, null, null));
        Ingesta ingesta1 = new Ingesta(fechaIngesta, listaAlimentos);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        sistemaATestear.crearUsuario(nombreMartin, null, null, null, null, null, null, null);
        sistemaATestear.agregarIngestaAUsuario(listaIngestas, fechaIngesta, "Papa");
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre(nombreMartin);
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), fechaIngesta, "Papa");
        assertTrue(retorno);
    }

    @Test
    public void testAgregarIngestaFechaNull() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Papa", null, null, null));
        Ingesta ingesta1 = new Ingesta(null, listaAlimentos);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        sistemaATestear.crearUsuario(nombreMartin, null, null, null, null, null, null, null);
        sistemaATestear.agregarIngestaAUsuario(listaIngestas, null, "Papa");
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre(nombreMartin);
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), null, "Papa");
        assertFalse(retorno);
    }

    @Test
    public void testAgregarIngestaAlimentoRepetidoFechaDistinta() {
        Sistema sistemaATestear = new Sistema(null, null, null, null, null, null);
        sistemaATestear.crearUsuario(nombreMartin, null, null, null, null, null, null, null);
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre(nombreMartin);
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), fechaIngestaDos, "Papa");
        assertTrue(retorno);
    }

    @Test
    public void testDevolverPlanDadoNombreNull() {
        Sistema sistemaATestear = new Sistema();
        Profesional unProfesional = new Profesional(null, null, null, null, null, null, null);
        Usuario unUsuario = new Usuario(null, null, null, null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(unUsuario, unProfesional);
        sistemaATestear.atenderSolicitudDelPlan(null, unProfesional, unUsuario, nombrePlanPrueba);
        PlanAlimentacion planResultado = sistemaATestear.devolverPlanDadoNombre(nombrePlanPrueba);
        assertEquals(planResultado, new PlanAlimentacion(nombrePlanPrueba, unUsuario, unProfesional, true, null));
    }

    @Test
    public void testDevolverPlanDatosValidos() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertEquals(sistemaATestear.devolverPlanDadoNombre("Plan"), plan1);
    }

    @Test
    public void testDevolverPlanNoPertenece() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertEquals(sistemaATestear.devolverPlanDadoNombre("Plan").getNombreDelPlan(), plan1.getNombreDelPlan());
    }

    @Test
    public void testAtenderSolicitudPlan() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, plan1.getNombreDelPlan());
        assertTrue(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanAtendidoTrue() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, true, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, nombrePlan);
        assertFalse(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanProfesionalDistinto() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        Profesional professional2 = new Profesional("Lautaro", null, null, null, null, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional2,
                user1, plan1.getNombreDelPlan());
        assertFalse(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanUsuarioDistinto() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        Usuario user2 = new Usuario("Martina", null, null, null, null, null, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user2, plan1.getNombreDelPlan());
        assertFalse(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanListaVacia() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, plan1.getNombreDelPlan());
        assertFalse(fueAtendido);
    }

    @Test
    public void testListaPlanesAtendidosDatosCorrectos() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion(nombrePlan, user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, plan1.getNombreDelPlan());
        boolean sonIguales = sistemaATestear.planesAtendidosDelUsuario(user1)[0].equals(plan1.getNombreDelPlan());
        assertTrue(sonIguales);
    }

    @Test
    public void testListaPlanesAtendidosListaVacia() {
        Usuario user1 = new Usuario(nombreMartin, null, null, null, null, null, null, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertEquals(sistemaATestear.planesAtendidosDelUsuario(user1).length, 0);
    }

    @Test
    public void testEnumPreferenciasCarnesBlancas() {
        String resultadoEsperado = "CarnesBlancas";
        assertEquals(Preferencias.CarnesBlancas.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasCarnesRojas() {
        String resultadoEsperado = "CarnesRojas";
        assertEquals(Preferencias.CarnesRojas.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasVerduras() {
        String resultadoEsperado = "Verduras";
        assertEquals(Preferencias.Verduras.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasFrutas() {
        String resultadoEsperado = "Frutas";
        assertEquals(Preferencias.Frutas.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasHarinas() {
        String resultadoEsperado = "Harinas";
        assertEquals(Preferencias.Harinas.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesDiabetes() {
        String resultadoEsperado = "Diabetes";
        assertEquals(Restricciones.Diabetes.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesVeganismo() {
        String resultadoEsperado = "Veganismo";
        assertEquals(Restricciones.Veganismo.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesIntoleranciaLactosa() {
        String resultadoEsperado = "IntoleranciaLactosa";
        assertEquals(Restricciones.IntoleranciaLactosa.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesHarinas() {
        String resultadoEsperado = "Celiaquia";
        assertEquals(Restricciones.Celiaquia.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaJueves() {
        String resultadoEsperado = "Jueves";
        assertEquals(DiasDeLaSemana.Jueves.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaViernes() {
        String resultadoEsperado = "Viernes";
        assertEquals(DiasDeLaSemana.Viernes.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaSabado() {
        String resultadoEsperado = "Sabado";
        assertEquals(DiasDeLaSemana.Sabado.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaDomingo() {
        String resultadoEsperado = "Domingo";
        assertEquals(DiasDeLaSemana.Domingo.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaMiercoles() {
        String resultadoEsperado = "Miercoles";
        assertEquals(DiasDeLaSemana.Miercoles.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaMartes() {
        String resultadoEsperado = "Martes";
        assertEquals(DiasDeLaSemana.Martes.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaLunes() {
        String resultadoEsperado = "Lunes";
        assertEquals(DiasDeLaSemana.Lunes.name(), resultadoEsperado);
    }

    @Test
    public void testEnumIngestasDiaDesayuno() {
        String resultadoEsperado = "Desayuno";
        assertEquals(IngestasPorDia.Desayuno.name(), resultadoEsperado);
    }

    @Test
    public void testEnumIngestasDiaAlmuerzo() {
        String resultadoEsperado = "Almuerzo";
        assertEquals(IngestasPorDia.Almuerzo.name(), resultadoEsperado);
    }

    @Test
    public void testEnumIngestasDiaCena() {
        String resultadoEsperado = "Cena";
        assertEquals(IngestasPorDia.Cena.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDevolverListaIngestas() {
        Sistema sistemaATestear = new Sistema();
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Desayuno");
        listaEsperada.add("Almuerzo");
        listaEsperada.add("Cena");
        assertEquals(sistemaATestear.devolverListaIngestasDeLaSemana(), listaEsperada);
    }

    @Test
    public void testEnumDevolverListaDiasDeLaSemana() {
        Sistema sistemaATestear = new Sistema();
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Lunes");
        listaEsperada.add("Martes");
        listaEsperada.add("Miercoles");
        listaEsperada.add("Jueves");
        listaEsperada.add("Viernes");
        listaEsperada.add("Sabado");
        listaEsperada.add("Domingo");
        assertEquals(sistemaATestear.devolverListaDiasDeLaSemana(), listaEsperada);
    }

    @Test
    public void testCrearProfesional() {
        Sistema miSistema = new Sistema();
        boolean resultadoEsperado = true;
        boolean result = miSistema.crearProfesional("Jose", "Rodriguez",
                "10/5/1990", null, "Doctor", "20/2/2020", paisGraduacion);
        assertEquals(resultadoEsperado, result);
    }

    @Test
    public void testAgregarProfesionalALaLista() {
        Sistema miSistema = new Sistema();
        boolean resultadoEsperado = true;
        Profesional unProfesional = new Profesional(null, null, null, null, null, null, null);
        boolean resultado = miSistema.agregarProfesionalALaLista(unProfesional);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAgregarProfesionalALaListaYaContenido() {
        Sistema miSistema = new Sistema();
        boolean resultadoEsperado = false;
        Profesional unProfesional = new Profesional(null, null, null, null, null, null, null);
        miSistema.agregarProfesionalALaLista(unProfesional);
        boolean resultado = miSistema.agregarProfesionalALaLista(unProfesional);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAgregarAlimentoALaListaYaContenido() {
        Sistema miSistema = new Sistema();
        Alimento alimento = new Alimento(alimentoLentejas, alimentoLegumbre, null, null);
        miSistema.agregarAlimentoALaLista(alimento);
        boolean resultado = miSistema.agregarAlimentoALaLista(alimento);
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAgregarAlimentoALaLista() {
        Sistema miSistema = new Sistema();
        Alimento alimento = new Alimento(alimentoLentejas, alimentoLegumbre, null, null);
        boolean resultadoEsperado = true;
        boolean resultado = miSistema.agregarAlimentoALaLista(alimento);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testCrearAlimento() {
        Sistema miSistema = new Sistema();
        miSistema.crearAlimento(alimentoLentejas, alimentoLegumbre, null, null);
        Alimento alimento = new Alimento(alimentoLentejas, alimentoLegumbre, null, null);
        boolean resultadoEsperado = true;
        boolean resultado = miSistema.getListaAlimentos().contains(alimento);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testGetConversacion() {
        Sistema miSistema = new Sistema();
        String resultadoEsperado = "No hay conversación disponible.";
        String resultado = miSistema.getConversacion(null, null);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testGetListaNombresUsuariosConversacionesPendientes() {
        Sistema miSistema = new Sistema();
        String[] resultadoEsperado = new String[0];
        String[] resultado
                = miSistema.getListaNombresUsuariosConversacionesPendientes("");
        assertArrayEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testGetListaNombresProfesionalesConversaciones() {
        Sistema miSistema = new Sistema();
        String[] resultadoEsperado = new String[0];
        String[] resultado
                = miSistema.getListaNombresProfesionalesConversaciones("");
        assertArrayEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testEnumPaisesNombre() {
        String resultadoEsperado = paisGraduacion;
        assertEquals(Paises.Argentina.name(), resultadoEsperado);
    }

    @Test
    public void testCrearConversacionNoRemitente() {
        Sistema miSistema = new Sistema();
        boolean resultadoEsperado = false;
        Profesional p = new Profesional(null, null, null, null, null, null, null);
        Usuario u = new Usuario(null, null, null, null, null, null, null, null);
        boolean resultado = miSistema.crearConversacion(u, p, "Hola",
                false);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testDevolverListaPaises() {
        Sistema miSistema = new Sistema();
        ArrayList<String> listaEsperada = new ArrayList<>();
        for (Paises pais : Paises.values()) {
            listaEsperada.add(pais.toString());
        }
        ArrayList<String> listaObtenida = miSistema.devolverListaPaises();
        assertEquals(listaEsperada, listaObtenida);
    }

    @Test
    public void testGetNombresProfesionalesSinConversacionConUsuarioNula() {
        Sistema miSistema = new Sistema();
        Persona usuario = new Usuario("Juan", apellidoPerez, null, null, null, null,
                null, null);
        ArrayList resultadoEsperado = new ArrayList<>();
        ArrayList resultado
                = miSistema.getNombresProfesionalesSinConversacionConUsuario(usuario);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testProfesionalesDelMismoPais() {
        Sistema miSistema = new Sistema();

        Profesional profesionalA = new Profesional(nombreMarcos, "Rodriguez",
                "1/5/1988", null, "", fechaGraduacion, paisGraduacionDos);
        miSistema.agregarProfesionalALaLista(profesionalA);

        Profesional profesionalB = new Profesional(nombreMaria, "Diaz", fechaNacimiento,
                null, "", fechaGraduacion, paisGraduacion);
        miSistema.agregarProfesionalALaLista(profesionalB);

        Profesional profesional = new Profesional("Jose", apellidoPerez, fechaNacimientoDos,
                null, "", fechaGraduacion, paisGraduacionDos);

        ArrayList<Profesional> listaEsperada = new ArrayList<>();
        listaEsperada.add(profesionalA);

        ArrayList<Profesional> listaRetorno = miSistema.profesionalesDelMismoPais(profesional);

        assertArrayEquals(listaEsperada.toArray(), listaRetorno.toArray());
    }

    @Test
    public void testProfesionalesConElMismotitulo() {
        Sistema miSistema = new Sistema();

        Profesional profesionalA = new Profesional(nombreMarcos, apellidoRodriguez,
                "1/5/1988", null, titulo, fechaGraduacion, "Perú");
        miSistema.agregarProfesionalALaLista(profesionalA);

        Profesional profesionalB = new Profesional(nombreMaria, "Diaz", fechaNacimiento,
                null, "medico", fechaGraduacion, paisGraduacion);
        miSistema.agregarProfesionalALaLista(profesionalB);

        Profesional profesional = new Profesional("Jose", apellidoPerez, fechaNacimientoDos,
                null, titulo, fechaGraduacion, paisGraduacionDos);

        ArrayList<Profesional> listaEsperada = new ArrayList<>();
        listaEsperada.add(profesionalA);

        ArrayList<Profesional> listaRetorno = miSistema.profesionalesConElMismoTitulo(profesional);

        assertArrayEquals(listaEsperada.toArray(), listaRetorno.toArray());
    }

    @Test
    public void testProfesionalesMismoAnioGraduacion() {
        Sistema miSistema = new Sistema();

        Profesional profesionalA = new Profesional(nombreMarcos, apellidoRodriguez,
                "1/5/1988", null, titulo, fechaGraduacion, "Perú");
        miSistema.agregarProfesionalALaLista(profesionalA);

        Profesional profesionalB = new Profesional(nombreMaria, "Diaz", fechaNacimiento,
                null, "medico", "7/8/2004", paisGraduacion);
        miSistema.agregarProfesionalALaLista(profesionalB);

        Profesional profesional = new Profesional("Jose", apellidoPerez, fechaNacimientoDos,
                null, titulo, fechaGraduacion, paisGraduacionDos);

        ArrayList<Profesional> listaEsperada = new ArrayList<>();
        listaEsperada.add(profesionalA);

        ArrayList<Profesional> listaRetorno = miSistema.profesionalesMismoAnioGraduacion(profesional);

        assertArrayEquals(listaEsperada.toArray(), listaRetorno.toArray());
    }

}

package dominio;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class AlimentoTest {

    final String lipidos = "lipidos";
    final String verdura = "verdura";
    final String rabanito = "rabanito";
    final String nombrePorDefecto = "Nombre de alimento no ingresado";

    @Test
    public void testSetsGetsNullTipo() {
        Alimento alimentoTest = new Alimento(null, null, null, null);
        assertEquals(alimentoTest.getTipoAlimento(), "No definido");
    }

    @Test
    public void testSetsGetsNullListaNutrientes() {
        Alimento alimentoTest = new Alimento(null, null, null, null);
        assertEquals(alimentoTest.getListaNutrientesConProporcion().size(), 0);
    }

    @Test
    public void testSetsGetsDatosCorrectosNombre() {
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimentoTest = new Alimento("Papa", verdura, listaComposicion, null);
        assertEquals(alimentoTest.getNombre(), "Papa");
    }

    @Test
    public void testSetsGetsDatosCorrectosTipo() {
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimentoTest = new Alimento("Papa", verdura, listaComposicion, null);
        assertEquals(alimentoTest.getTipoAlimento(), verdura);
    }

    @Test
    public void testSetsGetsDatosCorrectosNutrientes() {
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimentoTest = new Alimento("Papa", verdura, listaComposicion, null);
        assertEquals(alimentoTest.getListaNutrientesConProporcion(), listaComposicion);
    }

    @Test
    public void testSetsGetsListaNutrientesDatosVacios() {
        Alimento alimentoTest = new Alimento("", "", null, null);
        assertEquals(alimentoTest.getListaNutrientesConProporcion().size(), 0);
    }

    @Test
    public void testSetsGetsNombreDatosVacios() {
        Alimento alimentoTest = new Alimento("", "", null, null);
        assertEquals(alimentoTest.getNombre(), nombrePorDefecto);
    }

    @Test
    public void testSetsGetsTipoDatosVacios() {
        Alimento alimentoTest = new Alimento("", "", null, null);
        assertEquals(alimentoTest.getTipoAlimento(), "No definido");
    }

    @Test
    public void testToStringNullNombre() {
        Alimento alimentoTest = new Alimento("", "", null, null);
        assertEquals(alimentoTest.getNombre(), nombrePorDefecto);
    }

    @Test
    public void testToStringNull() {
        Alimento alimentoTest = new Alimento("", "", null, null);
        assertEquals(alimentoTest.toString(), nombrePorDefecto);
    }

    @Test
    public void testToStringDatosCorrectos() {
        Alimento alimentoTest = new Alimento("Papa", "", null, null);
        assertEquals(alimentoTest.toString(), "Papa");
    }

    @Test
    public void testEqualsIguales() {
        Alimento alimentoTest = new Alimento("Papa", "", null, null);
        Alimento alimentoTest2 = new Alimento("Papa", "", null, null);
        assertEquals(alimentoTest, alimentoTest2);
    }

    @Test
    public void testEqualsDiferentes() {
        Alimento alimentoTest = new Alimento(rabanito, "", null, null);
        Alimento alimentoTest2 = new Alimento("Papa", "", null, null);
        boolean sonIguales = alimentoTest.equals(alimentoTest2);
        assertFalse(sonIguales);
    }

    @Test
    public void testEqualsNull() {
        Alimento alimentoTest = new Alimento(rabanito, "", null, null);
        assertFalse(alimentoTest.equals(null));
    }

    @Test
    public void testEqualsDiferenteTipo() {
        Alimento alimentoTest = new Alimento(rabanito, "", null, null);
        Usuario usuarioTest = new Usuario("Luis", "Diaz", "", null, null, null, null, null);
        assertFalse(alimentoTest.equals(usuarioTest));
    }

    @Test
    public void testHashCode() {
        Alimento alimentoTest = new Alimento(rabanito, "", null, null);
        Alimento alimentoTest2 = new Alimento("Papa", "", null, null);
        assertFalse(alimentoTest.hashCode() == alimentoTest2.hashCode());
    }

}

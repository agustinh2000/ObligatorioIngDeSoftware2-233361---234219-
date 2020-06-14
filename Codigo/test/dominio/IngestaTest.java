package dominio;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngestaTest {
    
    final String fechaIngesta = "11/02/17";
    final String lipidos = "lipidos";
    final String verdura = "verdura";

    @Test
    public void testGetsSetsDatosValidosListaAlimentos() {
        String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        assertEquals(ingestaATestear.getListaAlimentosPorFecha(), listaAlimentosPorFecha);
    }

    @Test
    public void testGetsSetsDatosValidosToString() {
        String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        String toStringEsperado = "Lista de alimentos ingeridos" + listaAlimentosPorFecha;
        assertEquals(ingestaATestear.toString(), toStringEsperado);
    }

    @Test
    public void testEqualsIgualesLista() {
        String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        Ingesta ingestaAComparar = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        boolean resultadoEquals = ingestaATestear.equals(ingestaAComparar);
        assertTrue(resultadoEquals);
    }

    @Test
    public void testEqualsDistintosFecha() {
        String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        Ingesta ingestaAComparar = new Ingesta(fechaDeIngesta, new ArrayList<>());
        boolean resultadoEquals = ingestaATestear.equals(ingestaAComparar);
        assertFalse(resultadoEquals);
    }
    
    @Test
    public void testEqualsNull(){
        String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        assertFalse(ingestaATestear.equals(null));
    }
    
     @Test
    public void testEqualsDiferenteTipo(){
        String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        assertFalse(ingestaATestear.equals(alimento1));
    }
    
    public void testHashCode(){
         String fechaDeIngesta = fechaIngesta;
        ArrayList<ComposicionAlimento> listaComposicion = new ArrayList<>();
        listaComposicion.add(new ComposicionAlimento(lipidos, 2));
        Alimento alimento1 = new Alimento("Papa", verdura, listaComposicion, null);
        ArrayList<Alimento> listaAlimentosPorFecha = new ArrayList<>();
        listaAlimentosPorFecha.add(alimento1);
        Ingesta ingestaATestear = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        Ingesta ingestaATestear2 = new Ingesta(fechaDeIngesta, listaAlimentosPorFecha);
        assertEquals(ingestaATestear.hashCode(), ingestaATestear2.hashCode());

    }


}

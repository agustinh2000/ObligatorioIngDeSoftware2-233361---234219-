package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public final class Ingesta implements Serializable {

    private String fechaDeIngesta;
    private ArrayList<Alimento> listaAlimentosPorFecha;

    public Ingesta(String unaFechaDeIngesta, ArrayList<Alimento> unaListaDeAlimentosPorFecha) {
        setFechaDeIngesta(unaFechaDeIngesta);
        setListaAlimentosPorFecha(unaListaDeAlimentosPorFecha);
    }

    public String getFechaDeIngesta() {
        return this.fechaDeIngesta;
    }

    public void setFechaDeIngesta(String unaFecha) {
        if (unaFecha == null || unaFecha.isEmpty()) {
            this.fechaDeIngesta = "Fecha de ingesta no registrada";
        } else {
            this.fechaDeIngesta = unaFecha;
        }
    }

    public ArrayList<Alimento> getListaAlimentosPorFecha() {
        if (this.listaAlimentosPorFecha.isEmpty()) {
            return new ArrayList<>();
        } else {
            return this.listaAlimentosPorFecha;
        }
    }

    public void setListaAlimentosPorFecha(ArrayList<Alimento> unaListaDeAlimentos) {
        if (unaListaDeAlimentos == null || unaListaDeAlimentos.isEmpty()) {
            this.listaAlimentosPorFecha = new ArrayList<>();
        } else {
            this.listaAlimentosPorFecha = unaListaDeAlimentos;
        }
    }

    @Override
    public String toString() {
        if (this.listaAlimentosPorFecha.isEmpty()) {
            return "No hay alimentos ingeridos";
        } else {
            return "Lista de alimentos ingeridos" + this.getListaAlimentosPorFecha();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Ingesta otraIngesta = (Ingesta) obj;
        boolean sonIguales = this.getFechaDeIngesta().equals(otraIngesta.getFechaDeIngesta());
        sonIguales = sonIguales && this.getListaAlimentosPorFecha().equals(otraIngesta.getListaAlimentosPorFecha());
        return sonIguales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.fechaDeIngesta);
        hash = 83 * hash + Objects.hashCode(this.listaAlimentosPorFecha);
        return hash;
    }

}

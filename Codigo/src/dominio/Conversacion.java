package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public final class Conversacion implements Serializable {

    private ArrayList<InformacionMensaje> listaMensajes;
    private Persona usuario;
    private Persona profesional;
    private boolean fueAtendidaConsulta;

    public Conversacion(Persona unUsuario, Persona unaPersona, 
            ArrayList<InformacionMensaje> listaDeMensajes) {
        setUsuario(unUsuario);
        setProfesional(unaPersona);
        setListaMensajes(listaDeMensajes);
        setFueAtendidaConsulta(false);
    }

    public boolean getFueAtendidaConsulta() {
        return fueAtendidaConsulta;
    }

    public void setFueAtendidaConsulta(boolean fueAtendida) {
        this.fueAtendidaConsulta = fueAtendida;
    }

    public ArrayList<InformacionMensaje> getListaMensajes() {
        return this.listaMensajes;
    }

    public void setListaMensajes(ArrayList<InformacionMensaje> unaListaDeMensajes) {
        if (unaListaDeMensajes == null || unaListaDeMensajes.isEmpty()) {
            this.listaMensajes = new ArrayList<>();
        } else {
            this.listaMensajes = unaListaDeMensajes;
        }
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona unUsuario) {
        if (unUsuario == null) {
            this.usuario = new Usuario(null, null, null, null, null, null, null, null);
        } else {
            this.usuario = unUsuario;
        }
    }

    public Persona getProfesional() {
        return this.profesional;
    }

    public void setProfesional(Persona unProfesional) {
        if (unProfesional == null) {
            this.profesional = new Profesional(null, null, null, null, null, null, null);
        } else {
            this.profesional = unProfesional;
        }
    }

    public boolean agregarMensaje(String mensaje, boolean intercambioRemitente) {
        InformacionMensaje informacion = new InformacionMensaje(getUsuario().getNombreCompleto(),
                getProfesional().getNombreCompleto(), mensaje);
        if (intercambioRemitente) {
            informacion.intercambiarRemitente();
        }
        listaMensajes.add(informacion);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Conversacion conversacionParametro = (Conversacion) obj;
        return getProfesional().equals(conversacionParametro.getProfesional())
                && getUsuario().equals(conversacionParametro.getUsuario());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.listaMensajes);
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.profesional);
        hash = 79 * hash + (this.fueAtendidaConsulta ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        String retorno = "No hay mensajes para mostrar";
        if (!getListaMensajes().isEmpty()) {
            retorno = "";
            retorno = listaMensajes.stream().map((InformacionMensaje info) -> 
                    "\n" + info.getRemitente() + "\n"
                    + info.getMensaje() + "\n").reduce(retorno, String::concat);
        }
        return retorno;
    }

}

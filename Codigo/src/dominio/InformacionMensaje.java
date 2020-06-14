package dominio;

import java.io.Serializable;

public final class InformacionMensaje implements Serializable {

    private String mensaje;
    private String destinatario;
    private String remitente;

    public InformacionMensaje(String unRemitente, String unDestinatario, 
            String unMensaje) {
        setRemitente(unRemitente);
        setDestinatario(unDestinatario);
        setMensaje(unMensaje);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String unMensaje) {
        mensaje = unMensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String unDestinatario) {
        if (unDestinatario == null || unDestinatario.isEmpty()) {
            this.destinatario = "Destinatario no ingresado";
        } else {
            this.destinatario = unDestinatario;
        }

    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String unRemitente) {
        if (unRemitente == null || unRemitente.isEmpty()) {
            this.remitente = "Remitente no ingresado";
        } else {
            this.remitente = unRemitente;
        }
    }

    public void intercambiarRemitente() {
        String aux = destinatario;
        destinatario = remitente;
        remitente = aux;
    }

    @Override
    public String toString() {
        return getRemitente() + ": \n" + getMensaje();
    }

}

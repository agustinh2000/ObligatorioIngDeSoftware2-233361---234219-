package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.ImageIcon;

public abstract class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private ImageIcon fotoDePerfil;

    static final String NOMBRE_POR_DEFECTO = "Nombre no ingresado";
    static final String APELLIDO_POR_DEFECTO = "Apellido no ingresado";

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String unNombre) {
        if (unNombre == null || unNombre.isEmpty()) {
            this.nombre = NOMBRE_POR_DEFECTO;
        } else {
            this.nombre = unNombre;
        }
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String unApellido) {
        if (unApellido == null || unApellido.isEmpty()) {
            this.apellido = APELLIDO_POR_DEFECTO;
        } else {
            this.apellido = unApellido;
        }
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String unaFecha) {
        if (unaFecha == null || unaFecha.isEmpty()) {
            this.fechaNacimiento = "Fecha no ingresada";
        } else {
            this.fechaNacimiento = unaFecha;
        }
    }

    public ImageIcon getFotoDePerfil() {
        return this.fotoDePerfil;
    }

    public void setFotoDePerfil(ImageIcon unaFotoDePerfil) {
        if (unaFotoDePerfil == null) {
            this.fotoDePerfil = new ImageIcon(getClass().
                    getResource("/Imagenes/fotoDeUsuarioStandard.png"));
        } else {
            this.fotoDePerfil = unaFotoDePerfil;
        }
    }

    public String getNombreCompleto() {
        String retorno;
        if (getNombre().equals(NOMBRE_POR_DEFECTO) && getApellido().
                equals(APELLIDO_POR_DEFECTO)) {
            retorno = NOMBRE_POR_DEFECTO;
        } else if (getNombre().equals(NOMBRE_POR_DEFECTO)) {
            retorno = getApellido();
        } else if (getApellido().equals(APELLIDO_POR_DEFECTO)) {
            retorno = getNombre();
        } else {
            retorno = getNombre() + " " + getApellido();
        }
        return retorno;
    }

    @Override
    public String toString() {
        return this.getNombreCompleto();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Persona otraPersona = (Persona) obj;
        return this.getNombreCompleto().equals(otraPersona.getNombreCompleto());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.apellido);
        hash = 29 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 29 * hash + Objects.hashCode(this.fotoDePerfil);
        return hash;
    }
}

package dominio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public final class Sistema implements Serializable {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Profesional> listaProfesionales;
    private ArrayList<Alimento> listaAlimentos;
    private ArrayList<PlanAlimentacion> listaPlanesAlimentacion;
    private ArrayList<Conversacion> listaConversaciones;
    private Persona personaLogueada;

    public Sistema(ArrayList<Usuario> unaListaUsuarios,
            ArrayList<Profesional> unaListaProfesionales,
            ArrayList<Alimento> unaListaAlimentos,
            ArrayList<PlanAlimentacion> unaListaPlanesAlimentacion,
            ArrayList<Conversacion> unaListaConversaciones,
            Persona personaLogueada) {

        setListaUsuarios(unaListaUsuarios);
        setListaProfesionales(unaListaProfesionales);
        setListaAlimentos(unaListaAlimentos);
        setListaConversaciones(unaListaConversaciones);
        setListaPlanesAlimentacion(unaListaPlanesAlimentacion);
        setPersonaLogueada(personaLogueada);
    }

    public Sistema() {
        setListaUsuarios(new ArrayList<>());
        setListaProfesionales(new ArrayList<>());
        setListaAlimentos(new ArrayList<>());
        setListaConversaciones(new ArrayList<>());
        setListaPlanesAlimentacion(new ArrayList<>());
        setPersonaLogueada(new Usuario("Nombre", "Apellido", "",
                new ImageIcon(getClass().
                        getResource("/Imagenes/fotoDeUsuarioStandard.png")),
                "", null, null, null));

    }

    public Persona getPersonaLogueada() {
        return personaLogueada;
    }

    public void setPersonaLogueada(Persona personaLogueada) {
        if (personaLogueada == null) {
            this.personaLogueada = new Usuario(null, null, null, null, null, null, null, null);
        } else {
            this.personaLogueada = personaLogueada;
        }

    }

    public ArrayList<Conversacion> getListaConversaciones() {
        return this.listaConversaciones;
    }

    public void setListaConversaciones(ArrayList<Conversacion> 
            unaListaConversaciones) {
        if (unaListaConversaciones == null) {
            this.listaConversaciones = new ArrayList<>();
        } else {
            this.listaConversaciones = unaListaConversaciones;
        }
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> unaListaUsuarios) {
        if (unaListaUsuarios == null) {
            this.listaUsuarios = new ArrayList<>();
        } else {
            this.listaUsuarios = unaListaUsuarios;
        }
    }

    public ArrayList<Profesional> getListaProfesionales() {
        return this.listaProfesionales;
    }

    public void setListaProfesionales(ArrayList<Profesional> unaListaProfesionales) {
        if (unaListaProfesionales == null) {
            this.listaProfesionales = new ArrayList<>();
        } else {
            this.listaProfesionales = unaListaProfesionales;
        }
    }

    public ArrayList<Alimento> getListaAlimentos() {
        return this.listaAlimentos;
    }

    public void setListaAlimentos(ArrayList<Alimento> unaListaAlimentos) {
        if (unaListaAlimentos == null) {
            this.listaAlimentos = new ArrayList<>();
        } else {
            this.listaAlimentos = unaListaAlimentos;
        }
    }

    public ArrayList<PlanAlimentacion> getListaPlanesAlimentacion() {
        return this.listaPlanesAlimentacion;
    }

    public void setListaPlanesAlimentacion(ArrayList<PlanAlimentacion> 
            unaListaPlanesAlimentacion) {
        if (unaListaPlanesAlimentacion == null) {
            this.listaPlanesAlimentacion = new ArrayList<>();
        } else {
            this.listaPlanesAlimentacion = unaListaPlanesAlimentacion;
        }
    }

    public enum Preferencias {
        CarnesRojas, CarnesBlancas, Verduras, Frutas, Harinas;
    }

    public enum Restricciones {
        Diabetes, Veganismo, IntoleranciaLactosa, Celiaquia;
    }

    public enum Paises {
        Argentina, Bolivia, Brasil, Chile, Colombia, CostaRica, Cuba, Ecuador, ElSalvador,
        GuayanaFrancesa, Granada, Guatemala, Guayana, Haiti, Honduras, Jamaica,
        Mexico, Nicaragua, Paraguay, Panama, Peru, PuertoRico, RepublicaDominicana, Surinam, Uruguay, Venezuela;
    }

    public enum DiasDeLaSemana {
        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo;
    }

    public enum IngestasPorDia {
        Desayuno, Almuerzo, Cena;
    }

    public ArrayList<String> devolverListaPaises() {
        ArrayList<String> listaDeNacionalidades = new ArrayList<>();
        for (Paises pais : Paises.values()) {
            listaDeNacionalidades.add(pais.toString());
        }
        return listaDeNacionalidades;
    }

    public ArrayList<String> devolverListaDiasDeLaSemana() {
        ArrayList<String> listaDiasDeLaSemana = new ArrayList<>();
        listaDiasDeLaSemana.add(DiasDeLaSemana.Lunes.toString());
        listaDiasDeLaSemana.add(DiasDeLaSemana.Martes.toString());
        listaDiasDeLaSemana.add(DiasDeLaSemana.Miercoles.toString());
        listaDiasDeLaSemana.add(DiasDeLaSemana.Jueves.toString());
        listaDiasDeLaSemana.add(DiasDeLaSemana.Viernes.toString());
        listaDiasDeLaSemana.add(DiasDeLaSemana.Sabado.toString());
        listaDiasDeLaSemana.add(DiasDeLaSemana.Domingo.toString());
        return listaDiasDeLaSemana;
    }

    public ArrayList<String> devolverListaIngestasDeLaSemana() {
        ArrayList<String> lstIngestas = new ArrayList<>();
        lstIngestas.add(IngestasPorDia.Desayuno.toString());
        lstIngestas.add(IngestasPorDia.Almuerzo.toString());
        lstIngestas.add(IngestasPorDia.Cena.toString());
        return lstIngestas;
    }

    //Metodo que serializa la informacion del sistema
    public void guardarDatosSistema() {
        try (FileOutputStream archivo = new FileOutputStream("Sistema.data");
                BufferedOutputStream buffer = new BufferedOutputStream(archivo);
                ObjectOutputStream objetoASerializar = new ObjectOutputStream(buffer)) {
            objetoASerializar.writeObject(this);
            objetoASerializar.flush();
        } catch (IOException e) {
            System.err.println("Error al guardar los datos");
        }
    }

    public boolean crearUsuario(String nombre, String apellido, String fechaNacimiento, ImageIcon fotoDePerfil, String nacionalidad, ArrayList<String> preferencias, ArrayList<String> restricciones, ArrayList<Ingesta> alimentosIngeridos) {
        Usuario usuarioNuevo = new Usuario(nombre, apellido, fechaNacimiento, fotoDePerfil, nacionalidad, preferencias, restricciones, alimentosIngeridos);
        return agregarUsuarioALaLista(usuarioNuevo);
    }

    //Metodo que agrega un usuario a lista de usuarios registrados
    public boolean agregarUsuarioALaLista(Usuario usuarioARegistrar) {
        boolean fueAgregadoUsuario = false;
        if (!getListaUsuarios().contains(usuarioARegistrar)) {
            getListaUsuarios().add(usuarioARegistrar);
            fueAgregadoUsuario = true;
        }
        return fueAgregadoUsuario;
    }

    public boolean crearProfesional(String nombre, String apellido, String fechaNacimiento, ImageIcon fotoPerfil, String tituloProfesional, String fechaGraduacion, String paisGraduacion) {
        Profesional profesionalNuevo = new Profesional(nombre, apellido, fechaNacimiento, fotoPerfil, tituloProfesional, fechaGraduacion, paisGraduacion);
        return agregarProfesionalALaLista(profesionalNuevo);
    }

    //Metodo que agrega un profesional a lista de usuarios registrados
    public boolean agregarProfesionalALaLista(Profesional profesionalARegistrar) {
        boolean fueAgregadoProfesional = false;
        if (!getListaProfesionales().contains(profesionalARegistrar)) {
            getListaProfesionales().add(profesionalARegistrar);
            fueAgregadoProfesional = true;
        }
        return fueAgregadoProfesional;
    }

    public boolean crearAlimento(String nombre, String tipoAlimento, ArrayList<ComposicionAlimento> listaNutrientesConProporcion, ImageIcon fotoDelAlimento) {
        Alimento alimentoNuevo = new Alimento(nombre, tipoAlimento, listaNutrientesConProporcion, fotoDelAlimento);
        return agregarAlimentoALaLista(alimentoNuevo);
    }

    
    //Metodo que agrega un alimento a lista de alimentos registrados
    public boolean agregarAlimentoALaLista(Alimento alimentoAAgregar) {
        boolean fueAgregadoAlimento = false;
        if (!getListaAlimentos().contains(alimentoAAgregar)) {
            getListaAlimentos().add(alimentoAAgregar);
            fueAgregadoAlimento = true;
        }
        return fueAgregadoAlimento;
    }

    /*Metodo que dado un mensaje, profesional, e usuario inicia una conversacion
    entre ellos */
    public boolean crearConversacion(Persona usuario, Persona profesional, String mensaje, boolean usuarioEsRemitente) {
        boolean fueAgregadaConversacion = false;
        InformacionMensaje info;
        if (usuario != null && profesional != null) {
            if (usuarioEsRemitente) {
                info = new InformacionMensaje(usuario.getNombreCompleto(), profesional.getNombreCompleto(), mensaje);
            } else {
                info = new InformacionMensaje(profesional.getNombreCompleto(), usuario.getNombreCompleto(), mensaje);
            }
            if (listaUsuarios.contains((Usuario) usuario) && listaProfesionales.contains((Profesional) profesional)) {
                ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
                listaMensajes.add(info);
                Conversacion nuevaConversacion = new Conversacion(usuario, profesional, listaMensajes);
                fueAgregadaConversacion = agregarConversacionALaLista(nuevaConversacion);
            }
        }
        return fueAgregadaConversacion;
    }

    private boolean agregarConversacionALaLista(Conversacion nuevaConversacion) {
        boolean fueAgregadaConversacion = false;
        if (!getListaConversaciones().contains(nuevaConversacion)) {
            getListaConversaciones().add(nuevaConversacion);
            fueAgregadaConversacion = true;
        }
        return fueAgregadaConversacion;
    }

    /*Metodo que devuelve una lista con los profesionales que el usuario
    ha tenido conversacion*/
    public String[] getListaNombresProfesionalesConversaciones(String nombreUsuarioConversacion) {
        String[] nombresProfesionales = new String[getListaConversaciones().size()];
        ArrayList<String> nombresIngresados = new ArrayList<>();
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            String nombreCompleto = getListaConversaciones().get(i).getProfesional().getNombreCompleto();
            String nombreUsuarioCompleto = getListaConversaciones().get(i).getUsuario().getNombreCompleto();
            if (!nombresIngresados.contains(nombreCompleto) && nombreUsuarioCompleto.equals(nombreUsuarioConversacion)) {
                nombresProfesionales[i] = nombreCompleto;
                nombresIngresados.add(nombreCompleto);
            }
        }
        return nombresProfesionales;
    }

    /*Dado un profesional, retorna una lista con los usuarios que le han
    mandado consultas al profesional, y este no le ha responido*/
    public String[] getListaNombresUsuariosConversacionesPendientes(String profesional) {
        ArrayList<String> nombresIngresados = new ArrayList<>();
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            String nombreCompleto = getListaConversaciones().get(i).getUsuario().getNombreCompleto();
            String nombreProfesional = getListaConversaciones().get(i).getProfesional().getNombreCompleto();
            if (!nombresIngresados.contains(nombreCompleto) && profesional.equals(nombreProfesional)
                    && !getListaConversaciones().get(i).getFueAtendidaConsulta()) {
                nombresIngresados.add(nombreCompleto);
            }
        }
        String[] nombreUsuarios = new String[nombresIngresados.size()];
        for (int i = 0; i < nombreUsuarios.length; i++) {
            nombreUsuarios[i] = nombresIngresados.get(i);
        }
        return nombreUsuarios;
    }

    /*Metodo que dado un nombre de un profesional y un usuario, obtiene
    el texto de la conversacion entre ellos*/
    public String getConversacion(String nombreCompletoProfesional, String nombreCompletoUsuario) {
        String retorno = "No hay conversación disponible.";
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            Conversacion conversacionActual = getListaConversaciones().get(i);
            String nombreCompletoProfesionalActual = conversacionActual.getProfesional().getNombreCompleto();
            String nombreUsuarioActual = conversacionActual.getUsuario().getNombreCompleto();
            if (nombreCompletoProfesionalActual.equals(nombreCompletoProfesional) && nombreUsuarioActual.equals(nombreCompletoUsuario)) {
                return conversacionActual.toString();
            }
        }
        return retorno;
    }

    /*Metodo que dado un mensaje un remitente y un destinatario, agrega
    el mensaje a la conversacion existente entre ese remitente y ese destinatario*/
    public boolean agregarMensajeConversacion(String remitente, String destinatario, String mensaje, boolean intercambioRemitente, boolean consultaRespondida) {
        boolean pudeAgregarMensaje = false;
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            Conversacion conversacionActual = getListaConversaciones().get(i);
            String nombreApellidoProfesional = conversacionActual.getProfesional().getNombreCompleto();
            String nombreApellidoUsuario = conversacionActual.getUsuario().getNombreCompleto();
            if (destinatario.equals(nombreApellidoProfesional) && remitente.equals(nombreApellidoUsuario)
                    || destinatario.equals(nombreApellidoUsuario) && remitente.equals(nombreApellidoProfesional)) {
                conversacionActual.agregarMensaje(mensaje, intercambioRemitente);
                conversacionActual.setFueAtendidaConsulta(consultaRespondida);
                pudeAgregarMensaje = true;
            }
        }
        return pudeAgregarMensaje;
    }

    public ArrayList getNombresProfesionalesSinConversacionConUsuario(Persona personaLogueada) {
        ArrayList retorno = copiarLista(getListaProfesionales());
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            Profesional profActual = (Profesional) getListaConversaciones().get(i).getProfesional();
            Persona usuarioActual = getListaConversaciones().get(i).getUsuario();
            if (usuarioActual.equals(personaLogueada)) {
                retorno.remove(profActual);
            }
        }
        return retorno;
    }

    private ArrayList copiarLista(ArrayList lista) {
        ArrayList nueva = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            nueva.add(lista.get(i));
        }
        return nueva;
    }

    public boolean agregarIngestaAUsuario(ArrayList<Ingesta> listaIngestasDelUsuario, String fechaIngesta, String nuevoAlimento) {
        boolean ingestaAgregada = false;
        if (listaIngestasDelUsuario != null && fechaIngesta != null) {
            if (yaExisteIngestaEnEsaFecha(listaIngestasDelUsuario, fechaIngesta)) {
                for (int i = 0; i < listaIngestasDelUsuario.size(); i++) {
                    if (listaIngestasDelUsuario.get(i).getFechaDeIngesta().equals(fechaIngesta)) {
                        ArrayList<Alimento> listaAlimentosActual = listaIngestasDelUsuario.get(i).getListaAlimentosPorFecha();
                        Alimento alimentoAAgregar = devolverAlimentoDadoNombre(nuevoAlimento);
                        listaAlimentosActual.add(alimentoAAgregar);
                    }
                }
            } else {
                Alimento alimentoAAgregar = devolverAlimentoDadoNombre(nuevoAlimento);
                ArrayList<Alimento> nuevaLista = new ArrayList<>();
                nuevaLista.add(alimentoAAgregar);
                Ingesta nuevaIngesta = new Ingesta(fechaIngesta, nuevaLista);
                listaIngestasDelUsuario.add(nuevaIngesta);
            }
            ingestaAgregada = true;
        }
        return ingestaAgregada;
    }

    private boolean yaExisteIngestaEnEsaFecha(ArrayList<Ingesta> listaIngestasDelUsuario, String fechaIngesta) {
        boolean existe = false;
        if (listaIngestasDelUsuario != null) {
            for (int i = 0; i < listaIngestasDelUsuario.size(); i++) {
                if (listaIngestasDelUsuario.get(i).getFechaDeIngesta().equals(fechaIngesta)) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public Alimento devolverAlimentoDadoNombre(String nuevoAlimento) {
        Alimento alimentoRetorno = new Alimento(null, null, null, null);
        for (int i = 0; i < this.listaAlimentos.size(); i++) {
            String alimentoActual = this.listaAlimentos.get(i).getNombre();
            if (alimentoActual.equals(nuevoAlimento)) {
                alimentoRetorno = this.listaAlimentos.get(i);
            }
        }
        return alimentoRetorno;
    }

    public Usuario getUsuarioPorNombre(String nombreCompleto) {
        Usuario usuarioRetorno = new Usuario(null, null, null, null, null, null, null, null);
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            String nombreActual = this.listaUsuarios.get(i).getNombreCompleto();
            if (nombreActual.equals(nombreCompleto)) {
                usuarioRetorno = this.listaUsuarios.get(i);
            }
        }
        return usuarioRetorno;
    }

    public Profesional getProfesionalPorNombre(String nombreCompleto) {
        Profesional profesionalRetorno = new Profesional(null, null, null, null, null, null, null);
        for (int i = 0; i < this.listaProfesionales.size(); i++) {
            String nombreActual = this.listaProfesionales.get(i).getNombreCompleto();
            if (nombreActual.equals(nombreCompleto)) {
                profesionalRetorno = this.listaProfesionales.get(i);
            }
        }
        return profesionalRetorno;
    }

    public boolean agregarPlanSolicitado(Usuario usuario, Profesional profesional) {
        boolean agreguePlan = false;
        PlanAlimentacion planNuevo = new PlanAlimentacion("", usuario, profesional, false, (String[][]) null);
        if (!getListaPlanesAlimentacion().contains(planNuevo)) {
            this.getListaPlanesAlimentacion().add(planNuevo);
            agreguePlan = true;
        }
        return agreguePlan;
    }

    public boolean atenderSolicitudDelPlan(String[][] planAlimentacion,
            Profesional profesional,
            Usuario usuario,
            String nombrePlan) {
        boolean fueAtendido = false;
        for (int i = 0; i < this.listaPlanesAlimentacion.size(); i++) {
            PlanAlimentacion actual = this.listaPlanesAlimentacion.get(i);
            if (actual.getProfesional().equals(profesional) && actual.getUsuario().equals(usuario)
                    && !actual.getFueAtendidoElPlan()) {
                actual.setNombreDelPlan(nombrePlan);
                actual.setPlanDiaADia(planAlimentacion);
                actual.setFueAtendidoElPlan(true);
                fueAtendido = true;
            }
        }
        return fueAtendido;
    }

    public String[] planesAtendidosDelUsuario(Usuario usuario) {
        ArrayList<String> listaAuxiliar = new ArrayList<>();
        for (PlanAlimentacion plan : this.listaPlanesAlimentacion) {
            if (plan.getUsuario().equals(usuario) && plan.getFueAtendidoElPlan()) {
                listaAuxiliar.add(plan.getNombreDelPlan());
            }
        }
        return obtenerUsuariosDePlanes(listaAuxiliar);
    }

    public PlanAlimentacion devolverPlanDadoNombre(String nombreDelPlan) {
        PlanAlimentacion planRetorno = new PlanAlimentacion(null, null, null, false, null);
        for (PlanAlimentacion plan : this.listaPlanesAlimentacion) {
            if (plan.getNombreDelPlan().equals(nombreDelPlan)) {
                planRetorno = plan;
            }
        }
        return planRetorno;
    }

    private String[] obtenerUsuariosDePlanes(ArrayList<String> listaDePlanes) {
        String[] nombreUsuarios = new String[listaDePlanes.size()];
        for (int i = 0; i < nombreUsuarios.length; i++) {
            nombreUsuarios[i] = listaDePlanes.get(i);
        }
        return nombreUsuarios;
    }

    public ArrayList<Profesional> profesionalesDelMismoPais(Profesional unProfesional) {
        ArrayList<Profesional> listaRetorno = new ArrayList<>();
        for (Profesional profesional : this.listaProfesionales) {
            if (!profesional.equals(unProfesional) && profesional.getPaisGraduacion().equals(unProfesional.getPaisGraduacion())) {
                listaRetorno.add(profesional);
            }
        }
        return listaRetorno;
    }

    public ArrayList<Profesional> profesionalesConElMismoTitulo(Profesional unProfesional) {
        ArrayList<Profesional> listaRetorno = new ArrayList<>();
        for (Profesional profesional : this.listaProfesionales) {
            if (!profesional.equals(unProfesional) && profesional.getTituloProfesional().equals(unProfesional.getTituloProfesional())) {
                listaRetorno.add(profesional);
            }
        }
        return listaRetorno;
    }

    public ArrayList<Profesional> profesionalesMismoAnioGraduacion(Profesional unProfesional) {
        ArrayList<Profesional> listaRetorno = new ArrayList<>();
        String[] fechaNacimiento = unProfesional.getFechaGraduacion().split("/");
        String anioNacimiento = fechaNacimiento[2];
        for (Profesional profesional : this.listaProfesionales) {
            String[] fechaNacimientoActual = profesional.getFechaGraduacion().split("/");
            String anioNacimientoActual = fechaNacimientoActual[2];
            if (!profesional.equals(unProfesional) && anioNacimiento.equals(anioNacimientoActual)) {
                listaRetorno.add(profesional);
            }
        }
        return listaRetorno;
    }

    public String[] getListaUsuariosConPlanesPendientes(Profesional profesional) {
        ArrayList<String> planesPendientes = new ArrayList<>();
        for (PlanAlimentacion plan : this.listaPlanesAlimentacion) {
            if (plan.getProfesional().equals(profesional) && !plan.getFueAtendidoElPlan()) {
                String nombreUsuario = plan.getUsuario().getNombreCompleto();
                planesPendientes.add(nombreUsuario);
            }
        }
        String[] resultadoPlanesPendientes = obtenerUsuariosDePlanes(planesPendientes);
        return resultadoPlanesPendientes;
    }

    public Persona profesionalMasContactado() {
        Persona profesionalRetorno = new Profesional("", "", "", null, "", "", "");
        ArrayList<Persona> listaAuxiliar = new ArrayList<>();
        for (Conversacion conver : this.listaConversaciones) {
            listaAuxiliar.add(conver.getProfesional());

        }
        int cont = 0;
        int max = -1;
        for (Persona prof : listaAuxiliar) {
            cont = 0;
            for (Persona profAComparar : listaAuxiliar) {
                if (prof.equals(profAComparar)) {
                    cont++;
                }
            }
            if (cont > max) {
                max = cont;
                profesionalRetorno = prof;
            }
        }
        return profesionalRetorno;
    }
}

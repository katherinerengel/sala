import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sala {
    //Listas para alamacenar los registros ya que no es necesario la persistencia de la información.
    //VOID PORQUE NO DEVUELVE NINGUN VALOR, SOLO HACE UNA ACCIONES ***** NO OLVIDAR *****

    ArrayList<Grupo> grupos = new ArrayList<>();
    ArrayList<Concierto> conciertos = new ArrayList<>();

    //Alta Grupo
    public void AltaGrupo(String nombre, String tipoMusica){
        Grupo nuevoGrupo = new Grupo(nombre, tipoMusica);
        grupos.add(nuevoGrupo);
        System.out.println("Grupo creado con éxito.");
    }

    //Buscar Grupo
    public Grupo BuscarGrupo(String nombre){
        Grupo grupoBuscado = new Grupo();
        for (Grupo unGrupo : grupos) {
            if(unGrupo.getNombre().equals(nombre)){
                grupoBuscado = unGrupo;
            }
        }
        return grupoBuscado;
    }

    //Baja Grupo
    public void BajaGrupo(String nombre){
        Grupo grupoEncontrado = BuscarGrupo(nombre);
        grupos.remove(grupoEncontrado);
        System.out.println("Grupo eliminado con éxito.");
    }

    //Alta Concierto - Ingresamos los datos de tipo String y luego se convierten
    public void AltaConcierto(String fecha, String horaInicio, String horaFin){
        // DateTimeFormatter para formatear y parsear objetos de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //ofPattern para crear el DateTimeFormatter con el patrón especificado
        LocalDate fechaConvertida = LocalDate.parse(fecha, formatter);

        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicioConv = LocalTime.parse(horaInicio, formatterHora);
        LocalTime horaFinConv = LocalTime.parse(horaFin, formatterHora);

        Concierto nuevoConcierto = new Concierto(fechaConvertida, horaInicioConv, horaFinConv);
        conciertos.add(nuevoConcierto);
        System.out.println("Concierto registrado con éxito.");
    } 

    //Buscar Concierto
    public Concierto BuscarConcierto(LocalDate fecha){
        Concierto conciertoBuscado = new Concierto();
        for (Concierto unConcierto : conciertos) {
           if (unConcierto.getFecha().equals(fecha)) {
                conciertoBuscado = unConcierto;
           } 
        }
        return conciertoBuscado;
    }

    //Baja Concierto
    public void BajaConcierto(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //ofPattern para crear el DateTimeFormatter con el patrón especificado
        LocalDate fechaConvertida = LocalDate.parse(fecha, formatter);
        Concierto conciertoEncontrado = BuscarConcierto(fechaConvertida);
        conciertos.remove(conciertoEncontrado);
        System.out.println("Concierto eliminado con éxito.");
    }

    //Asignar Concierto
    public void AsignarConcierto(String nombre, String fecha){
        Grupo grupoEncontrado = BuscarGrupo(nombre);
        if (grupoEncontrado == null) {
            System.out.println("El grupo no existe"); //Si no encuentra se sale y no busca más.
            return;
        }
        //Si lo encuentra viene acá a buscar el concierto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //ofPattern para crear el DateTimeFormatter con el patrón especificado
        LocalDate fechaConvertida = LocalDate.parse(fecha, formatter);
        Concierto conciertoEncontrado = BuscarConcierto(fechaConvertida);
        if (conciertoEncontrado != null) { //Si lo encuentra le asigna un concierto
            grupoEncontrado.AgregarConcierto(conciertoEncontrado);
            System.out.println("El concierto fue asignado con éxito.");
        } else {
            System.out.println("El concierto no existe."); //Si no encuentra se sale y no busca más.
            return;
        }
    }

    //Listado de conciertos por día
    public void ListarConcierto(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //ofPattern para crear el DateTimeFormatter con el patrón especificado
        LocalDate fechaConvertida = LocalDate.parse(fecha, formatter);
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

        ArrayList<Concierto> listaConciertos = new ArrayList<>();
        for (Concierto unConcierto : conciertos) {
            if(unConcierto.getFecha().equals(fechaConvertida)){
                listaConciertos.add(unConcierto);
            }
        }

        if (listaConciertos.size() > 0) {
            for (Concierto unConcierto : listaConciertos) {
                System.out.println("Fecha: " + unConcierto.getFecha().format(formatter));
                System.out.println("Hora inicio: " + unConcierto.getHoraInicio().format(formatterHora));
                System.out.println("Hora fin: " + unConcierto.getHoraFin().format(formatterHora));
                System.out.println("***************************");
            }
        } else {
            System.out.println("No se encontraron conciertos para esa fecha.");
        }
    }

    //Lista Descendente de Grupos por número de conciertos
    public void ListarGrupos(){
        ArrayList<Grupo> listaGrupos = new ArrayList<>(grupos);
        Collections.sort(listaGrupos, Comparator.comparingInt((Grupo g) -> g.getConciertos().size()).reversed());

        for (Grupo unGrupo : listaGrupos) {
            System.out.println("Nombre: " + unGrupo.getNombre());
            System.out.println("Tipo de música: " + unGrupo.getTipoMusica());
            System.out.println("Número de conciertos: " + unGrupo.getConciertos().size());
            System.out.println("***************************");
        }
    }
}

import java.util.ArrayList;

public class Grupo {
    //Atributos de la clase
    private String nombre;
    private String tipoMusica;

    //Relación de composición entre Grupo y Concierto
    private ArrayList<Concierto> listaConcierto; 

    // Constructor de la clase
    public Grupo(String nombre, String tipoMusica) {
        this.nombre = nombre;
        this.tipoMusica = tipoMusica;
        this.listaConcierto = new ArrayList<>();
    }

    // Constructor para inicializar la variable en Buscar Grupo
    public Grupo(){}

    //Métodos getter y setter para cada atributo de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }  

    public ArrayList<Concierto> getConciertos(){
        return listaConcierto;
    }

    //Métodos para agregar y eliminar concierto al grupo
    public void AgregarConcierto(Concierto nuevoConcierto){
        this.listaConcierto.add(nuevoConcierto);
    }

    public void RemoverConcierto(Concierto eliminarConcierto){
        this.listaConcierto.remove(eliminarConcierto);
    }
}
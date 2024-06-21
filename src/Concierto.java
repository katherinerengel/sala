import java.time.LocalDate;
import java.time.LocalTime;

public class Concierto {
    //Atributos de la clase
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    //Constructor de la clase
    public Concierto(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Constructor para inicializar la variable en Buscar Concierto
    public Concierto(){}

    //Métodos getter y setter para cada atributo de la clase
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}

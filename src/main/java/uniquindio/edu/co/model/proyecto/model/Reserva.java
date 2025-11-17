package uniquindio.edu.co.model.proyecto.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {


    private String id;
    private ClaseDeportes clase;
    private Usuario usuario;
    private LocalDate fecha;

    /**
     *
     * @param id
     * @param clase
     * @param usuario
     * @param fecha
     */
    public Reserva(String id, ClaseDeportes clase, Usuario usuario, LocalDate fecha) {
        this.id = id;
        this.clase = clase;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", clase=" + clase +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClaseDeportes getClase() {
        return clase;
    }

    public void setClase(ClaseDeportes clase) {
        this.clase = clase;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

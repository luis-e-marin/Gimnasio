package uniquindio.edu.co.model.proyecto.model;

import java.time.LocalDate;

public abstract class Membresia {


    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precio;
    private TipoMembresia tipoMembresia;
    private boolean activa;

    /**
     *
     * @param fechaInicio
     * @param fechaFin
     * @param precio
     * @param tipoMembresia
     */
    public Membresia(LocalDate fechaInicio, LocalDate fechaFin, double precio, TipoMembresia tipoMembresia) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.tipoMembresia = tipoMembresia;
        this.activa = true;
    }

    public boolean isActiva() {
        return LocalDate.now().isBefore(fechaFin) && activa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}

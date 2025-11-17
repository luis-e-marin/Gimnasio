package uniquindio.edu.co.model.proyecto.model;

import java.time.LocalDate;

public class Estudiante extends Usuario {
    private String programa;
    private double descuento = 0.10;

    /**
     *
     * @param id
     * @param nombre
     * @param edad
     * @param telefono
     * @param programa
     */
    public Estudiante(String id, String nombre, int edad, String telefono, String programa) {
        super(id, nombre, edad, telefono,programa);
        this.programa = programa;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "programa='" + programa + '\'' +
                ", descuento=" + descuento +
                '}';
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String getExtra() {
        return "";
    }
}

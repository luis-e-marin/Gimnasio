package uniquindio.edu.co.model.proyecto.model;

import uniquindio.edu.co.model.proyecto.model.Membresia;
import uniquindio.edu.co.model.proyecto.model.TipoMembresia;

import java.time.LocalDate;

public class Basica extends Membresia {

    public Basica(LocalDate fechaInicio, TipoMembresia tipoMembresia) {
        super(fechaInicio, calcularFechaFin(fechaInicio, tipoMembresia), calcularPrecio(tipoMembresia), tipoMembresia);
    }

    private static double calcularPrecio(TipoMembresia tipoMembresia) {
        switch(tipoMembresia) {
            case MENSUAL: return 25000;
            case TRIMESTRAL: return 70000;
            case ANUAL: return 280000;
            default: return 0;
        }
    }

    private static LocalDate calcularFechaFin(LocalDate inicio, TipoMembresia tipoMembresia) {
        switch(tipoMembresia) {
            case MENSUAL: return inicio.plusMonths(1);
            case TRIMESTRAL: return inicio.plusMonths(3);
            case ANUAL: return inicio.plusYears(1);
            default: return inicio;
        }
    }
}

package uniquindio.edu.co.model.proyecto.model;

import java.time.LocalDate;

public class VIP extends Membresia {

    public VIP(LocalDate fechaInicio, TipoMembresia tipoMembresia) {
        super(fechaInicio, calcularFechaFin(fechaInicio, tipoMembresia), calcularPrecio(tipoMembresia), tipoMembresia);
    }

    private static double calcularPrecio(TipoMembresia tipoMembresia) {
        switch (tipoMembresia) {
            case MENSUAL: return 60000;
            case TRIMESTRAL: return 170000;
            case ANUAL: return 700000;
            default: return 0;
        }
    }

    private static LocalDate calcularFechaFin(LocalDate inicio, TipoMembresia tipoMembresia) {
        switch (tipoMembresia) {
            case MENSUAL: return inicio.plusMonths(1);
            case TRIMESTRAL: return inicio.plusMonths(3);
            case ANUAL: return inicio.plusYears(1);
            default: return inicio;
        }
    }
}

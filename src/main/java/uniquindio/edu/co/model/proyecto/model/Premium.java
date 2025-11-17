package uniquindio.edu.co.model.proyecto.model;

import java.time.LocalDate;

public class Premium extends Membresia {

    public Premium(LocalDate fechaInicio, TipoMembresia tipoMembresia) {
        super(fechaInicio, calcularFechaFin(fechaInicio, tipoMembresia), calcularPrecio(tipoMembresia), tipoMembresia);
    }

    private static double calcularPrecio(TipoMembresia tipoMembresia) {
        switch (tipoMembresia) {
            case MENSUAL: return 40000;
            case TRIMESTRAL: return 110000;
            case ANUAL: return 450000;
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

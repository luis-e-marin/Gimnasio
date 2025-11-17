package uniquindio.edu.co.model.proyecto.exception;

public class ClaseNoEncontradaException extends Exception {
    /**
     *
     * @param nombreClase
     */
    public ClaseNoEncontradaException(String nombreClase) {
        super("La clase '" + nombreClase + "' no fue encontrada.");
    }
}

package uniquindio.edu.co.model.proyecto.exception;

public class MembresiaVencidaException extends Exception {
    /**
     *
     * @param id
     */
    public MembresiaVencidaException(String id) {
        super("Membresía vencida para usuario: " + id);
    }
}

package uniquindio.edu.co.model.proyecto.exception;

public class MembresiaVencidaException extends Exception {
    public MembresiaVencidaException(String id) { super("Membresía vencida para usuario: " + id); }
}

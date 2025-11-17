package uniquindio.edu.co.model.proyecto.exception;

public class UsuarioNoEncontradoException extends Exception {
    /**
     *
     * @param id
     */
    public UsuarioNoEncontradoException(String id) {
        super("No se encontró un usuario con el ID: " + id);
    }
}

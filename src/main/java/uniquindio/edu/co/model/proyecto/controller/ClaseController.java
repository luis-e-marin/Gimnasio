package uniquindio.edu.co.model.proyecto.controller;

import uniquindio.edu.co.model.proyecto.model.ClaseDeportes;
import uniquindio.edu.co.model.proyecto.model.Gym;

import java.time.LocalDateTime;
import java.util.List;

public class ClaseController {

    private Gym gym;

    public ClaseController(Gym gym) {
        this.gym = gym;
    }

    // Registrar una clase
    public boolean registrarClase(String nombre, String tipoEjercicio, LocalDateTime horario, int cupoMaximo) {
        ClaseDeportes clase = new ClaseDeportes(nombre, tipoEjercicio, horario, cupoMaximo);
        return gym.agregarClase(clase);
    }

    // Buscar clase por nombre
    public ClaseDeportes buscarClase(String nombre) {
        return gym.buscarClase(nombre);
    }

    // Modificar clase
    public boolean modificarClase(String nombreOriginal, String nuevoNombre, String nuevoTipo, LocalDateTime nuevoHorario, int nuevoCupo) {
        ClaseDeportes clase = gym.buscarClase(nombreOriginal);
        if (clase == null) return false;

        clase.setNombre(nuevoNombre);
        clase.setTipoEjercicio(nuevoTipo);
        clase.setHorario(nuevoHorario);
        clase.setCupoMaximo(nuevoCupo);

        return true;
    }

    // Eliminar clase
    public boolean eliminarClase(String nombre) {
        ClaseDeportes clase = gym.buscarClase(nombre);
        if (clase == null) return false;
        return gym.getClases().remove(clase);
    }

    // Listar todas las clases
    public List<ClaseDeportes> listarClases() {
        return gym.getClases();
    }

    // Getter y setter del gym
    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}

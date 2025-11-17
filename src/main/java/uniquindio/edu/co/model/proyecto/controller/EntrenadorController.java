package uniquindio.edu.co.model.proyecto.controller;

import uniquindio.edu.co.model.proyecto.model.Entrenador;
import uniquindio.edu.co.model.proyecto.model.Gym;

import java.util.List;

public class EntrenadorController {
    private Gym gym;

    public EntrenadorController(Gym gym) {
        this.gym = gym;
    }

    public boolean registrarEntrenador(Entrenador entrenador) {
        return gym.agregarEntrenador(entrenador);
    }

    public boolean eliminarEntrenador(String id) {
        return gym.eliminarEntrenador(id);
    }

    public Entrenador buscarEntrenador(String id) {
        return gym.buscarEntrenador(id);
    }

    public List<Entrenador> listarEntrenadores() {
        return gym.getEntrenadores();
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}

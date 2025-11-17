package uniquindio.edu.co.model.proyecto.controller;

import uniquindio.edu.co.model.proyecto.exception.*;
import uniquindio.edu.co.model.proyecto.model.*;

public class GymController {
    private Gym gym;

    public GymController(Gym gym) { this.gym = gym; }

    public void registrarUsuario(Usuario u) { gym.agregarUsuario(u); }
    public Usuario buscarUsuario(String id) throws Exception {
        Usuario u = gym.buscarUsuario(id);
        if (u == null) throw new Exception("Usuario no encontrado");
        return u;
    }
    public void eliminarUsuario(String id) throws Exception {
        if (!gym.eliminarUsuario(id)) throw new Exception("Usuario no encontrado");
    }

    public void registrarClase(ClaseDeportes c) { gym.agregarClase(c); }
    public ClaseDeportes buscarClase(String nombre) throws Exception {
        ClaseDeportes c = gym.buscarClase(nombre);
        if (c == null) throw new Exception("Clase no encontrada");
        return c;
    }

    public void registrarReserva(String idUsuario, String nombreClase) throws Exception {
        gym.registrarReserva(idUsuario, nombreClase);
    }

    public double calcularIngresos() {
        double total = 0;
        for (Usuario u : gym.getUsuarios()) {
            if (u.getMembresia() != null) total += u.getMembresia().getPrecio();
        }
        return total;
    }

    public ClaseDeportes claseMasPopular() {
        ClaseDeportes popular = null;
        int max = -1;
        for (ClaseDeportes c : gym.getClases()) {
            if (c.getUsuariosReservados().size() > max) {
                max = c.getUsuariosReservados().size();
                popular = c;
            }
        }
        return popular;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}

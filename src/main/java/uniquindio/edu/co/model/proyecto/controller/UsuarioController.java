package uniquindio.edu.co.model.proyecto.controller;

import uniquindio.edu.co.model.proyecto.model.*;
import uniquindio.edu.co.model.proyecto.model.Gym;

import java.time.LocalDate;

public class UsuarioController {
    private Gym gym;

    /**
     *
     * @param gym
     */
    public UsuarioController(Gym gym) {
        this.gym = gym;
    }

    public boolean registrarUsuario(Usuario usuario) {
        if (usuario == null) return false;
        return gym.agregarUsuario(usuario);
    }

    public boolean registrarUsuarioConPlan(String id, String nombre, int edad, String telefono, String plan, TipoMembresia tipo) {
        if (id == null || id.isEmpty()) return false;
        Usuario usuario = new Usuario(id, nombre, edad, telefono,"") {
            @Override
            public String getExtra() {
                return "";
            }
        };
        Membresia m = crearMembresia(plan, tipo);
        if (m != null) usuario.asignarMembresia(m);
        return gym.agregarUsuario(usuario);
    }

    private Membresia crearMembresia(String plan, TipoMembresia tipo) {
        if (plan == null || tipo == null) return null;
        String planes = plan.trim().toUpperCase();
        if (planes.equals("BASICA")) return new Basica(LocalDate.now(), tipo);
        else if (planes.equals("PREMIUM")) return new Premium(LocalDate.now(), tipo);
        else if (planes.equals("VIP")) return new VIP(LocalDate.now(), tipo);
        return null;
    }

    public boolean eliminarUsuario(String id) {
        return gym.eliminarUsuario(id);
    }
    public Usuario buscarUsuario(String id) {
        return gym.buscarUsuario(id);
    }
    public Gym getGym() {
        return gym;
    }
}

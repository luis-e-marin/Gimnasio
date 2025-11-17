package uniquindio.edu.co.model.proyecto.controller;

import uniquindio.edu.co.model.proyecto.model.Administrador;
import uniquindio.edu.co.model.proyecto.model.Gym;

import java.util.List;

public class AdministradorController {

    private Gym gym;

    public AdministradorController(Gym gym) {
        this.gym = gym;
    }

    // Registrar un administrador
    public boolean registrarAdministrador(Administrador admin) {
        if (admin == null) return false;

        // Verificar que no exista un administrador con el mismo ID
        if (gym.getUsuarios().stream().anyMatch(u -> u.getId().equals(admin.getId()))) {
            return false;
        }

        return gym.agregarUsuario(admin);
    }

    // Buscar administrador por ID
    public Administrador buscarAdministrador(String id) {
        return gym.getUsuarios().stream()
                .filter(u -> u instanceof Administrador && u.getId().equals(id))
                .map(u -> (Administrador) u)
                .findFirst()
                .orElse(null);
    }

    // Modificar administrador
    public boolean modificarAdministrador(String id, String nombre, int edad, String telefono, String rol) {
        Administrador admin = buscarAdministrador(id);
        if (admin == null) return false;

        admin.setNombre(nombre);
        admin.setEdad(edad);
        admin.setTelefono(telefono);
        admin.setRol(rol);

        return true;
    }

    // Eliminar administrador
    public boolean eliminarAdministrador(String id) {
        Administrador admin = buscarAdministrador(id);
        if (admin == null) return false;

        return gym.eliminarUsuario(admin.getId());
    }

    // Listar todos los administradores
    public List<Administrador> listarAdministradores() {
        return gym.getUsuarios().stream()
                .filter(u -> u instanceof Administrador)
                .map(u -> (Administrador) u)
                .toList();
    }

    // Getter / Setter del Gym
    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}

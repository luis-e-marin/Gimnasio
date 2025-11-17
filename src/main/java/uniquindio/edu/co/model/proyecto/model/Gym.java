package uniquindio.edu.co.model.proyecto.model;

import uniquindio.edu.co.model.proyecto.exception.CupoLlenoException;
import uniquindio.edu.co.model.proyecto.exception.ReservaInvalidaException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gym implements Serializable {
    private static final long serialVersionUID = 1L;


    private List<Usuario> usuarios;
    private List<Entrenador> entrenadores;
    private List<ClaseDeportes> clases;
    private List<Reserva> reservas;

    /**
     * Constructor
     */
    public Gym() {
        this.usuarios = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public boolean verificarUsuarioPorId(String id) {
        if (id == null) return false;
        for (Usuario u : usuarios) {
            if (id.equals(u.getId())) return true;
        }
        return false;
    }

    public boolean agregarUsuario(Usuario u) {
        if (u == null) return false;
        if (verificarUsuarioPorId(u.getId())) return false;
        usuarios.add(u);
        return true;
    }

    public Usuario buscarUsuario(String id) {
        if (id == null) return null;
        for (Usuario u : usuarios) {
            if (id.equals(u.getId())) return u;
        }
        return null;
    }

    public boolean eliminarUsuario(String id) {
        Usuario u = buscarUsuario(id);
        if (u == null) return false;
        usuarios.remove(u);
        return true;
    }


    public boolean verificarEntrenadorPorId(String id) {
        if (id == null) return false;
        for (Entrenador entrenador : entrenadores) {
            if (id.equals(entrenador.getId())) return true;
        }
        return false;
    }

    public boolean agregarEntrenador(Entrenador entrenador) {
        if (entrenador == null) return false;
        if (verificarUsuarioPorId(entrenador.getId())) return false;
        entrenadores.add(entrenador);
        return true;
    }


    public boolean eliminarEntrenador(String id) {
        for (int i = 0; i < entrenadores.size(); i++) {
            if (entrenadores.get(i).getId().equals(id)) {
                entrenadores.remove(i);
                return true;
            }
        }
        return false;
    }

    public Entrenador buscarEntrenador(String id) {
        for (Entrenador e : entrenadores) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public boolean agregarClase(ClaseDeportes c) {
        if (c == null) return false;
        for (ClaseDeportes ex : clases) {
            if (ex.getNombre().equalsIgnoreCase(c.getNombre())) return false;
        }
        clases.add(c);
        return true;
    }

    public ClaseDeportes buscarClase(String nombre) {
        for (ClaseDeportes c : clases) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }

    public void registrarReserva(String idUsuario, String nombreClase) throws ReservaInvalidaException, CupoLlenoException {
        Usuario u = buscarUsuario(idUsuario);
        if (u == null) throw new ReservaInvalidaException("Usuario no encontrado");
        ClaseDeportes c = buscarClase(nombreClase);
        if (c == null) throw new ReservaInvalidaException("Clase no encontrada");
        if (!c.hayCupoDisponible()) throw new CupoLlenoException(c.getNombre());

        String idReserva = "R-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        Reserva r = new Reserva(idReserva, c, u, LocalDate.now());
        reservas.add(r);
        c.agregarUsuario(u);
    }

    public double calcularIngresos() {
        double total = 0;
        for (Usuario u : usuarios) {
            if (u.getMembresia() != null)
                total += u.getMembresia().getPrecio();
        }
        return total;
    }

    public ClaseDeportes claseMasPopular() {
        ClaseDeportes popular = null;
        int max = -1;
        for (ClaseDeportes c : clases) {
            if (c.getUsuariosReservados().size() > max) {
                max = c.getUsuariosReservados().size();
                popular = c;
            }
        }
        return popular;
    }

    public void guardarDatos(String rutaArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(this);
        }
    }

    public static Gym cargarDatos(String rutaArchivo) throws IOException, ClassNotFoundException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return new Gym();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Gym) ois.readObject();
        }
    }

    public List<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }

    public List<Entrenador> getEntrenadores() { return entrenadores; }
    public void setEntrenadores(List<Entrenador> entrenadores) { this.entrenadores = entrenadores; }

    public List<ClaseDeportes> getClases() { return clases; }
    public void setClases(List<ClaseDeportes> clases) { this.clases = clases; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}

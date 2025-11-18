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
        for (Usuario usuario : usuarios) {
            if (id.equals(usuario.getId())) return true;
        }
        return false;
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (usuario == null) return false;
        if (verificarUsuarioPorId(usuario.getId())) return false;
        usuarios.add(usuario);
        return true;
    }

    public Usuario buscarUsuario(String id) {
        if (id == null) return null;
        for (Usuario usuario : usuarios) {
            if (id.equals(usuario.getId())) return usuario;
        }
        return null;
    }

    public boolean eliminarUsuario(String id) {
        Usuario usuario = buscarUsuario(id);
        if (usuario == null) return false;
        usuarios.remove(usuario);
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
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId().equals(id)) return entrenador;
        }
        return null;
    }

    public boolean agregarClase(ClaseDeportes claseDeportes) {
        if (claseDeportes == null) return false;
        for (ClaseDeportes claseDeporte : clases) {
            if (claseDeporte.getNombre().equalsIgnoreCase(claseDeportes.getNombre())) return false;
        }
        clases.add(claseDeportes);
        return true;
    }

    public ClaseDeportes buscarClase(String nombre) {
        for (ClaseDeportes claseDeportes : clases) {
            if (claseDeportes.getNombre().equalsIgnoreCase(nombre)) return claseDeportes;
        }
        return null;
    }

    public void registrarReserva(String idUsuario, String nombreClase) throws ReservaInvalidaException, CupoLlenoException {
        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) throw new ReservaInvalidaException("Usuario no encontrado");

        ClaseDeportes claseDeportes = buscarClase(nombreClase);

        if (claseDeportes == null) throw new ReservaInvalidaException("Clase no encontrada");

        if (!claseDeportes.hayCupoDisponible()) throw new CupoLlenoException(claseDeportes.getNombre());

        String idReserva = "R-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        Reserva reserva = new Reserva(idReserva, claseDeportes, usuario, LocalDate.now());
        reservas.add(reserva);
        claseDeportes.agregarUsuario(usuario);
    }

    public double calcularIngresos() {
        double total = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getMembresia() != null)
                total += usuario.getMembresia().getPrecio();
        }
        return total;
    }

    public ClaseDeportes claseMasPopular() {
        ClaseDeportes popular = null;
        int max = -1;
        for (ClaseDeportes claseDeportes : clases) {
            if (claseDeportes.getUsuariosReservados().size() > max) {
                max = claseDeportes.getUsuariosReservados().size();
                popular = claseDeportes;
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


    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }
    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public List<ClaseDeportes> getClases() {
        return clases;
    }
    public void setClases(List<ClaseDeportes> clases) {
        this.clases = clases;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}

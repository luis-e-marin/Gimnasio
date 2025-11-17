package uniquindio.edu.co.model.proyecto.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClaseDeportes {
    private String nombre;
    private String tipoEjercicio;
    private LocalDateTime horario;
    private int cupoMaximo;
    private List<Usuario> usuariosReservados = new ArrayList<>();
    private Entrenador entrenador;

    /**
     *
     * @param nombre
     * @param tipoEjercicio
     * @param horario
     * @param cupoMaximo
     */
    public ClaseDeportes(String nombre, String tipoEjercicio, LocalDateTime horario, int cupoMaximo) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.horario = horario;
        this.cupoMaximo = cupoMaximo;
    }

    public boolean hayCupoDisponible() {
        return usuariosReservados.size() < cupoMaximo;
    }

    public void agregarUsuario(Usuario u) {
        if (hayCupoDisponible()) usuariosReservados.add(u);
    }

    public void removerUsuario(Usuario u) {
        usuariosReservados.remove(u);
    }

    public String getNombre() {
        return nombre;
    }


    public void setUsuariosReservados(List<Usuario> usuariosReservados) {
        this.usuariosReservados = usuariosReservados;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public List<Usuario> getUsuariosReservados() {
        return usuariosReservados;
    }
}

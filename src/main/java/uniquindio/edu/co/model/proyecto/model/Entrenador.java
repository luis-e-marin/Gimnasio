package uniquindio.edu.co.model.proyecto.model;

import java.io.Serializable;

public class Entrenador implements Serializable {
    private String id;
    private String nombre;
    private String especialidad;
    private double salario;

    /**
     *
     * @param id
     * @param nombre
     * @param especialidad
     * @param salario
     */
    public Entrenador(String id, String nombre, String especialidad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", salario=" + salario +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


}

package uniquindio.edu.co.model.proyecto.model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

    private String id;
    private String nombre;
    private int edad;
    private String telefono;
    private Membresia membresia;
    private String Tipo;

    /**
     *
     * @param id
     * @param nombre
     * @param edad
     * @param telefono
     * @param Tipo
     */
    public Usuario(String id, String nombre, int edad, String telefono,String Tipo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.Tipo=Tipo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public abstract String getExtra();

    public Membresia setMembresia(Membresia membresia) {
        return membresia;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void asignarMembresia(Membresia m) {
        this.membresia = m;
    }

    public String setTipo(String tipo) {
        return Tipo;
    }

    public char[] getTipo() {
        return Tipo.toCharArray();
    }
}

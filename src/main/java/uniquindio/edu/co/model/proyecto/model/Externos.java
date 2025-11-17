package uniquindio.edu.co.model.proyecto.model;

public class Externos extends Usuario {
    private String ocupacion;

    public Externos(String id, String nombre, int edad, String telefono, String ocupacion) {
        super(id, nombre, edad, telefono, ocupacion);
        this.ocupacion = ocupacion;
    }

    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String getExtra() {
        return "";
    }
}

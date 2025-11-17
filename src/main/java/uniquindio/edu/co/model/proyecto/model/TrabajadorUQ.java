package uniquindio.edu.co.model.proyecto.model;

public class TrabajadorUQ extends Usuario {
    private String dependencia;
    private double descuento = 0.15;

    /**
     *
     * @param id
     * @param nombre
     * @param edad
     * @param telefono
     * @param dependencia
     */
    public TrabajadorUQ(String id, String nombre, int edad, String telefono, String dependencia) {
        super(id, nombre, edad, telefono,dependencia);
        this.dependencia = dependencia;
    }



    @Override
    public String toString() {
        return "TrabajadorUQ{" +
                "dependencia='" + dependencia + '\'' +
                ", descuento=" + descuento +
                '}';
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String getExtra() {
        return "";
    }
}

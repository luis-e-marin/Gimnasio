package uniquindio.edu.co.model.proyecto.model;

public class Administrador extends Usuario {

    private String rol; // Ejemplo: "Gerente", "Supervisor", "Coordinador"
    private double beneficio; // Por ejemplo, descuento en membresía o acceso especial

    /**
     *
     * @param idUsuario
     * @param nombre
     * @param edad
     * @param telefono
     * @param rol
     */
    public Administrador(String idUsuario, String nombre, int edad, String telefono, String rol) {
        super(idUsuario, nombre, edad, telefono,rol);
        this.rol = rol;
        this.beneficio = 0.20;
    }

    @Override
    public void asignarMembresia(Membresia membresia) {
        if (membresia != null) {
            double precioConBeneficio = membresia.getPrecio() * (1 - beneficio);
            membresia.setPrecio(precioConBeneficio);
        }
        super.asignarMembresia(membresia);
        System.out.println("Membresía asignada al administrador con beneficio del " + (beneficio * 100) + "%");
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + getNombre() + '\'' +
                ", rol='" + rol + '\'' +
                ", beneficio=" + beneficio +
                ", membresia=" + getMembresia() +
                '}';
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    public void setNombre(String nombre) {
    }

    public void setEdad(int edad) {
    }

    public void setTelefono(String telefono) {
    }

    @Override
    public String getExtra() {
        return "";
    }
}

package uniquindio.edu.co.model.proyecto.model;

public class Recepcionista extends Usuario {

    private String turno; // Ejemplo: "Mañana", "Tarde", "Noche"
    private double beneficio; // Por ejemplo, descuento o algún beneficio especial

    public Recepcionista(String idUsuario, String nombre, int edad, String telefono, String turno) {
        super(idUsuario, nombre, edad, telefono, turno);
        this.turno = turno;
        this.beneficio = 0.05; // ejemplo de beneficio del 5%
    }

    @Override
    public String getExtra() {
        return "";
    }

    @Override
    public void asignarMembresia(Membresia membresia) {
        if (membresia != null) {
            double precioConBeneficio = membresia.getPrecio() * (1 - beneficio);
            membresia.setPrecio(precioConBeneficio);
        }
        super.asignarMembresia(membresia);
        System.out.println("Membresía asignada a recepcionista con beneficio del " + (beneficio * 100) + "%");
    }

    // ==========================
    //        GETTERS / SETTERS
    // ==========================

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public String toString() {
        return "Recepcionista{" +
                "nombre='" + getNombre() + '\'' +
                ", turno='" + turno + '\'' +
                ", beneficio=" + beneficio +
                ", membresia=" + getMembresia() +
                '}';
    }
}

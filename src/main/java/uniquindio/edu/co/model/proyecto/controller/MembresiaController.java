package uniquindio.edu.co.model.proyecto.controller;

import uniquindio.edu.co.model.proyecto.model.Usuario;
import uniquindio.edu.co.model.proyecto.model.Membresia;

public class MembresiaController {

    public void asignarMembresia(Usuario usuario, Membresia membresia) {
        usuario.setMembresia(membresia);
    }
}

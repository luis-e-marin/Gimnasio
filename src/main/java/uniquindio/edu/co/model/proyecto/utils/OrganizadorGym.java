package uniquindio.edu.co.model.proyecto.utils;

import uniquindio.edu.co.model.proyecto.model.Gym;

public class OrganizadorGym {

    private static Gym gym;

    /**
     *
     * @return
     */
    public static Gym getGym() {
        if (gym == null) {
            gym = ArchivoGym.cargarGym();
        }
        return gym;
    }

    public static void setGym(Gym gym) {
        OrganizadorGym.gym = gym;
        ArchivoGym.guardarGym(OrganizadorGym.gym);
    }


    public static void guardar() {
        if (gym != null) {
            ArchivoGym.guardarGym(gym);
        }
    }
}

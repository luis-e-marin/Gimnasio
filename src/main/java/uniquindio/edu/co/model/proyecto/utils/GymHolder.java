package uniquindio.edu.co.model.proyecto.utils;

import uniquindio.edu.co.model.proyecto.model.Gym;

public class GymHolder {

    private static Gym gym;

    /**
     *
     * @return
     */
    public static Gym getGym() {
        if (gym == null) {
            gym = GymPersistence.cargarGym();
        }
        return gym;
    }

    public static void setGym(Gym g) {
        gym = g;
        GymPersistence.guardarGym(gym);
    }


    public static void guardar() {
        if (gym != null) {
            GymPersistence.guardarGym(gym);
        }
    }
}

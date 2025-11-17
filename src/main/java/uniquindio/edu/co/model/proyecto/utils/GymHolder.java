package uniquindio.edu.co.model.proyecto.utils;

import uniquindio.edu.co.model.proyecto.model.Gym;

public class GymHolder {

    private static Gym gym;

    public static Gym getGym() {
        if (gym == null) {
            gym = GymPersistence.cargarGym(); // Se carga desde el archivo
        }
        return gym;
    }

    public static void setGym(Gym g) {
        gym = g;
        GymPersistence.guardarGym(gym); // Se guarda automáticamente
    }

    // Método opcional para guardar manualmente
    public static void guardar() {
        if (gym != null) {
            GymPersistence.guardarGym(gym);
        }
    }
}

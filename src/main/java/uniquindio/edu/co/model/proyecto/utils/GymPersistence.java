package uniquindio.edu.co.model.proyecto.utils;

import uniquindio.edu.co.model.proyecto.model.Gym;

import java.io.*;

public class GymPersistence {

    private static final String FILE_PATH = "gym_data.dat";

    /**
     *
     * @param gym
     */
    public static void guardarGym(Gym gym) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(gym);
            System.out.println("Datos del gimnasio guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos del gimnasio: " + e.getMessage());
        }
    }

    public static Gym cargarGym() {
        File archivo = new File(FILE_PATH);
        if (!archivo.exists()) {
            return new Gym();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Gym) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos del gimnasio: " + e.getMessage());
            return new Gym();
        }
    }
}

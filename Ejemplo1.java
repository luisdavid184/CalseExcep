import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Ejemplo1 {

    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("Archivo no existe");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (Exception e) {
            System.out.println("Error desconocido" + e.getMessage());
        }

    }

}
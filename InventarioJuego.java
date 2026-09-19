public class InventarioJuego {

    private String[] inventario = new String[5]; // Arreglo con 5 espacios (indices 0 al 4)
    private boolean juegoActivo = true;

    // El metodo declara con throws las excepciones estandar que podria lanzar
    public void agregarItem(int posicion, String item, int cantidad) 
            throws IllegalStateException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {

        // Excepcion estandar
        if (!juegoActivo) {
            throw new IllegalStateException("El juego no esta activo en este momento.");
        }

        // Excepcion estandar
        if (item == null) {
            throw new NullPointerException("El nombre del item no puede ser nulo.");
        }

        // Excepcion estandar
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad enviada debe ser mayor a cero.");
        }

        // Excepcion estandar
        if (posicion < 0 || posicion >= inventario.length) {
            throw new IndexOutOfBoundsException("La posicion " + posicion + " no existe en el inventario.");
        }

        inventario[posicion] = item;
        System.out.println("Item " + item + " guardado con exito.");
    }

    public static void main(String[] args) {
        InventarioJuego juego = new InventarioJuego();

        try {
            // Modifica los valores para probar cada excepcion:
            // Ejemplo 1: enviar posicion 10 para probar IndexOutOfBoundsException
            // Ejemplo 2: enviar null para probar NullPointerException
            // Ejemplo 3: enviar cantidad -1 para probar IllegalArgumentException
            juego.agregarItem(10, "Pocion de Vida", 1);

        } catch (IllegalStateException e) {
            System.out.println("[ERROR ESTADO]: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("[ERROR OBJETO]: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR ARGUMENTO]: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[ERROR RANGO]: " + e.getMessage());
        } finally {
            System.out.println("Proceso de guardado finalizado.");
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// ECEPCIONES PERSONALIZADAS
class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class CalificacionInvalidaException extends Exception {
    public CalificacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// CLASE DE LÓGICA Y MÉTODOS
public class GestionExcepciones {

    // Ecepción Personalizada 1
    // Declara que puede lanzar StockInsuficienteException
    public static void realizarVenta(int stockActual, int cantidadComprar) throws StockInsuficienteException {
        if (cantidadComprar > stockActual) {
            // Lanza manualmente la excepción personalizada
            throw new StockInsuficienteException("Stock insuficiente: Quedan " + stockActual + " unidades y se pidieron " + cantidadComprar);
        }
        System.out.println("Venta procesada con éxito.");
    }

    // Excepción Personalizada 2 
    public static void registrarCalificacion(double nota) throws CalificacionInvalidaException {
        if (nota < 0.0 || nota > 10.0) {
            // Lanza manualmente la excepción personalizada
            throw new CalificacionInvalidaException("Calificación fuera de rango (0 - 10): " + nota);
        }
        System.out.println("Calificación " + nota + " registrada correctamente.");
    }

    // Excepción Estándar 1
    public static int calcularPromedioDirecto(int totalPuntos, int totalMaterias) {
        if (totalMaterias == 0) {
            // Lanza manualmente una excepción aritmética del sistema
            throw new ArithmeticException("No se puede dividir entre cero materías.");
        }
        return totalPuntos / totalMaterias;
    }

    // Excepción Estándar 2
    public static int convertirMatricula(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            // Re-lanzamos
            throw new NumberFormatException("El texto '" + texto + "' no es una matrícula numérica válida.");
        }
    }

    // Excepción Estándar 3
    public static void leerArchivoAlumnos(String ruta) throws FileNotFoundException {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo en la ruta '" + ruta + "' no fue encontrado.");
        }
        Scanner scanner = new Scanner(archivo);
        // Procesa archivo
    }

    // Excepción Estándar 4
    public static void imprimirNombreAlumno(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("El nombre del alumno no puede ser nulo.");
        }
        System.out.println("Alumno: " + nombre.toUpperCase());
    }

    
    // MÉTODO PRINCIPAL (PRUEBA DE CAPTURA)
    
    public static void main(String[] args) {

        System.out.println("--- 1. Pruebas de Excepciones Personalizadas ---");
        try {
            realizarVenta(5, 10);
        } catch (StockInsuficienteException e) {
            System.out.println("[CAPTURADA] " + e.getMessage());
        }

        try {
            registrarCalificacion(11.5);
        } catch (CalificacionInvalidaException e) {
            System.out.println("[CAPTURADA] " + e.getMessage());
        }

        System.out.println("\n--- 2. Pruebas de Excepciones Estandar ---");
        try {
            calcularPromedioDirecto(100, 0);
        } catch (ArithmeticException e) {
            System.out.println("[CAPTURADA] " + e.getMessage());
        }

        try {
            convertirMatricula("MAT-2026");
        } catch (NumberFormatException e) {
            System.out.println("[CAPTURADA] " + e.getMessage());
        }

        try {
            leerArchivoAlumnos("alumnos_2026.txt");
        } catch (FileNotFoundException e) {
            System.out.println("[CAPTURADA] " + e.getMessage());
        }

        try {
            imprimirNombreAlumno(null);
        } catch (NullPointerException e) {
            System.out.println("[CAPTURADA] " + e.getMessage());
        }
    }
}
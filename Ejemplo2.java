public class Ejemplo2 {

    public static void main(String[] args) {
        double saldo = 1000.0;
        int meses = 0;
        CuentaBancaria cuenta = new CuentaBancaria();
        double interes = cuenta.calcularInteres(saldo, meses);
        System.out.println("Interés: " + interes);
    }
    static class CuentaBancaria {
    public double calcularInteres(double caldo, int meses) {
        try {
            if (meses == 0) {
                throw new ArithmeticException("Meses != 0");
            }
            return caldo * 0.05 / 12 * meses;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
            return 0.0;
        }
    }
     }
}



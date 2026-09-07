
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Ejemplo1{
    public static void main(String[]args ){
        
         
        double saldo=1000.0;
        int meses=0;
        CuentaBancaria cuenta =new CuentaBancaria();
        double interes=cuenta.calculaInteres(saldo,meses);
        System.out.println("Interes:"+interes);
        cuenta.procesarArchivo("Archivo.txt");
        }
        }
class CuentaBancaria{
        public double calculaInteres(double saldo, int meses){
            try{
                if(meses==0)throw new ArithmeticException("Meses !=0");
                double interes =saldo*0.05/12*meses;
                return interes;
            }catch(ArithmeticException e){
                System.out.println("Error:"+e.getMessage());
                return 0.0;
            }
        }
public void procesarArchivo(String archivo) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(archivo);
            // ... procesar ...
        } catch (FileNotFoundException e) {
            System.out.println("No encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        } finally {
            // SIEMPRE se ejecuta - limpiar recursos
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                }
        }
    } 
    }
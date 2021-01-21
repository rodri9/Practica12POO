package cuenta;

/**
 *
 * @author ドディス
 */
public class MainCuenta {
    public static void main(String[] args) {
        new Cuenta("Acceso 1").start();
        new Cuenta("Acceso 2").start();
        new Cuenta("Deposito 1").start();
        new Cuenta("Deposito 2").start();
        
        System.out.println("Termina el hilo principal.");
    }
}

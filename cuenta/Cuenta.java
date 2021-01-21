package cuenta;

/**
 *
 * @author ドディス
 */
public class Cuenta extends Thread {
    private static long saldo = 0;
    
    /**
     * Constructor que recibe un parámetro.
     * @param nombre Es el nombre de la cuenta.
     */
    public Cuenta(String nombre){
        super(nombre);
    }
    
    /**
     * Método que dependiendo del nombre de la cuenta que ingrese, realiza instrucciones diferentes.
     * Utiliza hilos.
     */
    @Override
    public void run(){
        if(getName().equals("Deposito 1") || getName().equals("Deposito 2"))
        {
            this.depositarDinero(100);
        }
        else
        {
            this.extraerDinero(50);
        }
        System.out.println("Termina el "+getName());
    }
    
    /**
     * Método que permite aumentar el saldo en una determinada cantidad.
     * @param cantidad El monto que se aumentará al saldo.
     */
    public synchronized void depositarDinero(int cantidad){
        saldo += cantidad;
        System.out.println("Se depositaron "+cantidad+" pesos.");
        notifyAll();
    }
    
    /**
     * Método que permite extraer dinero de la cuenta. Reduce el saldo.
     * @param cantidad El monto en que se reduce el saldo.
     */
    public synchronized void extraerDinero(int cantidad){
        try{
            if(saldo <= 0)
            {
                System.out.println(getName()+" espera depósito"+"\nSaldo: "+saldo);
                sleep(5000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
        
        saldo -= cantidad;
        System.out.println(getName()+" extrajo "+cantidad+" pesos. \nSaldo restante: "+saldo);
        notifyAll();
    }
}

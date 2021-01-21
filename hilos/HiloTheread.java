package hilos;

/**
 *
 * @author ドディス
 */
public class HiloTheread extends Thread {

    public HiloTheread(String nombre) {
        super(nombre);
    }
    
    @Override
    public void run() {
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Iteración "+i+" de "+getName());
        }
        System.out.println("Termina el hilo "+getName());
    }
}

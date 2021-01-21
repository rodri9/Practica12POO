package grupoHilos;

/**
 *
 * @author ドディス
 */
public class GrupoDeHilos extends Thread{

    public GrupoDeHilos(ThreadGroup g, String n) {
        super(g, n);
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++)
        {
            System.out.println(getName()+" iteración "+i);
        }
    }
}

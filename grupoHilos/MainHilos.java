package grupoHilos;

/**
 *
 * @author ドディス
 */
public class MainHilos {
    public static void main(String[] args) {
        ThreadGroup grupoHilos = new ThreadGroup("Grupo con prioridad normal");
        
        Thread hilo1 = new GrupoDeHilos(grupoHilos, "Hilo 1 con prioridad máxima");
        Thread hilo2 = new GrupoDeHilos(grupoHilos, "Hilo 2 con prioridad normal");
        Thread hilo3 = new GrupoDeHilos(grupoHilos, "Hilo 3 con prioridad normal");
        Thread hilo4 = new GrupoDeHilos(grupoHilos, "Hilo 4 con prioridad normal");
        Thread hilo5 = new GrupoDeHilos(grupoHilos, "Hilo 5 con prioridad normal");
        
        hilo1.setPriority(Thread.MAX_PRIORITY);
        grupoHilos.setMaxPriority(Thread.NORM_PRIORITY);
        System.out.println("Prioridad promedio del grupo "+grupoHilos.getMaxPriority());
        
        System.out.println("Prioridad Hilo 1 = "+hilo1.getPriority());
        System.out.println("Prioridad Hilo 2 = "+hilo2.getPriority());
        System.out.println("Prioridad Hilo 3 = "+hilo3.getPriority());
        System.out.println("Prioridad Hilo 4 = "+hilo4.getPriority());
        System.out.println("Prioridad Hilo 5 = "+hilo5.getPriority());
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
        listaHilos(grupoHilos);
    }
    
    public static void listaHilos(ThreadGroup grupoActual){
        int numHilos;
        Thread [] listaHilos;
        
        numHilos = grupoActual.activeCount();
        listaHilos = new Thread [numHilos];
        grupoActual.enumerate(listaHilos);
        System.out.println("Hilos activos: "+numHilos);
        
        for(int i = 0; i < numHilos; i++)
        {
            System.out.println("Hilo activo "+i+" = "+listaHilos[i].getName());
        }
    }
}

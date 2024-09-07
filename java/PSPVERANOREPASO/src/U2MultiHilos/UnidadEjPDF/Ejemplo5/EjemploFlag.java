package U2multihilos.UnidadEjPDF.Ejemplo5;

public class EjemploFlag extends Thread{
    private volatile boolean fin = false;

    @Override
    public void run() {
        while (!fin) {
            System.out.println("En el hilo");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Hilo finalizado");
    }

    public void fin(){
        fin = true;
    }
}

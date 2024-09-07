package U2multihilos.UnidadEjPDF.Ejemplo5;

public class EjemploFlagNoV extends Thread {
    static boolean fin;

    @Override
    public void run() {
        while (!fin) {
            System.out.println("Hilo fin");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new EjemploFlagNoV();
        t.start();
        Thread.sleep(3000);
        fin = true;
        System.out.println("main fin");
    }
}

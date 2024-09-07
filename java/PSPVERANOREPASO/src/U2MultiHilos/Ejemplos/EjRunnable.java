package U2multihilos.Ejemplos;

public class EjRunnable implements Runnable {
    private String nombre;

    public EjRunnable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + ", mensaje " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread hilo1 = new Thread(new EjRunnable("Hilo 1"));
        Thread hilo2 = new Thread(new EjRunnable("Hilo 2"));
        Thread hilo3 = new Thread(new EjRunnable("Hilo 3"));

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
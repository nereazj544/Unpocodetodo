package U2MultiHilos.Ejemplos;

/**
 * Ejemplo de Thread
 */
public class EjThread extends Thread {
    private String nombre;

    public EjThread(String nombre) {
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
        EjThread hilo1 = new EjThread("Hilo 1");
        EjThread hilo2 = new EjThread("Hilo 2");
        EjThread hilo3 = new EjThread("Hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

}
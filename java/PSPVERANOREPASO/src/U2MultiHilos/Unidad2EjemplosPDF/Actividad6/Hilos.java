package U2multihilos.Unidad2EjemplosPDF.Actividad6;

/**
 * Hilos
 */
public class Hilos implements Runnable {
    // ? BASE DEL EJEMPLO 2
    /*
     * @Override
     * public void run() {
     * for (int i = 0; i <= 5; i++) {
     * try {
     * Thread.sleep(100);
     * } catch (InterruptedException e) {
     * }
     * System.out.printf("%s, mensaje %d \n", Thread.currentThread().getName(), i);
     * }
     * }
     */

    // ? Para añadir prioridad
    private int p; // p sera prioridad

    public Hilos(int p) {
        this.p = p;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(p);
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.printf("%s, (PRIORIDAD: %d) mensaje %d \n", Thread.currentThread().getName(),
                    Thread.currentThread().getPriority(),
                    i);
        }
    }

}
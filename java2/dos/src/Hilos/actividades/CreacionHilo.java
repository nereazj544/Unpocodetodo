package Hilos.actividades;

import java.util.Random;

/**
 * CreacionHilo
 * Escribir un programa concurrente que ejecute N hilos. Todos los hilos
 * realizan el mismo trabajo:
 * 
 * - Imprimir una línea identificándose, anunciando el inicio de su ejecución y
 * mostrando el
 * 
 * tiempo que permanecerán dormidos.
 * 
 * - Dormir durante el tiempo especificado para cada uno de ellos.
 * - Imprimir una línea donde se identifiquen de nuevo para anunciar su
 * finalización.
 * 
 * Cuando todos los hilos hayan finalizado su tarea, el hilo principal imprimirá
 * un mensaje informando
 * 
 * de ello
 */
public class CreacionHilo {

    private static final int N = 5;
    private static int endthread = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(new Hilos(i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
            }
        }
    }

    static class Hilos implements Runnable {

        private int id;
        private int mimir;

        public Hilos(int id) {
            this.id = id;
            this.mimir = new Random().nextInt(5000) + 1000;
        }

        @Override
        public void run() {
            System.out.println("Hilo " + id + " inciando. Mimir por " + mimir + " ms.");

            try {
                Thread.sleep(mimir);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            synchronized (CreacionHilo.class) {
                endthread++;
                if (endthread == N) {
                    System.out.println("Se han termido todos los hilos.");
                }
            }
        }

    }
}
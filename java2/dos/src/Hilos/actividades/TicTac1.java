package Hilos.actividades;

/**
 * TicTac1
 * Crear un programa Java que ejecute dos hilos. Uno de ellos repetirá de forma
 * indefinida la
 * impresión en la consola de la palabra TIC a intervalos de un segundo. El otro
 * hará lo mismo con la
 * palabra TAC. Define una única clase que permita crear ambos hilos.
 */
public class TicTac1 implements Runnable {

    String palabra;

    public TicTac1(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        while (true) { 
            System.out.print(" " + palabra + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac1("TIC"));
        Thread tac = new Thread(new TicTac1("TAC"));

        tic.start();
        tac.start();

    }

}
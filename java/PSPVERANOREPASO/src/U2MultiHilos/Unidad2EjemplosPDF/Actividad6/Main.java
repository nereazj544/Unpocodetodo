package U2MultiHilos.Unidad2EjemplosPDF.Actividad6;

public class Main {
    public static void main(String[] args) {
        /*
         * 
         Runnable h = new Thread(new Hilos (Thread.MAX_PRIORITY));
         for (int i = 1; i <= 3; i++)
         new Thread(h, "hilo " + i).start();
         */

         Thread h1 = new Thread(new Hilos(Thread.MAX_PRIORITY), "Hilo 1");
         Thread h2 = new Thread(new Hilos(Thread.MIN_PRIORITY), "Hilo 2");
         Thread h3 = new Thread(new Hilos(Thread.NORM_PRIORITY), "Hilo 3");

         h1.start();
         h2.start();
         h3.start();
        
    }

}

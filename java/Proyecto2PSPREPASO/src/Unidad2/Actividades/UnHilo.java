package java.Proyecto2PSPREPASO.src.Unidad2.Actividades;

//* Crear hilos instanciado una subclase de Thread
public class UnHilo extends Thread {

    public UnHilo(int id) {
        super("hilo " + id);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ", mensaje " + i);
        }
    }

}

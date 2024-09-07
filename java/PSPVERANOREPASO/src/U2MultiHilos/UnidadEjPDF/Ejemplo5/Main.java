package U2multihilos.UnidadEjPDF.Ejemplo5;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EjemploFlag t = new EjemploFlag();
        t.start();
        Thread.sleep(2000);
        t.fin();
    }
}

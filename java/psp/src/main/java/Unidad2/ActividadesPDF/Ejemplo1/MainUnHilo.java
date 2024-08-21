package Unidad2.ActividadesPDF.Ejemplo1;

public class MainUnHilo {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new UnHilo(i).start();
        }
    }
}

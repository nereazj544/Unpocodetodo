package java.Proyecto2PSPREPASO.src.Unidad2.Actividades;

public class MainAc1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new UnHilo(i).start();
        }
    }
}

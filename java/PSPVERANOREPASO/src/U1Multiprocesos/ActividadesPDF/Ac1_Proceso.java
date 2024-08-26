package U1Multiprocesos.ActividadesPDF;

import java.io.IOException;

public class Ac1_Proceso {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("> El sistema ha ejecudo la clase Java: Ac1");
        // String [] cmd = {"java", "-cp",
        // "C:\\Users\\nzjha\\Desktop\\Clon_Github\\Unpocodetodo\\java\\PSPVERANOREPASO\\src\\U1Multiprocesos\\ActividadesPDF\\",
        // "Ac1"};
        // Process p = Runtime.getRuntime().exec("java Ac1");
        Process p = Runtime.getRuntime().exec("javac Ac1");
        p.waitFor();
    }
}

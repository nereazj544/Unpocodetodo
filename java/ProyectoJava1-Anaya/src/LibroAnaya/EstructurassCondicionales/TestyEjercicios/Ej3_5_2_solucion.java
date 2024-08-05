package EstructurassCondicionales.TestyEjercicios;

public class Ej3_5_2_solucion {
    private static final String CANTA = "CANTA";
    private static final String LADRA = "LADRA";

    public static void main(String[] args) {
        /*
         * 
         * boolean hayArgumentos = false;
         * if (args != null) {
         * System.out.println("> El sistema no ha detectado nada");
         * } else if (args.length > 0) {
         * hayArgumentos = true;
         * int n = args.length;
         * String Ap = args[0].toLowerCase();
         * if (Ap.equals(CANTA)) {
         * System.out.
         * println("> El sistema ha detectado que el argumento pasado es igual que: " +
         * CANTA);
         * }else if (Ap.equals(LADRA)) {
         * System.out.
         * println("> El sistema ha detectado que el argumento pasado es igual que: " +
         * LADRA);
         * 
         * }
         * } else {
         * 
         * }
         */
        String david = "Esa oscuridad no es parte de mi,\r\n" +
                "¡ya superé el pasado!\r\n" +
                "Y aunque ya no es mi capitán seré su mano derecha,\r\n" +
                "¡me mantengo a su lado!\r\n" +
                "Que lleve parche no significa que al portero yo no pueda ver,\r\n" +
                "si no mira este tiro al arco con el...\r\n" +
                "¡PINGÜINO EMPERADOR Nº3!";

        boolean hayArgumentos = args.length > 0;
        boolean nperro = args.length > 1;
        if (!hayArgumentos) {
            System.out.println("> El sisteman no ha detectado ningun argumento");
        } else if (hayArgumentos) {
            System.out.println("> El sistema ha detectado argumentos");
            String a = args[0];
            if (a.equals(CANTA)) {
                System.out.println("> El sistema ha detectado que argumento es igual que: " + CANTA);
                System.out.println(
                        "> El sistema canta: \033[1mParte de David en el rap de INAZUMA JAPÓN (MacroRap) | Inazuma Eleven | Keyto & Alice ft. Grandes Artistas:\033[0m"
                                + "\033[32m " + david + "\033[0m");
            } else if (a.equals(LADRA)) {
                System.out.println("> El sistema ha detectado que argumento es igual que: " + LADRA);
                if (!nperro) {
                    System.out.println("> El sistema le falta nombre del perro.");
                } else {
                    String nombre = args[1];
                    System.out.println("> El sistema detecto el nombre: " + nombre);
                    System.out.println("> El sistema ladra: Wouf");
                }

            }
        }
    }
}

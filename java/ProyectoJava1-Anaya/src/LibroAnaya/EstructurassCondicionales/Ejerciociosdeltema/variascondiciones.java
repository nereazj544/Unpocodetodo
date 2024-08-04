package EstructurassCondicionales.Ejerciociosdeltema;

public class variascondiciones {
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        /*
         * 
         * if (t > 0) {
         * System.out.println(t + "ºC positivo");
         * 
         * } else {
         * if (t == 0) {
         * System.out.println(t + "ºC, ni frio ni calor");
         * } else {
         * System.out.println(t + "ºC bajo cero");
         * }
         * }
         */
        if (t > 0) {
            System.out.println(t + "ºC positivo");
        } else if (t == 0) {
            System.out.println(t + "ºC, ni frio ni calor");
        } else {
            System.out.println(t + "ºC bajo cero");
        }
    }
}

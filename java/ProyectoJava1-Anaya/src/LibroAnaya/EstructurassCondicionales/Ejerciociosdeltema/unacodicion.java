package EstructurassCondicionales.Ejerciociosdeltema;

public class unacodicion {
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        if (t > 0) {
            System.out.println(t + " ºC positivo");
        } else {
            System.out.println(t + " ºC negativo");
        }
    }
}

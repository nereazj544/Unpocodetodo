package EstructurassCondicionales.TestyEjercicios;

public class Ej3_3 {
    public static void main(String[] args) {
        int MAX_ARGS = 10;
        if (args.length == 0) {
            System.out.println("> El sistema detecto que no se ha introducido ningun argumento.");
        } else if (args.length >= MAX_ARGS) {
            System.out.println("> Se han recivido " + MAX_ARGS + " argumentos");
        } else if (args.length != MAX_ARGS) {
            System.out.println("> No se han recivido " + MAX_ARGS + " argumentos");
        }
        else {
            System.out.println("> El sistema detecto varios argumentos");
        }
    }
}

package EstructurasIterativas.testyejercicos;

public class EJ4_1 {
    public static void main(String[] args) {
        int MAX_ARG = 5;

        for (String string : args) {
            if (args.length < MAX_ARG) {
                System.out.println(string.toLowerCase());
            }else{
                System.out.println(string.toUpperCase());
            }
        }
    }
}

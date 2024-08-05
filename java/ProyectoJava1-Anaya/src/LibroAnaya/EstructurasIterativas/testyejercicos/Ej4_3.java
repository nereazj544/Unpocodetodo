package EstructurasIterativas.testyejercicos;

public class Ej4_3 {
    public static void main(String[] args) {
        int MAX_NUM = 5;

        // if (args.length <= MAX_NUM) {
        // for (int i = 0; i < 4; i++) {
        // String a = args[i];
        // System.out.println(i + " PALABRA: " + a);
        // }
        // }else{
        // for (int i = 0; i < 2; i++) {
        // String a = args[i];
        // System.out.println(i + " PALABRA: " + a);

        // }
        for (String string : args) {
            if (string.length() <= MAX_NUM) {
                for (int i = 0; i < 4; i++) {
                    System.out.print(string + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < 2; i++) {
                    System.out.print(string + " ");

                }

            }
        }

    }
}

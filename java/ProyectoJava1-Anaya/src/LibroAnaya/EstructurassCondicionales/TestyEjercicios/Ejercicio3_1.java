package EstructurassCondicionales.TestyEjercicios;

/*
* Ejercicio 3.1 – Comprueba el número de argumentos que recibe tu programa.
* Si no recibe argumentos, avisa al usuario. En caso contrario, indícale
* cuántos
* has recibido.
*/
public class Ejercicio3_1 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("> El sistema detecto que no se ha introducido ningun argumento.");
        } else {
            String word = args[0];
            int valor = Integer.parseInt(args[1]);
            System.out.println("> El sistema detecto que se han introducido argumentos: " + args.length);
            System.out.printf("> El sistema mostrara los agumentos: %s, %d", word, valor);
        }
    }
}

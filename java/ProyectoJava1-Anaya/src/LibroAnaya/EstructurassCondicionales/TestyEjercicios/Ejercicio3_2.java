package EstructurassCondicionales.TestyEjercicios;

/* Ejercicio 3.2 - Comprueba el número de argumentos que recibe tu programa. 
 * Si no recibe argumentos, avisa al usuario. Si recibe hasta 4, indícale 
 * cuántos has recibido. Si recibe más, avisa al usuario.
 */
public class Ejercicio3_2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("> El sistema detecto que no se ha introducido ningun argumento.");
        } else if (args.length <= 4) {
            System.out.println("> Se han recivido 4 argumentos");
        } else {
            System.out.println("> El sistema detecto varios argumentos");
        }
    }

}

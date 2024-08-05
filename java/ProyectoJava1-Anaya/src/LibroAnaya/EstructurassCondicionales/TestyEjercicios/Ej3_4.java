package EstructurassCondicionales.TestyEjercicios;

/* Ejercicio 3.4 – Escribe un programa que reciba el número de mes y devuelva
 * el número de días que tiene. Ignora los años bisiestos. 
 * Sólo debes hacer algo si recibes 1 sólo parámetro.
 */
public class Ej3_4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("> El sistema no ha detectado ningun argumento añadido");
            System.exit(0);
        } else {
            int n = Integer.parseInt(args[0]);
            System.out.println("> El sistema a detectado: " + n);
            System.out.print("> El sistema pasa a mostrar: ");
            int dia = calcularMes(n);
            System.out.println("> El sistema pasa a mostrar los dias del mes: "+ dia);
        }
    }

    private static int calcularMes(int n) {
        int dia;
        switch (n) {
            case 2:
                // mes = "Febrero";
                System.out.println("Febrero");
                dia = 28;
                break;
                case 4:
                System.out.println("Abril");
                dia = 30;
                break;
                case 6:
                // mes = "Junio";
                System.out.println("Junio");
                dia = 30;
                break;
                case 9:
                System.out.println("Septiembre");
                // mes = "Septiembre";
                dia = 30;
                break;
                case 11:
                System.out.println("Noviembre");
                // mes = "Noviembre";
                dia = 30;
                break;
            default:
                // mes = "Dias largos con 31 dias";
                System.out.println("Meses largos con 31 dias");
                dia = 31;
                break;
            
        }
        return dia;
    }
}

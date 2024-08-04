package MiPrimerProyecto;

public class Ejercicio1 {
    public static void main(String[] args) {
        /* VARIABLES */
        int dorsal = 9;
        String shawn = "Ruge con fuerza, ventisca eterna es mi querido tesoro.\r\n" +
                "Buscando el futbol perfecto por miedo a perder a mi hermano, haber seguido solo puede haber perdido como alguna vez perdimos todos \r\n"
                +
                "Si rompo las cadenas y me quito la bufanda...\r\n" +
                "¡nace el aullido del lobo!";
        String chisme = "%";

        String Xavier = "Soy humano como tú,\r\n" +
                "aunque con el balón parezca de otro planeta,\r\n" +
                "un extraterrestre,\r\n" +
                "extra ofensivo,\r\n" +
                "con un meteorito de forma secreta. \r\n" +
                "¡Big Bang!\r\n" +
                "No me pueden parar si van a intentar superar a este jugador \r\n" +
                "Inazuma Japón\r\n" +
                "¡qué la supernova de un poder celestial!\r\n";
        String n = "\\n";
        String valor = args[0];
                /*TIPOS DE SYSTEM.OUT.PRINT */
        System.out.println("\033[37m> Un \033[1mSystem.out.println\033[0m \033[37msirve para mostrar mensajes");
        System.out.println("> Con \033[1mSystem.out.println\033[0m \033[37m inserta autamaticamente un salto de Linea sintener que usar el comando: "+ n + ", pero si omitimos el ln y en sulugar solo ponemos: \033[1mSystem.out.print\033[0m \033[37mno insertata un salto de linea");
        System.out.printf(
                ">  \033[37m Con un \033[1mSystem.out.printf\033[0m sirve para mostrar mensajes de forma formateada poniendo %s un tipo: Por ejemplo: \n"
                        +
                        "> \033[1mDorsal de Shawn Froste: %d.  Parte de Shawn en el rap de INAZUMA JAPÓN (MacroRap) | Inazuma Eleven | Keyto & Alice ft. Grandes Artistas:\033[0m  \033[34m%s\n",
                chisme, dorsal, shawn);
        System.out.println(
                " \033[1m\033[37m > Informacion sobre los format: https:www.it.uc3m.es/pbasanta/asng/course_notes/input_output_printf_es.html \033[0m");

        System.out.println("> DESTACANDO TEXTO/ CAMBIAR COLOR usando \033[34m\033[1m ANSI\033[0m \033[37m: " +
                "\033[1mParte de Xavier en el rap de INAZUMA JAPÓN (MacroRap) | Inazuma Eleven | Keyto & Alice ft. Grandes Artistas:\033[0m \n"
                +
                "\033[31m " + Xavier + "\033[30m");
        System.out.println("\033[37m> tambien se pueden usar caracteres con agrs (en ecplise es más sencillo que en VS code)= valor añadido por ARGS: " + valor);
    }
}

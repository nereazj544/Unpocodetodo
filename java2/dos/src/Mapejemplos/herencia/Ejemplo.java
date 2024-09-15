package mapejemplos.herencia;

public class Ejemplo {
    public static void main(String[] args) {
        personajes p;
        p = new personajes(null);
        p.Agregar("Naruto", "Naruto Shippuden");
        p.Agregar("Bai Long", "Inazuma Eleven Go");

        System.out.println("Anime de Bai Long: " + p.Obtener("Bai Long"));
        System.out.println("Completo: ");
        p.Mostrar();

    }
}

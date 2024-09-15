package ACTIVIDADES_ENTREGA.Unidad2.Chinos;

public class ChinosFilosofos extends Thread{
    private String nombre;
    private Mesa mesa;
    private int i;
    private int d;
    
    public ChinosFilosofos(String nombre, Mesa mesa, int i, int d) {
        this.nombre = nombre;
        this.mesa = mesa;
        this.i = i;
        this.d = d;
    }

    @Override
    public void run() {
        while (true) {
            Pesnar();
            Palillos();
            Comer();
            DPalillos();
        }
    }

    private void DPalillos() {
        System.out.println("FILOSOFO " + nombre + " deja los palillos");
        mesa.DPalillos(nombre, i, d);
    }

    private void Comer() {
        System.out.println("FILOSOFO " + nombre + "");
    }

    private void Palillos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Palillos'");
    }

    private void Pesnar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Pesnar'");
    }

    


}

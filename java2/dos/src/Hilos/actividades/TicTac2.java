package Hilos.actividades;

//Movida con los ::

// Usando referencias a metodos usando meros lo del "tic::Tarea" es una referencia a estancia.

	
public class TicTac2 {
    private String sonido;
    
    
    public TicTac2(String sonido) {
        this.sonido = sonido;
        
    }
    
    void Tarea() {
        while (true) {
            System.out.println(sonido + " ");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    
    public static void main(String[] args) {
        TicTac2 tic = new TicTac2("TIC");
        TicTac2 tac = new TicTac2("TAC");
        new Thread(tic::Tarea).start();
        new Thread(tac::Tarea).start();
        
        //Modia con "::"
    }
}
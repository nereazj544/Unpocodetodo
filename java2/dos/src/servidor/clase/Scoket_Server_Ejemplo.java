package servidor.clase;

// import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scoket_Server_Ejemplo {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("COMUNICANDOSE POR EL PUERTO: 5000");
            
            ExecutorService e = Executors.newFixedThreadPool(100);
            
            while (true) {
                // ! Creamos el hilo en el servidor ⬇️
                Socket socket = serverSocket.accept();
                e.execute(new TareaRespuesta(socket));
            }
        }

    }
}
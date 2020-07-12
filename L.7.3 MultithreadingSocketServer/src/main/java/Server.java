import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    new MessageServiceThread(socket).start();
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}

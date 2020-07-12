import java.io.*;
import java.net.Socket;

public class MessageServiceThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public MessageServiceThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
                true);
    }

    @Override
    public void run() {
        while (true) {
            String message = null;
            try {
                message = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (message.equals("Bye.")) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
            out.println(message);
        }
    }
}

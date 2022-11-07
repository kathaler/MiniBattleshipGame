import java.io.IOException;
import java.net.Socket;

public class Client {
    private BoardPanel bp;
    public Client(String ip, int port) throws IOException {
        Socket socket = new Socket(ip, port);
    }
}

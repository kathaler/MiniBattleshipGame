import java.io.IOException;
import java.net.Socket;

public class Client extends Network{

    public Client(String ip, int port) throws IOException {
        super.setSocket(new Socket(ip, port));
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client extends Network{

    public Client(String ip, int port) throws IOException {
        super.setSocket(new Socket(ip, port));
    }
}

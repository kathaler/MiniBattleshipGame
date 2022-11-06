import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable{
    private InetAddress ip;
    private ServerSocket server;
    private BlackBoard bb;
    public Server() {
        this.bb = new BlackBoard();
        try {
            this.ip = InetAddress.getLocalHost();
            this.server = new ServerSocket(0,1, ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        
    }
}


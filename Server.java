import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable{
    private InetAddress ip;
    private ServerSocket server;
    private Socket clientSocket;
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
    public void accept() throws IOException {
        clientSocket = server.accept();
        System.out.println("Success");
    }

    public String getIP() {
        return this.ip.getHostAddress();
    }

    public int getPort() {
        return server.getLocalPort();
    }

    @Override
    public void run() {
        
    }
}


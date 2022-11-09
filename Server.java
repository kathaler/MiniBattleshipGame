import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Network implements Runnable {
    private InetAddress ip;
    private ServerSocket server;

    public Server() {
        try {
            this.ip = InetAddress.getLocalHost();
            this.server = new ServerSocket(0, 1, ip);
            System.out.println("IP:Port = " + getIP() + ":" + getPort());
            Socket socket = server.accept();
            super.setSocket(socket);

            System.out.println("Success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getIP() {
        return this.ip.getHostAddress();
    }

    public int getPort() {
        return server.getLocalPort();
    }


}


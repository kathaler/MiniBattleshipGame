import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    private DataInputStream dis;
    private DataOutputStream dout;

    public Server() {
        this.bb = BlackBoard.getInstance();
        try {
            this.ip = InetAddress.getLocalHost();
            this.server = new ServerSocket(0,1, ip);
            System.out.println("IP: " + getIP() + "\nPort: " + getPort());
            clientSocket = server.accept();
            dis = new DataInputStream(clientSocket.getInputStream());
            dout = new DataOutputStream(clientSocket.getOutputStream());

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

    @Override
    public void run() {
        try {
            while(true){
                String str = dis.readUTF();
                System.out.println("message=" + str);
                
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


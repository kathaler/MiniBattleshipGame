import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private InetAddress ip;
    private ServerSocket server;
    private Socket socket;
    private BlackBoard bb;
    private DataInputStream dis;
    private DataOutputStream dout;

    public Server() {
        this.bb = BlackBoard.getInstance();
        try {
            this.ip = InetAddress.getLocalHost();
            this.server = new ServerSocket(0, 1, ip);
            System.out.println("IP: " + getIP() + "\nPort: " + getPort());
            socket = server.accept();
            dis = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

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
            while (true) {
                read();
                write();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void read() throws IOException {
        dout.writeUTF(bb.getTable1());
    }

    private void write() throws IOException {
        BlackBoard.getInstance().updateTable2(dis.readUTF());

    }
}


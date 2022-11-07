import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private BoardPanel bp;
    private Socket socket;
    DataOutputStream dout;
    DataInputStream dis;
    public Client(BoardPanel bp) throws IOException {
       this.bp = bp;
    }

    public void establishConnection(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        dout = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());

    }

    public void write(String str) throws IOException {
        dout = new DataOutputStream(socket.getOutputStream());
        dout.writeUTF(str);
        dout.flush();
    }

    public void read() throws IOException {
        String str = dis.readUTF();
        System.out.println("message=" + str);
    }
}

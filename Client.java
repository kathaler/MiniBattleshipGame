import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{
    //private BoardPanelB bp;
    private Socket socket;
    private BlackBoard bb;
    DataOutputStream out;
    DataInputStream in;
    public Client(String ip, int port) throws IOException {
        this.bb = BlackBoard.getInstance();
        socket = new Socket(ip, port);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    public void read() throws IOException {
        out.writeUTF(bb.getTable1());
    }

    private void write() throws IOException {
        BlackBoard.getInstance().updateTable2(in.readUTF());
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
}

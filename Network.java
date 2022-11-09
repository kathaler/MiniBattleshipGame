import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Network implements Runnable{
    private BlackBoard bb;
    private DataOutputStream out;
    private DataInputStream in;

    public void setSocket(Socket socket) throws IOException {
        bb = BlackBoard.getInstance();
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            out.writeUTF(bb.getShips());
            bb.setEnemyShips(in.readUTF());
            while (true) {
                read();
                write();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void read() throws IOException {
        out.writeUTF(bb.getTable1());
    }

    private void write() throws IOException {
        bb.updateTable2(in.readUTF());
    }
}

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game extends JFrame implements ActionListener {
    BoardPanel b1;
    BoardPanel b2;

    public Game() {
        super("Mini Battleship Game");
        GridLayout grid = new GridLayout(2,1);

        JPanel main = new JPanel();
        main.setBackground(Color.GRAY);
        b1 = new BoardPanelB();
        b2 = new BoardPanelA();
        main.setLayout(grid);
        main.add(b1);
        main.add(b2);
        this.add(main);
        JMenuBar mb = new JMenuBar ();
        JMenu m1 = new JMenu ("Game");
        JMenuItem host = new JMenuItem ("Host");
        JMenuItem connect = new JMenuItem ("Connect");

        host.addActionListener(this);
        connect.addActionListener(this);

        m1.add(host);
        m1.add(connect);

        mb.add(m1);
        this.setJMenuBar(mb);

        JPanel sPanel = new JPanel();
        JLabel connected = new JLabel("Not Connected", SwingConstants.RIGHT);
        connected.setFont(new Font("Verdana", Font.ITALIC, 10));
        sPanel.add(connected);
        sPanel.setMaximumSize(new Dimension(1000,8));
        add(sPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        Game win = new Game ();
        win.getContentPane ().setBackground (Color.GRAY);
        win.setSize (500,1400);
        win.setVisible (true);
        win.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand ().equals ("Host")) {
            Server server = new Server();
            JOptionPane.showMessageDialog (this, "IP: " + server.getIP() + "\nPort: " + server.getPort());
            try {
                server.accept();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getActionCommand ().equals ("Connect")) {
            String ip_port = JOptionPane.showInputDialog("Please enter a game IP and Port (ip:port)");
            String[] creds = ip_port.split(":");
            String ip = creds[0];
            int port = Integer.parseInt(creds[1]);
            try {
                Client client = new Client(ip, port);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game extends JFrame implements ActionListener {
    BoardPanelA topPanel;
    BoardPanelB bottomPanel;
    JLabel connected;
    JPanel main;

    public Game() throws IOException {
        super("Mini Battleship Game");

        GridLayout grid = new GridLayout(2,1);

        main = new JPanel();
        main.setBackground(Color.GRAY);
//        topPanel = new BoardPanelA();
//        bottomPanel = new BoardPanelB();
        main.setLayout(grid);
//        main.add(topPanel);
//        main.add(bottomPanel);
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
        connected = new JLabel("Not Connected");
        connected.setFont(new Font("Verdana", Font.ITALIC, 10));
        sPanel.add(connected);
        sPanel.setMaximumSize(new Dimension(1000,8));
        add(sPanel, BorderLayout.NORTH);
    }

    private void addGamePanels() {
        topPanel = new BoardPanelA();
        bottomPanel = new BoardPanelB();
        main.add(topPanel);
        main.add(bottomPanel);
    }

    public static void main(String[] args) throws IOException {
        Game win = new Game ();
        win.getContentPane ().setBackground (Color.GRAY);
        win.setSize (500,1400);
        win.setVisible (true);
        win.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand ().equals ("Host")) {
            Thread thread = new Thread(new Server());
            thread.start();
            connected.setText("Connected");
        }
        else if(e.getActionCommand ().equals ("Connect")) {
            String ip_port = JOptionPane.showInputDialog("Please enter a game IP and Port (ip:port)");
            String[] creds = ip_port.split(":");
            String ip = creds[0];
            int port = Integer.parseInt(creds[1]);
            try {
                Thread thread = new Thread(new Client(ip, port));
                thread.start();
                connected.setText("Connected");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        addGamePanels();
    }


}
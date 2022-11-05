import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    BoardPanel b1;
    BoardPanel b2;

    public Game() {
        super("Mini Battleship Game");
        GridLayout grid = new GridLayout(2,1);

        b1 = new BoardPanelA();
        b2 = new BoardPanelB();
        this.setLayout(grid);
        this.add(b1);
        this.add(b2);

    }

    public static void main(String[] args) {
        Game win = new Game ();
        win.getContentPane ().setBackground (Color.GRAY);
        win.setSize (500,1200);
        win.setVisible (true);
        win.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    public static void main(String[] args) {
        Game win = new Game ();
        win.getContentPane ().setBackground (Color.GRAY);
        win.setSize (600,1200);
        win.setVisible (true);
        win.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    public Game() {
        super("Mini Battleship Game");


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
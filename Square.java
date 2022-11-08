import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Square extends JPanel implements MouseListener{
    private int x;
    private int y;
    private boolean clickable;
    private boolean isClicked;
    private JLabel status;
    private boolean isShip;
    private BoardPanel bp;

    public Square(int x, int y, boolean c, BoardPanel boardPanel) {
        this.x = x;
        this.y = y;
        this.clickable = c;
        this.isClicked = false;
        this.isShip = false;
        this.status = new JLabel("");
        this.status.setForeground(Color.RED);
        this.status.setFont(new Font("Verdana", Font.BOLD, 18));
        this.bp = boardPanel;
        this.add(status);
        this.addMouseListener(this);
    }

    public Square(int x, int y, boolean clickable, boolean isClicked, boolean isShip, BoardPanel bp) {
        this.x = x;
        this.y = y;
        this.clickable = clickable;
        this.isClicked  = isClicked;
        this.bp = bp;
        if(isClicked) {
            this.status = new JLabel("X");
        } else {
            this.status = new JLabel("");
        }
        if(isShip) {
            this.setBackground(Color.BLACK);
        }
        this.status.setForeground(Color.RED);
        this.status.setFont(new Font("Verdana", Font.BOLD, 18));
        this.add(status);
        this.addMouseListener(this);
    }

    public void makeShip() {
        this.isShip = true;
        this.setBackground(Color.BLACK);
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(clickable) {
            System.out.println("(" + x + ", " + y + ")");
            this.status.setText("X");
            this.isClicked = true;
            this.clickable = false;
            bp.processClick();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.x + "," + this.y + "," + this.isClicked + "," + this.clickable + "," + this.isShip + "/");
        return sb.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

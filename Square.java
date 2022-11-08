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
    private BoardPanel bp;

    public Square(int x, int y, boolean c, BoardPanel boardPanel) {
        this.x = x;
        this.y = y;
        this.clickable = c;
        this.isClicked = false;
        this.status = new JLabel("");
        this.status.setForeground(Color.RED);
        this.status.setFont(new Font("Verdana", Font.BOLD, 18));
        this.bp = boardPanel;
        this.add(status);
        this.addMouseListener(this);
    }

    public Square(int x, int y, boolean clickable, boolean isClicked, BoardPanel bp) {
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
        this.status.setForeground(Color.RED);
        this.status.setFont(new Font("Verdana", Font.BOLD, 18));
        this.add(status);
        this.addMouseListener(this);
    }

    public boolean isClickable() {
        return clickable;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public int getRow() {
        return x;
    }

    public int getCol() {
        return y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        sb.append(this.x + "," + this.y + "," + this.isClicked + "," + this.clickable + "/");
        return sb.toString();
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

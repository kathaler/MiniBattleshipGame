import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.util.Observable;

public class Square extends JPanel implements MouseListener{
    private int x;
    private int y;
    private boolean clickable;
    private boolean isClicked;
    private JLabel status;
    private BoardPanel bp;

    public Square(int x, int y, boolean c, BoardPanel bp) {
        this.x = x;
        this.y = y;
        this.clickable = c;
        this.status = new JLabel("");
        this.status.setForeground(Color.RED);
        this.status.setFont(new Font("Verdana", Font.BOLD, 18));
        this.bp = bp;
        this.add(status);
        this.addMouseListener(this);
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
            try {
                bp.updateSquares();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
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

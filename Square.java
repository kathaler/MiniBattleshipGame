import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JPanel implements MouseListener {
    private int x;
    private int y;
    private boolean clickable;

    public Square(int x, int y, boolean c) {
        this.x = x;
        this.y = y;
        this.clickable = c;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(clickable) System.out.println("(" + x + ", " + y + ")");;
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

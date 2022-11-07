import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanelA extends BoardPanel implements MouseListener{
    private BlackBoard bb;
    private Square[][] table1;
    private Square[][] table2;
    public BoardPanelA() {
        this.addMouseListener(this);
        bb = BlackBoard.getInstance();
        bb.addObserver(this);
    }

    public void updateBlackBoard() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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

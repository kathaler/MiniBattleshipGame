import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanelA extends BoardPanel implements MouseListener{
    private BlackBoard bb;
    boolean start = false;
    public BoardPanelA() {
        this.addMouseListener(this);
        bb = BlackBoard.getInstance();
        bb.updateTable1(Util.serialize(this.squares));
        bb.updateTable2(Util.serialize(this.squares));
    }

    public void processClick(){
        start = true;
        bb.updateTable1(Util.serialize(squares));
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

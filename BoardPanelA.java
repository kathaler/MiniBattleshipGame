import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

public class BoardPanelA extends BoardPanel implements MouseListener{
    private BlackBoard bb;
    boolean start = false;
    public BoardPanelA() {
        this.addMouseListener(this);
        bb = BlackBoard.getInstance();
        bb.updateTable1(Util.serialize(this.panels));
        bb.updateTable2(Util.serialize(this.panels));
    }

//    @Override
//    public void update(Observable o, Object arg) {
//        if(start) {
//            Square[][] sqr = ((BlackBoard) o).getTable2();
//            this.panels = sqr;
//            super.markSquares();
//        }
//    }

    public void processClick(){
        start = true;
        bb.updateTable1(Util.serialize(panels));
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

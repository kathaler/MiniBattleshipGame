import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanelA extends BoardPanel{
    private BlackBoard bb;
    public BoardPanelA() {
        bb = new BlackBoard();
        bb.addObserver(this);
    }
}

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardPanelA extends BoardPanel{
    private BlackBoard bb;
    boolean start = false;
    ArrayList<ArrayList<Square>> enemyShips;

    public BoardPanelA() {
        bb = BlackBoard.getInstance();
        bb.updateTable1(Util.serialize(this.squares));
    }

    public void processClick(){
        start = true;
        if(enemyShips == null) {
            String check = BlackBoard.getInstance().getEnemyShips();
            if(check != null) {
                enemyShips = Util.deserializeShips(check, this);
            }
        }
        bb.updateTable1(Util.serialize(squares));
    }
}

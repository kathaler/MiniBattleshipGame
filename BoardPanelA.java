import java.util.ArrayList;

public class BoardPanelA extends BoardPanel{
    private BlackBoard bb;
    boolean start = false;
    ArrayList<ArrayList<Square>> enemyShips;
    int numShipsHit;

    public BoardPanelA() {
        numShipsHit = 0;
        bb = BlackBoard.getInstance();
        bb.updateTable1(Util.serialize(this.squares));
    }

    public void processClick(){
        start = true;
        bb.updateTable1(Util.serialize(squares));
        System.out.println("in process Click : " + numShipsHit);
        if(numShipsHit == 17) {
            this.remove(main);
            super.refreshMainPanel(squares, null);
            System.out.println("Winner");
            this.remove(main);
            super.endGameScreen(true);
            super.validate();
        }
    }

    public void initEnemyShips() {
        if(enemyShips == null) {
            String check = BlackBoard.getInstance().getEnemyShips();
            if(check != null) {
                enemyShips = Util.deserializeShips(check, this);
            }
        }
    }
}

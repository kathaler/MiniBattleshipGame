import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class BoardPanelB extends BoardPanel{
    ArrayList<ArrayList<Square>> ships;

    public BoardPanelB() {
        ships = new ArrayList<>();
        for(Square[] i : squares) {
            for(Square j : i) {
                j.setClickable(false);
            }
        }
        randomlyGenerateShips();
        BlackBoard.getInstance().updateTable2(Util.serialize(squares));
        BlackBoard.getInstance().setShips(Util.serializeShips(ships));
    }

    private void randomlyGenerateShips() {
        int[] shipLengths = new int[]{2,3,3,4,5};
        Random rand = new Random();
        ships = new ArrayList<>();
        for (int i = 0; i < shipLengths.length; i++){
            ArrayList<Square> ship = new ArrayList<>();
            int row = rand.nextInt(9);
            int column = rand.nextInt(9);
            int ori = rand.nextInt(2);

            int[] coords = new int[]{row, column};
            String orientation = "";
            if (ori==1){
                orientation = "v";
            }else{
                orientation = "h";
            }

            boolean tf = checkIfAvail(coords, orientation, shipLengths[i]);
            while(!tf) {
                row = rand.nextInt(11);
                column = rand.nextInt(11);
                ori = rand.nextInt(2);
                coords = new int[]{row, column};
                if (ori==1){
                    orientation = "v";
                }else{
                    orientation = "h";
                }
                tf = checkIfAvail(coords, orientation, shipLengths[i]);
            }
            for(int j = 0; j < shipLengths[i]; j++) {
                if (orientation.equals("v")) {
                    ship.add(squares[coords[0]][coords[1]++]);
                } else {
                    ship.add(squares[coords[0]++][coords[1]]);
                }
            }
            ships.add(ship);
        }
    }

    public boolean checkIfAvail(int[] coords, String ori, int length) {
        int i = 0;
        while (i < length){
            if(coords[0]+i <= 0 || coords[1]+i <= 0 || coords[0]+i >= 11 || coords[1]+i >= 11) {
                return false;
            }
            else if(ori.equals("v")) {
                if(squares[coords[0]][coords[1] + i].isShip()) {
                    return false;
                }
            }
            else if(ori.equals("h")) {
                if(squares[coords[0] + i][coords[1]].isShip()) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    private boolean didILose() {
        for(ArrayList<Square> ship : ships) {
            for(Square sqr : ship) {
                int x = sqr.getRow();
                int y = sqr.getCol();
                if(!squares[x][y].isShip() || !squares[x][y].isClicked()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void update(Observable o, Object arg) {
        String str = ((BlackBoard) o).getTable2();
        Square[][] squares = Util.deserialize(str, this);
        this.squares = squares;
        this.remove(main);
        super.refreshMainPanel(squares, this.ships);
        if(didILose()) {
            System.out.println("Loser");
            this.remove(main);
            super.endGameScreen(false);
            super.validate();
        }
    }
}

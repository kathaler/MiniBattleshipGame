import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Random;

public class BoardPanelB extends BoardPanel implements MouseListener{
    public BoardPanelB() throws IOException {
        this.addMouseListener(this);
        for(Square[] i : squares) {
            for(Square j : i) {
                j.setClickable(false);
            }
        }
        randomlyGenerateShips();
    }

    private void randomlyGenerateShips() {
        int[] shipLengths = new int[]{2,3,3,4,5};
        Random rand = new Random();
        for (int i =0; i<shipLengths.length; i++){
            int row = 1+rand.nextInt(6);
            int column = 1+rand.nextInt(6);
            int ori = rand.nextInt(2);
            int[] coords = new int[]{row, column};
            String orientation = "";
            if (ori==1){
                orientation = "v";
            }else{
                orientation = "h";
            }
            int j = 0;
            while((j < shipLengths[i]) || (coords[0] < 10 && coords[1] < 10)) {
                if(orientation.equals("v")) {
                    squares[coords[0]][coords[1]++].makeShip();
                } else {
                    squares[coords[0]++][coords[1]].makeShip();
                }
                j++;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        String str = ((BlackBoard) o).getTable2();
        Square[][] squares = deserialize(str);
        this.squares = squares;
        this.remove(main);
        super.refreshMainPanel(squares);
        super.validate();
    }

    public Square[][] deserialize(String str) {
        Square[][] squares = new Square[11][11];
        String[] sq = str.split("/");
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                String[] curr = sq[i*11 + j].split(",");
                squares[i][j] = new Square(Integer.parseInt(curr[0]), Integer.parseInt(curr[1]),
                        false, Boolean.parseBoolean(curr[2]), Boolean.parseBoolean(curr[4]), this);
            }
        }
        return squares;
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

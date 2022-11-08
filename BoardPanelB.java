import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Observable;

public class BoardPanelB extends BoardPanel implements MouseListener{
    public BoardPanelB() throws IOException {
        this.addMouseListener(this);
    }

//    @Override
//    public void updateSquares() throws IOException {
//        StringBuilder str = new StringBuilder();
//
//        for(Square[] s: panels) {
//            for(Square sq : s) {
//                str.append(sq);
//            }
//        }
//        client.write(str.toString());
//    }
//
    @Override
    public void update(Observable o, Object arg) {
        String str = ((BlackBoard) o).getTable2();
        Square[][] squares = deserialize(str);
        panels = squares;
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
                        Boolean.parseBoolean(curr[3]), Boolean.parseBoolean(curr[2]), this);
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

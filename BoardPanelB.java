import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class BoardPanelB extends BoardPanel implements MouseListener{
    private Client client;
    public BoardPanelB() throws IOException {
        this.addMouseListener(this);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void updateSquares() throws IOException {
        StringBuilder str = new StringBuilder();

        for(Square[] s: panels) {
            for(Square sq : s) {
                if(sq.isClicked()) {
                    str.append("(" + sq.getRow() + "," + sq.getCol() + ") ");
                }
            }
        }
        client.write(str.toString());
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

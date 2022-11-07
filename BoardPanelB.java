import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanelB extends BoardPanel implements MouseListener {
    private Client client;
    public BoardPanelB(){
        //client = new Client(this);
        for(int i = 0 ; i < this.panels.length; i++) {
            for(int j = 0 ; j < this.panels.length; j++) {
                this.panels[i][j].addMouseListener(this);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Hello!");
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

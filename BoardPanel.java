import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements MouseListener, Observer {
    public BoardPanel(){
        addMouseListener(this);
        GridLayout grid = new GridLayout(10,10, -1, -1);
        this.setLayout(grid);
        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for (int i =0; i<(10*10); i++){
            final JLabel label = new JLabel("");
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(label);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void paintComponent(Graphics g) {

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

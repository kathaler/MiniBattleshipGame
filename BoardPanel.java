import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements MouseListener, Observer {
    private static final int SIDES = 11;
    private static final int SIDE_LENGTH = 60;
    private static final int GAP = 3;
    private static final Color BG = Color.GRAY;
    private static final Color CELL_COLOR = new Color(191,230,255);
    public BoardPanel(){
        addMouseListener(this);
        setBackground(BG);
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(SIDES, SIDES, GAP, GAP));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                JPanel cell = new JPanel();
                cell.setBackground(CELL_COLOR);
                cell.setPreferredSize(prefSize);
                add(cell);
            }
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

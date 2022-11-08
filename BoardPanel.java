import javax.swing.*;
import javax.swing.border.Border;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer {
    Square[][] panels;
    JPanel main;
    ArrayList<Square> areClicked;
    private static final int SIDES = 11;
    private static final int SIDE_LENGTH = 34;
    private static final int GAP = 2;
    private static final Color BG = Color.GRAY;
    private static final Color CELL_COLOR = new Color(191,230,255);

    public BoardPanel(){
        BlackBoard.getInstance().addObserver(this);
        refreshMainPanel(null);
    }

    void refreshMainPanel(Square[][] sqr) {
        this.panels = new Square[SIDES][SIDES];
        this.areClicked = new ArrayList<>();
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        main = new JPanel();
        main.setBackground(BG);
        main.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        main.setLayout(new GridLayout(SIDES, SIDES, GAP, GAP));
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                boolean c = true;
                if(i == 0 || j == 0) {
                    c = false;
                }
                Square cell = null;
                if(sqr != null) {
                    cell = sqr[i][j];
                } else {
                    cell = new Square(i,j,c,this);
                }
                cell.setBackground(CELL_COLOR);
                cell.setPreferredSize(prefSize);
                panels[i][j] = cell;
            }
        }

        panels[0][0].add(new JLabel());
        panels[0][1].add(label("A"));
        panels[0][2].add(label("B"));
        panels[0][3].add(label("C"));
        panels[0][4].add(label("D"));
        panels[0][5].add(label("E"));
        panels[0][6].add(label("F"));
        panels[0][7].add(label("G"));
        panels[0][8].add(label("H"));
        panels[0][9].add(label("I"));
        panels[0][10].add(label("J"));

        for(int i = 1; i < SIDES; i++) {
            panels[i][0].add(label(String.valueOf(i)));
        }

        for(JPanel[] i : panels) {
            for(JPanel j : i) {
                main.add(j);
            }
        }

        this.add(main);
    }

    private JLabel label(String t) {
        JLabel p = new JLabel(t);
        p.setFont(new Font("Verdana", Font.BOLD, 18));
        p.setForeground(Color.DARK_GRAY);
        return p;
    }

    public void processClick(){

    }

    @Override
    public void update(Observable o, Object arg) {
    }


    @Override
    protected void paintComponent(Graphics g) {
    }

}

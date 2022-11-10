import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer {
    Square[][] squares;
    JPanel main;
    ArrayList<Square> areClicked;
    private static final int SIDES = 11;
    private static final int SIDE_LENGTH = 34;
    private static final int GAP = 2;
    private static final Color BG = Color.GRAY;
    private static final Color CELL_COLOR = new Color(191,230,255);
    private BlackBoard bb;

    public BoardPanel(){
        bb = BlackBoard.getInstance();
        bb.addObserver(this);
        refreshMainPanel(null, null);
        this.setBackground(BG);
    }

    void refreshMainPanel(Square[][] sqr, ArrayList<ArrayList<Square>> ships) {
        this.squares = new Square[SIDES][SIDES];
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
                if(sqr != null && ships != null) {
                    cell = sqr[i][j];
                    cell.colorSquare(CELL_COLOR);
                } else {
                    cell = new Square(i,j,c,this);
                    cell.setBackground(CELL_COLOR);
                }
                cell.setPreferredSize(prefSize);
                squares[i][j] = cell;
            }
        }

        squares[0][0].add(new JLabel(": )"));
        squares[0][1].add(label("A"));
        squares[0][2].add(label("B"));
        squares[0][3].add(label("C"));
        squares[0][4].add(label("D"));
        squares[0][5].add(label("E"));
        squares[0][6].add(label("F"));
        squares[0][7].add(label("G"));
        squares[0][8].add(label("H"));
        squares[0][9].add(label("I"));
        squares[0][10].add(label("J"));

        for(int i = 1; i < SIDES; i++) {
            squares[i][0].add(label(String.valueOf(i)));
        }

        for(JPanel[] i : squares) {
            for(JPanel j : i) {
                main.add(j);
            }
        }

        this.add(main);
        validate();
    }

    void endGameScreen(boolean didWin) {
        squares = null;
        main = new JPanel();
        main.setBackground(BG);
        main.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        main.setLayout(new GridLayout(SIDES, SIDES, GAP, GAP));
        JPanel end = new JPanel();
        JLabel l;
        if(didWin) {
            l = new JLabel("YOU WON!");
        } else {
            l = new JLabel("YOU LOST!");
        }
        l.setFont(new Font("Verdana", Font.BOLD, 70));
        end.add(l);
        main.add(end);
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

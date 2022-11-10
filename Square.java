import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Square extends JPanel implements MouseListener{
    private int x;
    private int y;
    private boolean clickable;
    private boolean isClicked;
    private JLabel status;
    private BoardPanel bp;

    public Square(int x, int y, boolean c, BoardPanel boardPanel) {
        this.x = x;
        this.y = y;
        this.clickable = c;
        this.isClicked = false;
        this.status = new JLabel("");
        this.status.setForeground(Color.RED);
        this.status.setFont(new Font("Verdana", Font.BOLD, 18));
        this.bp = boardPanel;
        this.add(status);
        this.addMouseListener(this);
    }

    // Squares created by deserializing BlackBoard tables
    public Square(int x, int y, boolean clickable, boolean isClicked, BoardPanel bp) {
        this.x = x;
        this.y = y;
        this.status = new JLabel("");

        if(bp instanceof BoardPanelB) {
            this.clickable = clickable;
            this.isClicked  = isClicked;
            this.bp = bp;
            if(isShip()) {
                this.setBackground(Color.BLACK);
                if(isClicked) {
                    this.status = new JLabel("X");
                    this.status.setForeground(Color.RED);
                }
            } else if(isClicked) {
                this.status = new JLabel("O");
                this.status.setForeground(Color.BLUE);
            }

            this.status.setFont(new Font("Verdana", Font.BOLD, 20));
            this.add(status);
            this.addMouseListener(this);
        }
    }

    public int getRow() {
        return x;
    }

    public int getCol() {
        return y;
    }

    public void colorSquare(Color c) {
        if(isShip()) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(c);
        }
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClicked() {
        return isClicked;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ((BoardPanelA)bp).initEnemyShips();
        if(clickable) {
            this.isClicked = true;
            this.clickable = false;
            if(hitShip()) {
                this.status.setText("X");
                this.status.setForeground(Color.RED);
            } else {
                this.status.setText("O");
                this.status.setForeground(Color.BLUE);
            }
            bp.processClick();
            Color c = new Color(191,230,255);
            this.setBackground(c);
        }
    }

    public boolean isShip() {
        for(ArrayList<Square> ships : ((BoardPanelB)bp).ships) {
            for(Square sqr : ships) {
                if(this.x == sqr.getRow() && this.y == sqr.getCol()) return true;
            }
        }
        return false;
    }

    public boolean hitShip() {
        for(ArrayList<Square> ships : ((BoardPanelA)bp).enemyShips) {
            for(Square sqr : ships) {
                if(this.x == sqr.getRow() && this.y == sqr.getCol()) {
                    ((BoardPanelA)bp).numShipsHit++;
                    System.out.println("in square : " + ((BoardPanelA)bp).numShipsHit);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.x + "," + this.y + "," + this.isClicked + "," + this.clickable + "/");
        return sb.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(clickable){
            Color c = new Color(216, 237, 255);
            this.setBackground(c);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(clickable){
            Color c = new Color(191,230,255);
            this.setBackground(c);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
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

    public Square(int x, int y, boolean clickable, boolean isClicked, BoardPanel bp) {
        this.x = x;
        this.y = y;
        if(bp instanceof BoardPanelB) {
            System.out.println(bp.getClass());
            System.out.println("SHIPS===============");
            for(ArrayList<Square> ship : ((BoardPanelB)bp).ships) {
                for(Square sqr : ship) {
                    System.out.println(sqr);
                }
            }
            this.clickable = clickable;
            this.isClicked  = isClicked;
            this.bp = bp;
            if(isClicked && isShip()) {
                this.status = new JLabel("X");
                this.status.setForeground(Color.RED);
            }
            else if(isClicked) {
                this.status = new JLabel("O");
                this.status.setForeground(Color.BLUE);
            }
            else {
                this.status = new JLabel("");
            }
            if(isShip()) {
                this.setBackground(Color.BLACK);
            }
            this.status.setFont(new Font("Verdana", Font.BOLD, 18));
            this.add(status);
            this.addMouseListener(this);
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

    @Override
    public void mousePressed(MouseEvent e) {
        if(clickable) {
            this.isClicked = true;
            this.clickable = false;
            bp.processClick();
            if(hitShip()) {
                this.status.setText("X");
                this.status.setForeground(Color.RED);
            } else {
                this.status.setText("O");
                this.status.setForeground(Color.BLUE);
            }
        }
    }

    public boolean hitShip() {
        for(ArrayList<Square> ships : ((BoardPanelA)bp).enemyShips) {
            for(Square sqr : ships) {
                if(this.x == sqr.getRow() && this.y == sqr.getCol()) return true;
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

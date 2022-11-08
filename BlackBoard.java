import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class BlackBoard extends Observable {
    private static BlackBoard instance;
    private Observer observer;
    private String table1;
    private String table2;

    public BlackBoard() {
        table1 = "";
        table2 = "";
    }
    public static BlackBoard getInstance() {
        if(instance == null) instance = new BlackBoard();
        return instance;
    }

    public void updateTable1(String t) {
        if(!table1.equals(t)) {
            table1 = t;
            notifying();
        }
    }

    public void updateTable2(String t) {
        if(!table2.equals(t)) {
            table2 = t;
            notifying();
        }
    }

    public String getTable1() {
        return table1;
    }
    public String getTable2() {
        return table2;
    }

    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    public void notifying() {
        observer.update(this, this);
    }

    
    
}

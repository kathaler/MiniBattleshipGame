import java.util.Observable;
import java.util.Observer;

public class BlackBoard extends Observable {
    private static BlackBoard instance;
    private Observer observer;

    public BlackBoard() {
    }
    public static BlackBoard getInstance() {
        if(instance == null) instance = new BlackBoard();
        return instance;
    }

    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    public void notifying() {
        observer.update(this, this);
    }
    
    
    
}

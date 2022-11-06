import java.util.Observable;

public class BlackBoard extends Observable {
    private static BlackBoard instance;

    public BlackBoard() {

    }
    public static BlackBoard getInstance() {
        if(instance == null) instance = new BlackBoard();
        return instance;
    }
}

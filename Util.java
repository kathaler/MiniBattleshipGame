import java.util.ArrayList;

public class Util {
    public static String serialize(Square[][] sqr) {
        StringBuilder str = new StringBuilder();

        for(Square[] s: sqr) {
            for(Square sq : s) {
                str.append(sq);
            }
        }
        return str.toString();
    }

    public static Square[][] deserialize(String str, BoardPanelB bp) {
        Square[][] squares = new Square[11][11];
        String[] sq = str.split("/");
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                String[] curr = sq[i*11 + j].split(",");
                squares[i][j] = new Square(Integer.parseInt(curr[0]), Integer.parseInt(curr[1]),
                        false, Boolean.parseBoolean(curr[2]), bp);
            }
        }
        return squares;
    }

    public static String serializeShips(ArrayList<ArrayList<Square>> ships) {
        StringBuilder str = new StringBuilder();
        for(ArrayList<Square> ship : ships) {
            for(Square sqr : ship) {
                str.append(sqr);
            }
            str.append("~");
        }
        return str.toString();
    }

    public static ArrayList<ArrayList<Square>> deserializeShips(String str, BoardPanel bp) {
        ArrayList<ArrayList<Square>> enemyShips = new ArrayList<>();
        String[] sq = str.split("~");
        for(int i = 0; i < sq.length; i++) {
            ArrayList<Square> ship = new ArrayList<>();
            String[] vals = sq[i].split("/");
            for(int j = 0; j < vals.length; j++) {
                String[] curr = vals[j].split(",");
                ship.add(new Square(Integer.parseInt(curr[0]), Integer.parseInt(curr[1]),
                        false, Boolean.parseBoolean(curr[2]), bp));
            }
            enemyShips.add(ship);
        }
        return enemyShips;
    }
}

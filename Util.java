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
}

import java.util.HashMap;
import java.util.Map;
import startypes.*;

public class StarFactory {
    private Map<Character, StarType> starCache = new HashMap<>();

    public StarType getStarType(char type, int x, int y) {
        if (!starCache.containsKey(type)) {
            switch (type) {
                case 'O':
                    starCache.put(type, new OStar(x, y));
                    break;
                case 'A':
                    starCache.put(type, new AStar(x, y));
                    break;
                case 'B':
                    starCache.put(type, new BStar(x, y));
                    break;
                case 'F':
                    starCache.put(type, new FStar(x, y));
                    break;
                case 'G':
                    starCache.put(type, new GStar(x, y));
                    break;
                case 'K':
                    starCache.put(type, new KStar(x, y));
                    break;
                case 'M':
                    starCache.put(type, new MStar(x, y));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown star type: " + type);
            }
        }
        return starCache.get(type);
    }
}

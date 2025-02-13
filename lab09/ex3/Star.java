import startypes.StarType;
import java.awt.Graphics;

public class Star {
    private int x, y;
    private StarType type;

    public Star(int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics graphics) {
        type.draw(graphics);
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import startypes.StarType;

public class Sky extends JFrame {
    private List<Star> stars = new ArrayList<>();

    public void placeStar(int x, int y, StarType starType) {
        stars.add(new Star(x, y, starType));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (Star star : stars) {
            star.draw(graphics);
        }
    }
}

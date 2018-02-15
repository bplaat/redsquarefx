import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Square extends Rectangle {
    private int dx, dy;

    Square (int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height);
        setFill(Color.rgb(0, 0, 255, 0.8));
        this.dx = dx;
        this.dy = dy;
    }

    public void move () {
        if (getX() < 0 || getX() + getWidth() > 640) dx = -dx;
        setX(getX() + dx);
        if (getY() < 0 || getY() + getHeight() > 480) dy = -dy;
        setY(getY() + dy);
    }
}
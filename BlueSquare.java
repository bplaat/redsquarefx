import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BlueSquare extends Rectangle {
    private int dx, dy;

    BlueSquare (int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height);
        setFill(Color.rgb(0, 0, 255, 0.8));
        this.dx = dx;
        this.dy = dy;
    }

    public void move (int level) {
        if (getX() < 0 || getX() + getWidth() > 640) dx = -dx;
        setX(getX() + dx * level);
        if (getY() < 0 || getY() + getHeight() > 480) dy = -dy;
        setY(getY() + dy * level);
    }

    public boolean collision (RedSquare red) {
        return red.getX() < getX() + getWidth() && red.getX() + red.getWidth() > getX() &&
            red.getY() < getY() + getHeight() && red.getY() + red.getHeight() > getY();
    }
}
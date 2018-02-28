import javafx.scene.shape.Rectangle;

public class BlueSquare extends Rectangle {
    private int dx, dy;

    BlueSquare (int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height);
        getStyleClass().add("blue");
        this.dx = dx;
        this.dy = dy;
    }

    public void move (int speed) {
        if (getX() < 0 || getX() + getWidth() > 640) dx = -dx;
        setX(getX() + dx * speed);
        if (getY() < 0 || getY() + getHeight() > 480) dy = -dy;
        setY(getY() + dy * speed);
    }

    public boolean collision (Rectangle other) {
        return other.getX() < getX() + getWidth() && other.getX() + other.getWidth() > getX() &&
        other.getY() < getY() + getHeight() && other.getY() + other.getHeight() > getY();
    }
}
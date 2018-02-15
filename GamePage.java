import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GamePage extends Pane {
    GamePage () {
        setStyle("-fx-background-color: #29f;");
        getChildren().add(Factory.getButton("Back", Page.HOME, 10, 1 * 10 + 0 * 50, 200, 50));

        Square square1, square2, square3, square4;
        getChildren().add(square1 = new Square(150, 150, 75, 100, 2, 2));
        getChildren().add(square2 = new Square(300, 150, 150, 75, -2, 2));
        getChildren().add(square3 = new Square(150, 300, 75, 150, 2, -2));
        getChildren().add(square4 = new Square(300, 300, 100, 150, -2, -2));

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                square1.move();
                square2.move();
                square3.move();
                square4.move();
            }
        };
        timer.start();
    }
}
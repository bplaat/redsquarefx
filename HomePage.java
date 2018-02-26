import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class HomePage extends Pane {
    private BlueSquare blue1, blue2, blue3, blue4;

    HomePage () {
        getChildren().addAll(
            blue1 = new BlueSquare(0, 0, 75, 100, 1, 1),
            blue2 = new BlueSquare(640 - 150, 0, 150, 75, -1, 1),
            blue3 = new BlueSquare(0, 480 - 150, 75, 150, 1, -1),
            blue4 = new BlueSquare(640 - 100, 480 - 150, 100, 150, -1, -1),

            Factory.getLabel("RedSquareFX", 15, 10, "title"),
            Factory.getLabel("Version 1.0", 15, 60),
            Factory.getLabel("Made by Bastiaan van der Plaat", 15, 440),
            Factory.getButton("Play", Page.GAME, 430, 10, 200, 50),
            Factory.getButton("High Score", Page.HIGHSCORE, 430, 70, 200, 50),
            Factory.getButton("Settings", Page.SETTINGS, 430, 130, 200, 50),
            Factory.getButton("Help", Page.HELP, 430, 190, 200, 50),
            Factory.getButton("Credits", Page.CREDITS, 430, 250, 200, 50),
            Factory.getButton("Exit", Page.EXIT, 430, 420, 200, 50)
        );
        AnimationTimer timer = new AnimationTimer() {
            public void handle (long now) {
                blue1.move(2);
                blue2.move(2);
                blue3.move(2);
                blue4.move(2);
            }
        };
        timer.start();
    }
}
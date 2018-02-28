import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePage extends Pane {
    private BlueSquare blue1, blue2, blue3, blue4;

    HomePage () {
        AnchorPane container = new AnchorPane();
        container.setPrefSize(640, 480);

        VBox topleft = new VBox(10, Factory.getTitle("RedSquareFX"), Factory.getSubTitle("Version 1.0"));
        AnchorPane.setTopAnchor(topleft, 20d);
        AnchorPane.setLeftAnchor(topleft, 20d);

        VBox topright = new VBox(10,
            Factory.getButton("Play", Page.GAME),
            Factory.getButton("High Score", Page.HIGHSCORE),
            Factory.getButton("Settings", Page.SETTINGS),
            Factory.getButton("Help", Page.HELP),
            Factory.getButton("Credits", Page.CREDITS)
        );
        AnchorPane.setTopAnchor(topright, 20d);
        AnchorPane.setRightAnchor(topright, 20d);

        VBox bottomleft = new VBox(10, Factory.getLabel("Made by Bastiaan van der Plaat"));
        AnchorPane.setLeftAnchor(bottomleft, 20d);
        AnchorPane.setBottomAnchor(bottomleft, 20d);

        VBox bottomright = new VBox(10, Factory.getButton("Exit", Page.EXIT));
        AnchorPane.setRightAnchor(bottomright, 20d);
        AnchorPane.setBottomAnchor(bottomright, 20d);

        container.getChildren().addAll(topleft, topright, bottomleft, bottomright);

        getChildren().addAll(
            blue1 = new BlueSquare(0, 0, 75, 100, 1, 1),
            blue2 = new BlueSquare(640 - 150, 0, 150, 75, -1, 1),
            blue3 = new BlueSquare(0, 480 - 150, 75, 150, 1, -1),
            blue4 = new BlueSquare(640 - 100, 480 - 150, 100, 150, -1, -1),
            container
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
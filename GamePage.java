import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GamePage extends Pane {
    private Date startTime, levelTime;
    private int score = 0, level = 1;

    GamePage () {
        setStyle("-fx-background-color: #29f;");

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        Label scoreLabel = Factory.getLabel("Score: " + score, 24, 10, 10);
        getChildren().add(scoreLabel);

        Label timeLabel = Factory.getLabel("Time: " + formatter.format(0), 24, 200, 10);
        getChildren().add(timeLabel);

        Label levelLabel = Factory.getLabel("Level: " + level, 24, 400, 10);
        getChildren().add(levelLabel);

        getChildren().add(Factory.getButton("Back", Page.HOME, 10, 420, 200, 50));

        RedSquare red = new RedSquare((640 - 75) / 2, (480 - 75) / 2, 75, 75);
        BlueSquare blue1 = new BlueSquare(0, 0, 75, 100, 1, 1);
        BlueSquare blue2 = new BlueSquare(640 - 150, 0, 150, 75, -1, 1);
        BlueSquare blue3 = new BlueSquare(0, 480 - 150, 75, 150, 1, -1);
        BlueSquare blue4 = new BlueSquare(640 - 100, 480 - 150, 100, 150, -1, -1);
        getChildren().addAll(red, blue1, blue2, blue3, blue4);

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                blue1.move();
                blue2.move();
                blue3.move();
                blue4.move();

                score += level;
                scoreLabel.setText("Score: " + score);

                Date current = new Date();
                timeLabel.setText(formatter.format(current.getTime() - startTime.getTime()));

                if ((current.getTime() - levelTime.getTime()) > 5 * 1000) {
                    levelTime = new Date();
                    levelLabel.setText("Level: " + ++level);
                    blue1.setStep(level);
                    blue2.setStep(level);
                    blue3.setStep(level);
                    blue4.setStep(level);
                }
            }
        };

        startTime = levelTime = new Date();
        timer.start();
    }
}
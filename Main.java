import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start (Stage primaryStage) {
        primaryStage.setTitle("RedSquare");
        primaryStage.setScene(Navigator.getScene());
        primaryStage.show();
    }
}
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start (Stage stage) {
        stage.setTitle("RedSquareFX");
        stage.setScene(Navigator.getScene());
        stage.show();


        System.out.println(Cloud.get("https://service.plaatsoft.nl/"));
    }
}
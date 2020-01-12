package StorageSystem;

import StorageSystem.DataAccessObjects.DAObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        DAObject<Integer, Long> daObject = new DAObject<>();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Система управления складом");
        primaryStage.setScene(new Scene(root, 850, 850));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package LibraryManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/books.fxml"));
        Scene scene = new Scene(root, 1000, 700);

        stage.setResizable(false);
        stage.setTitle("Library Manager");
        stage.setScene(scene);
        stage.show();
    }
}

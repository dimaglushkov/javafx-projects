package StorageSystem.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Label btnStats;


    public void openStats(MouseEvent event){
        Stage stage = (Stage) btnStats.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/stats.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openProducts(MouseEvent event) {
        Stage stage = (Stage) btnStats.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/products.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

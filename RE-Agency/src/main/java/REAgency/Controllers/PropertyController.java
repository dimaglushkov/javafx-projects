package REAgency.Controllers;

import REAgency.Converter;
import REAgency.Entity.Manager;
import REAgency.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PropertyController implements Initializable {

    @FXML
    private Label infoLabel;


    public void add(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/propertyAdd.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(MouseEvent event){
        System.out.print("delete()");
    }

    public void show(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/propertyShow.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void back(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/main.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Manager manager = Session.INSTANCE.getManager();
        infoLabel.setText(manager.getName() + " " + manager.getSurname() +
                ", id: " + manager.getId());
    }
}

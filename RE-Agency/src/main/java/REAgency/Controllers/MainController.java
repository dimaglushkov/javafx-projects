package REAgency.Controllers;

import REAgency.Converter;
import REAgency.Entity.Manager;
import REAgency.Session;
import javafx.event.ActionEvent;
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


public class MainController implements Initializable {

    @FXML
    private Label propertyLabel;
    @FXML
    private Label exchangeLabel;
    @FXML
    private Label statsLabel;
    @FXML
    private Label infoLabel;


    public void property(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/property.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exchange(MouseEvent event){
        System.out.print("exchange()");
    }

    public void stats(MouseEvent event){
        System.out.print("stats()");
    }

    public void back(MouseEvent event){
        Session.INSTANCE.finish();
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/login.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Manager manager = Session.INSTANCE.getManager();
        infoLabel.setText(manager.getName() + " " + manager.getSurname() + ", id: " + manager.getId());
    }
}

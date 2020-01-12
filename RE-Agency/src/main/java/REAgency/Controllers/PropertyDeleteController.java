package REAgency.Controllers;

import REAgency.DAO.DAOService;
import REAgency.Entity.House;
import REAgency.Entity.Manager;
import REAgency.Entity.Property;
import REAgency.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PropertyDeleteController implements Initializable {

    @FXML
    private Label infoLabel;
    @FXML
    private TextField idInput;
    @FXML
    private Label errorLabel;
    @FXML
    private Label successLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Manager manager = Session.INSTANCE.getManager();
        infoLabel.setText(manager.getName() + " " + manager.getSurname() + ", id: " + manager.getId());
    }

    public void back(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/property.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(MouseEvent event) {
        DAOService<Property, Long> daoService = new DAOService<>(Property.class);

        successLabel.setVisible(false);
        if (idInput.getText().isEmpty() || idInput.getText() == null) {
            errorLabel.setVisible(true);
            return;
        } else
            errorLabel.setVisible(false);

        Long id = Long.parseLong(idInput.getText());

        try {
            daoService.delete(daoService.findById(id));
        } catch (Exception e) {
            errorLabel.setVisible(true);
            return;
        }
        errorLabel.setVisible(false);
        successLabel.setVisible(true);

    }
}

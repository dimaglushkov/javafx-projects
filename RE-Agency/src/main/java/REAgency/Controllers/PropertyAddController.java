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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PropertyAddController implements Initializable {

    @FXML
    private Label infoLabel;
    @FXML
    private ComboBox<String> houseBox;
    @FXML
    private TextField areaInput;
    @FXML
    private TextField floorInput;
    @FXML
    private TextField apartmentsInput;
    @FXML
    private TextField numOfRoomsInput;
    @FXML
    private CheckBox hasBathCheckBox;
    @FXML
    private CheckBox hasBalconyCheckBox;
    @FXML
    private Label errorLabel;
    @FXML
    private Label successLabel;

    private DAOService<House, Long> daoService = new DAOService<>(House.class);
    private List<House> houses;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Manager manager = Session.INSTANCE.getManager();
        infoLabel.setText(manager.getName() + " " + manager.getSurname() + ", id: " + manager.getId());
        List<String> addresses = new ArrayList<>();;
        houses = daoService.findAll();
        for (House house : houses)
            addresses.add(house.getId() + ". Улица" + house.getStreet() + ", дом " + house.getNum());

        ObservableList<String> list = FXCollections.observableArrayList(addresses);
        houseBox.setItems(list);
        houseBox.setValue(list.get(0));
    }

    public void back(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/property.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(MouseEvent event) {
        successLabel.setVisible(false);
        if (!validateInput()) {
            errorLabel.setVisible(true);
            return;
        }
        else
            errorLabel.setVisible(false);


        Property property = new Property();
        property.setApartments(Integer.parseInt(apartmentsInput.getText()));
        property.setArea(Integer.parseInt(areaInput.getText()));
        property.setNumOfRooms(Integer.parseInt(numOfRoomsInput.getText()));
        property.setFloor(Integer.parseInt(floorInput.getText()));
        property.setHouse(houses.get(Integer.parseInt(String.valueOf(houseBox.getValue().charAt(0)))-1));
        if (hasBalconyCheckBox.isSelected())
            property.setHasBalcony("Y");
        else
            property.setHasBalcony("N");

        if (hasBathCheckBox.isSelected())
            property.setHasBath("Y");
        else
            property.setHasBath("N");

        DAOService<Property, Long> propertyDAOService = new DAOService<>(Property.class);
        propertyDAOService.create(property);

        successLabel.setVisible(true);

    }

    private boolean validateInput(){
        if (areaInput.getText() == null || areaInput.getText().isEmpty()
                        || floorInput.getText() == null || floorInput.getText().isEmpty()
                        || apartmentsInput.getText() == null || apartmentsInput.getText().isEmpty()
                        || numOfRoomsInput.getText() == null || numOfRoomsInput.getText().isEmpty())
            return false;

        try
        {
            int d = Integer.parseInt(areaInput.getText());
            d = Integer.parseInt(floorInput.getText());
            d = Integer.parseInt(apartmentsInput.getText());
            d = Integer.parseInt(numOfRoomsInput.getText());
        }
        catch (Exception e){
            return false;
        }

        return true;

    }
}

package StorageSystem.FXMLControllers;

import StorageSystem.DataAccessObjects.DAObject;
import StorageSystem.DataAccessObjects.ProductDAO;
import StorageSystem.Entities.Product;
import StorageSystem.Entities.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private Label infoLabel;
    @FXML
    private TextField vendorCodeValue;
    @FXML
    private TextField categoryValue;
    @FXML
    private TextField descriptionValue;
    @FXML
    private TextField priceValue;
    @FXML
    private TextField manufacturerValue;
    @FXML
    private TextField numberValue;
    @FXML
    private ComboBox<String> locationBox;
    @FXML
    private Label textError;
    @FXML
    private Label textSuccess;


    private ProductDAO productDAO = new ProductDAO();
    private List<Storage> storages;


    public void addProducts(ActionEvent event) {
        textSuccess.setVisible(false);
        textSuccess.setManaged(false);
        if (vendorCodeValue.getText().isEmpty() || vendorCodeValue == null
                || categoryValue.getText().isEmpty() || categoryValue == null
                || descriptionValue.getText().isEmpty() || descriptionValue == null
                || priceValue.getText().isEmpty() || priceValue == null
                || manufacturerValue.getText().isEmpty() || manufacturerValue == null
                || numberValue.getText().isEmpty() || numberValue == null
                || Integer.parseInt(numberValue.getText()) < 0
                || Integer.parseInt(priceValue.getText()) < 0)
        {
            textError.setVisible(true);
            return;
        }
        else {
            textError.setVisible(false);
            textError.setManaged(false);
        }

        int num = Integer.parseInt(numberValue.getText());

        Storage storage = storages.get(Integer.parseInt(String.valueOf(locationBox.getValue().charAt(0)))-1);


        for (int i = 0; i < num; i++) {
            Product product = new Product();
            product.setVendorCode(vendorCodeValue.getText());
            product.setDescription(descriptionValue.getText());
            product.setCategory(categoryValue.getText());
            product.setManufacturer(manufacturerValue.getText());
            product.setPrice(Integer.parseInt(priceValue.getText()));
            product.setLocation(storage);
            product.setReceivedTime(new Timestamp(System.currentTimeMillis()));
            productDAO.create(product);
        }
        textSuccess.setVisible(true);
        textSuccess.setManaged(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DAObject<Storage, Integer> daObject = new DAObject<>(Storage.class);
        storages = daObject.findAll();
        List<String> addresses = new ArrayList<>();;



        for (Storage storage : storages){
            addresses.add(storage.getId() + ". " + storage.getStreet() + ", " + storage.getBuilding());
        }
        ObservableList<String> list = FXCollections.observableArrayList(addresses);
        locationBox.setItems(list);
        locationBox.setValue(list.get(0));
    }

    public void mainMenu(ActionEvent event) {
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/main.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

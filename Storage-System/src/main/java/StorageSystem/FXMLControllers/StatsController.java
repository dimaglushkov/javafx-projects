package StorageSystem.FXMLControllers;

import StorageSystem.DataAccessObjects.ProductDAO;
import StorageSystem.Entities.Product;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

public class StatsController implements Initializable {

    @FXML
    private Label statsLabel;

    @FXML
    private ComboBox<String> criteriaBox;

    @FXML
    private TextField criteriaValue;

    @FXML
    private TableView<Data> statsTable;

    private int numSum, numSold;

    ProductDAO productDAO = new ProductDAO();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> list = FXCollections.observableArrayList("Все", "Артикул", "Категория", "Описание", "Производитель", "Номер склада");
        criteriaBox.setItems(list);

        TableColumn<Data, Integer> col1 = new TableColumn<>("id");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Data, String> col2 = new TableColumn<>("Артикул");
        col2.setCellValueFactory(new PropertyValueFactory<>("vendorCode"));

        TableColumn<Data, String> col3 = new TableColumn<>("Призводитель");
        col3.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

        TableColumn<Data, String> col4 = new TableColumn<>("Категория");
        col4.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Data, Integer> col5 = new TableColumn<>("Номер склада");
        col5.setCellValueFactory(new PropertyValueFactory<>("locationStorage"));

        TableColumn<Data, String> col6 = new TableColumn<>("Адрес склада");
        col6.setCellValueFactory(new PropertyValueFactory<>("locationAddress"));

        TableColumn<Data, Integer> col7 = new TableColumn<>("Цена");
        col7.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Data, String> col8 = new TableColumn<>("Время прибытия");
        col8.setCellValueFactory(new PropertyValueFactory<>("receivedTime"));

        TableColumn<Data, String> col9 = new TableColumn<>("Время продажи");
        col9.setCellValueFactory(new PropertyValueFactory<>("soldTime"));


        statsTable.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);
        updateTable();
    }

    private void updateTable(){
        ObservableList<Data> data = FXCollections.observableArrayList();
        List<Product> products;
        if (criteriaBox.getValue() == null)
            products = productDAO.findAll();
        else
            switch (criteriaBox.getValue()){
                case "Артикул":
                    products = productDAO.findByVendorCode(criteriaValue.getText());
                    break;

                case "Категория":
                    products =  productDAO.findByCategory(criteriaValue.getText());
                    break;

                case "Описание":
                    products =  productDAO.findByDescription(criteriaValue.getText());
                    break;

                case "Производитель":
                    products =  productDAO.findByManufacturer(criteriaValue.getText());
                    break;

                case "Номер склада":
                    products = productDAO.findByLocation(criteriaValue.getText());
                    break;

                default:
                    products = productDAO.findAll();
            }

        numSold = numSum = 0;

        for( Product product: products) {
            Data toAdd = new Data(product);
            data.add(toAdd);
            numSum++;
            numSold += toAdd.isSold;
        }

        statsLabel.setText("Всего товаров: " + numSum + " (из них на складах: " + (numSum - numSold) + ")" );
        statsTable.setItems(data);
    }

    public void getStats(ActionEvent event){
        updateTable();
    }

    public void mainMenu(ActionEvent event) {
        Stage stage = (Stage) statsLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/main.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Data {

        private SimpleIntegerProperty id;
        private SimpleStringProperty vendorCode;
        private SimpleStringProperty category;
        private SimpleStringProperty description;
        private SimpleStringProperty manufacturer;
        private SimpleIntegerProperty locationStorage;
        private SimpleStringProperty locationAddress;
        private SimpleIntegerProperty price;
        private SimpleStringProperty receivedTime;
        private SimpleStringProperty soldTime;
        public int isSold;

        public Data() {
        }

        public Data(Product product) {
            this.id = new SimpleIntegerProperty(product.getId());
            this.vendorCode = new SimpleStringProperty(product.getVendorCode());
            this.category = new SimpleStringProperty(product.getCategory());
            this.description = new SimpleStringProperty(product.getDescription());
            this.manufacturer = new SimpleStringProperty(product.getManufacturer());
            this.locationStorage = new SimpleIntegerProperty(product.getLocation().getId());
            this.locationAddress = new SimpleStringProperty(product.getLocation().getStreet() + ", " + product.getLocation().getBuilding());
            this.price = new SimpleIntegerProperty(product.getPrice());
            this.receivedTime = new SimpleStringProperty(product.getReceivedTime().toString());
            if (product.getSoldTime() != null) {
                this.soldTime = new SimpleStringProperty(product.getSoldTime().toString());
                isSold = 1;
            }
            else {
                this.soldTime = new SimpleStringProperty("На складе");
                isSold = 0;
            }
        }

        public int getId() {
            return id.get();
        }

        public SimpleIntegerProperty idProperty() {
            return id;
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public String getVendorCode() {
            return vendorCode.get();
        }

        public SimpleStringProperty vendorCodeProperty() {
            return vendorCode;
        }

        public void setVendorCode(String vendorCode) {
            this.vendorCode.set(vendorCode);
        }

        public String getCategory() {
            return category.get();
        }

        public SimpleStringProperty categoryProperty() {
            return category;
        }

        public void setCategory(String category) {
            this.category.set(category);
        }

        public String getDescription() {
            return description.get();
        }

        public SimpleStringProperty descriptionProperty() {
            return description;
        }

        public void setDescription(String description) {
            this.description.set(description);
        }

        public String getManufacturer() {
            return manufacturer.get();
        }

        public SimpleStringProperty manufacturerProperty() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer.set(manufacturer);
        }

        public int getLocationStorage() {
            return locationStorage.get();
        }

        public SimpleIntegerProperty locationStorageProperty() {
            return locationStorage;
        }

        public void setLocationStorage(int locationStorage) {
            this.locationStorage.set(locationStorage);
        }

        public String getLocationAddress() {
            return locationAddress.get();
        }

        public SimpleStringProperty locationAddressProperty() {
            return locationAddress;
        }

        public void setLocationAddress(String locationAddress) {
            this.locationAddress.set(locationAddress);
        }

        public int getPrice() {
            return price.get();
        }

        public SimpleIntegerProperty priceProperty() {
            return price;
        }

        public void setPrice(int price) {
            this.price.set(price);
        }

        public String getReceivedTime() {
            return receivedTime.get();
        }

        public SimpleStringProperty receivedTimeProperty() {
            return receivedTime;
        }

        public void setReceivedTime(String receivedTime) {
            this.receivedTime.set(receivedTime);
        }

        public String getSoldTime() {
            return soldTime.get();
        }

        public SimpleStringProperty soldTimeProperty() {
            return soldTime;
        }

        public void setSoldTime(String soldTime) {
            this.soldTime.set(soldTime);
        }
    }
}

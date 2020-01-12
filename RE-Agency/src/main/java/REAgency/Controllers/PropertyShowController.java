package REAgency.Controllers;

import REAgency.DAO.DAOService;
import REAgency.Entity.Manager;
import REAgency.Entity.Property;
import REAgency.Session;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PropertyShowController implements Initializable {

    @FXML
    private Label infoLabel;

    @FXML
    private TableView<Data> propertyTable;

    private DAOService<Property, Long> daoService = new DAOService<>(Property.class);

    public void back(MouseEvent event){
        Stage stage = (Stage) infoLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/property.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Property> properties = daoService.findAll();

        TableColumn<Data, Long> idCol = new TableColumn<>("id");
        idCol.setPrefWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Data, String> houseDistrictCol = new TableColumn<>("Район");
        houseDistrictCol.setPrefWidth(250);
        houseDistrictCol.setCellValueFactory(new PropertyValueFactory<>("houseDistrict"));

        TableColumn<Data, String> houseStreetCol = new TableColumn<>("Улица");
        houseStreetCol.setPrefWidth(200);
        houseStreetCol.setCellValueFactory(new PropertyValueFactory<>("houseStreet"));

        TableColumn<Data, Integer> houseNumCol = new TableColumn<>("Номер дома");
        houseNumCol.setPrefWidth(50);
        houseNumCol.setCellValueFactory(new PropertyValueFactory<>("houseNum"));

        TableColumn<Data, Integer> apartmentsCol = new TableColumn<>("Номер квартиры");
        houseNumCol.setPrefWidth(100);
        apartmentsCol.setCellValueFactory(new PropertyValueFactory<>("apartments"));

        TableColumn<Data, Integer> areaCol = new TableColumn<>("Площадь");
        areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));

        TableColumn<Data, String> hasBathCol = new TableColumn<>("Ванная");
        hasBathCol.setCellValueFactory(new PropertyValueFactory<>("hasBath"));

        TableColumn<Data, String> hasBalconyCol = new TableColumn<>("Балкон");
        hasBalconyCol.setCellValueFactory(new PropertyValueFactory<>("hasBalcony"));

        ObservableList<Data> data = FXCollections.observableArrayList();

        for( Property property: properties)
            data.add(new Data(property));

        propertyTable.getColumns().addAll(idCol,
                houseDistrictCol,
                houseStreetCol,
                houseNumCol,
                apartmentsCol,
                areaCol,
                hasBathCol,
                hasBalconyCol);
        propertyTable.setItems(data);



        Manager manager = Session.INSTANCE.getManager();
        infoLabel.setText(manager.getName() + " " + manager.getSurname() + ", id: " + manager.getId());
    }

    public static class Data {

        private SimpleLongProperty id;
        private SimpleStringProperty houseDistrict;
        private SimpleStringProperty houseStreet;
        private SimpleIntegerProperty houseNum;
        private SimpleIntegerProperty apartments;
        private SimpleIntegerProperty area;
        private SimpleStringProperty hasBath;
        private SimpleStringProperty hasBalcony;

        public Data(Property property) {
            this.id = new SimpleLongProperty(property.getId());
            this.houseDistrict = new SimpleStringProperty(property.getHouse().getDistrict());
            this.houseStreet = new SimpleStringProperty(property.getHouse().getStreet());
            this.houseNum = new SimpleIntegerProperty(property.getHouse().getNum());
            this.apartments = new SimpleIntegerProperty(property.getApartments());
            this.area = new SimpleIntegerProperty(property.getArea());
            this.hasBath = new SimpleStringProperty(property.getHasBalcony());
            this.hasBalcony = new SimpleStringProperty(property.getHasBalcony());
        }

        public long getId() {
            return id.get();
        }

        public SimpleLongProperty idProperty() {
            return id;
        }

        public void setId(long id) {
            this.id.set(id);
        }

        public String getHouseDistrict() {
            return houseDistrict.get();
        }

        public SimpleStringProperty houseDistrictProperty() {
            return houseDistrict;
        }

        public void setHouseDistrict(String houseDistrict) {
            this.houseDistrict.set(houseDistrict);
        }

        public String getHouseStreet() {
            return houseStreet.get();
        }

        public SimpleStringProperty houseStreetProperty() {
            return houseStreet;
        }

        public void setHouseStreet(String houseStreet) {
            this.houseStreet.set(houseStreet);
        }

        public int getHouseNum() {
            return houseNum.get();
        }

        public SimpleIntegerProperty houseNumProperty() {
            return houseNum;
        }

        public void setHouseNum(int houseNum) {
            this.houseNum.set(houseNum);
        }

        public int getApartments() {
            return apartments.get();
        }

        public SimpleIntegerProperty apartmentsProperty() {
            return apartments;
        }

        public void setApartments(int apartments) {
            this.apartments.set(apartments);
        }

        public int getArea() {
            return area.get();
        }

        public SimpleIntegerProperty areaProperty() {
            return area;
        }

        public void setArea(int area) {
            this.area.set(area);
        }

        public String getHasBath() {
            return hasBath.get();
        }

        public SimpleStringProperty hasBathProperty() {
            return hasBath;
        }

        public void setHasBath(String hasBath) {
            this.hasBath.set(hasBath);
        }

        public String getHasBalcony() {
            return hasBalcony.get();
        }

        public SimpleStringProperty hasBalconyProperty() {
            return hasBalcony;
        }

        public void setHasBalcony(String hasBalcony) {
            this.hasBalcony.set(hasBalcony);
        }
    }
}

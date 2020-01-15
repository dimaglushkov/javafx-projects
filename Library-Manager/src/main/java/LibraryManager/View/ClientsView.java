package LibraryManager.View;

import LibraryManager.Data.DBAObject;
import LibraryManager.Entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class ClientsView implements Initializable {

    public Button booksButton;
    public TableView<ClientTableContent> clientsTable;
    public TextField firstNameField;
    public TextField secondNameField;
    public TextField thirdNameField;
    public TextField addressField;
    public TextField phoneField;
    public Button addButton;
    public Text statusText;

    private DBAObject<Customer, Integer> dbaCustomer = new DBAObject<>(Customer.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // initializing 'show' page

        TableColumn<ClientTableContent, Integer> col1 = new TableColumn<>("id");
        TableColumn<ClientTableContent, String> col2 = new TableColumn<>("Фамилия");
        TableColumn<ClientTableContent, String> col3 = new TableColumn<>("Имя");
        TableColumn<ClientTableContent, String> col4 = new TableColumn<>("Отчество");
        TableColumn<ClientTableContent, String> col5 = new TableColumn<>("Телефон");
        TableColumn<ClientTableContent, Integer> col6 = new TableColumn<>("Адрес");
;

        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        col3.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col4.setCellValueFactory(new PropertyValueFactory<>("thirdName"));
        col5.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col6.setCellValueFactory(new PropertyValueFactory<>("address"));



        clientsTable.getColumns().addAll(col1, col2, col3, col4, col5, col6);
        updateClientTableContent();

    }

    private void updateClientTableContent(){
        ObservableList<ClientTableContent> items = FXCollections.observableArrayList();

        List<Customer> customers = dbaCustomer.findAll();

        for (Customer customer : customers){
            ClientTableContent item = new ClientTableContent(customer);
            items.add(item);
        }

        clientsTable.setItems(items);

    }


    public void booksButton(ActionEvent event) {
        Stage stage = (Stage) booksButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/books.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void error(){
        this.statusText.setText("Ошибка");
        this.statusText.setVisible(true);
    }

    private void success(){
        this.statusText.setText("Клиент добавлен");
        this.statusText.setVisible(true);
    }

    private void clear(){
        this.statusText.setVisible(false);
    }



    public void add(ActionEvent event) {
        clear();
        if (this.firstNameField.getText().isEmpty()
                || this.phoneField.getText().isEmpty()
                || this.addressField.getText().isEmpty()
                || this.secondNameField.getText().isEmpty()
                || this.thirdNameField.getText().isEmpty())
        {
            error();
            return;
        }


        try {
            DBAObject<Person, Integer> dbaPerson = new DBAObject<>(Person.class);

            Person person = new Person();
            person.setFirstName(this.firstNameField.getText());
            person.setSecondName(this.secondNameField.getText());
            person.setThirdName(this.thirdNameField.getText());
            dbaPerson.create(person);

            Customer customer = new Customer();
            customer.setPerson(person);
            customer.setPhone(this.phoneField.getText());
            customer.setAddress(this.addressField.getText());

            dbaCustomer.create(customer);

        }
        catch (Exception e){
            e.printStackTrace();
            error();
        }
        success();
        updateClientTableContent();
    }
}

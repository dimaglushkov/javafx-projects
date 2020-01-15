package LibraryManager.View;

import LibraryManager.Data.DBAObject;
import LibraryManager.Entity.*;
import LibraryManager.View.TableContent.ClientTableContent;
import LibraryManager.View.TableContent.DebtorTableContent;
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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class ClientsView implements Initializable {

    public Button booksButton;
    public TableView<ClientTableContent> clientsTable;
    public TableView<DebtorTableContent> debtorTable;
    public TextField firstNameField;
    public TextField secondNameField;
    public TextField thirdNameField;
    public TextField addressField;
    public TextField phoneField;
    public Button addButton;
    public Text statusText;

    private DBAObject<Customer, Integer> dbaCustomer = new DBAObject<>(Customer.class);
    private DBAObject<Rent, Integer> dbaRent = new DBAObject<>(Rent.class);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // initializing 'clients' table

        TableColumn<ClientTableContent, Integer> col1 = new TableColumn<>("id");
        TableColumn<ClientTableContent, String> col2 = new TableColumn<>("Фамилия");
        TableColumn<ClientTableContent, String> col3 = new TableColumn<>("Имя");
        TableColumn<ClientTableContent, String> col4 = new TableColumn<>("Отчество");
        TableColumn<ClientTableContent, String> col5 = new TableColumn<>("Телефон");
        TableColumn<ClientTableContent, String> col6 = new TableColumn<>("Адрес");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        col3.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col4.setCellValueFactory(new PropertyValueFactory<>("thirdName"));
        col5.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col6.setCellValueFactory(new PropertyValueFactory<>("address"));

        clientsTable.getColumns().addAll(col1, col2, col3, col4, col5, col6);
        updateClientTableContent();

        // initializing 'debtors' table
        TableColumn<DebtorTableContent, Integer> cold1 = new TableColumn<>("id");
        TableColumn<DebtorTableContent, String> cold2 = new TableColumn<>("ФИО");
        TableColumn<DebtorTableContent, String> cold3 = new TableColumn<>("Телефон");
        TableColumn<DebtorTableContent, Integer> cold4 = new TableColumn<>("id выдачи");
        TableColumn<DebtorTableContent, Integer> cold5 = new TableColumn<>("id книги");
        TableColumn<DebtorTableContent, String> cold6 = new TableColumn<>("название книги");
        TableColumn<DebtorTableContent, String> cold7 = new TableColumn<>("дата выдачи");
        TableColumn<DebtorTableContent, String> cold8 = new TableColumn<>("дата конца");
        TableColumn<DebtorTableContent, Integer> cold9 = new TableColumn<>("просрочка");

        cold1.setCellValueFactory(new PropertyValueFactory<>("id"));
        cold2.setCellValueFactory(new PropertyValueFactory<>("formattedName"));
        cold3.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cold4.setCellValueFactory(new PropertyValueFactory<>("rentId"));
        cold5.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        cold6.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        cold7.setCellValueFactory(new PropertyValueFactory<>("rentDay"));
        cold8.setCellValueFactory(new PropertyValueFactory<>("rentFinishDay"));
        cold9.setCellValueFactory(new PropertyValueFactory<>("rentOver"));

        debtorTable.getColumns().addAll(cold1, cold2, cold3, cold4, cold5, cold6, cold7, cold8, cold9);
        updateDebtorTableContent();

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

    private void updateDebtorTableContent() {
        ObservableList<DebtorTableContent> items = FXCollections.observableArrayList();

        List<Rent> rents = dbaRent.findAll();

        Timestamp today = new Timestamp(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();

        final long MILLIS_PER_DAY = 1000*60*60*24;

        for (Rent rent : rents){

            Timestamp finishDate = new Timestamp(rent.getDay().getTime());
            c.setTime(finishDate);
            c.add(Calendar.DATE, rent.getDuration());
            finishDate.setTime(c.getTime().getTime());
            if (today.before(finishDate))
                continue;

            DebtorTableContent item = new DebtorTableContent();

            item.setId(rent.getCustomer().getCustomerId());
            item.setFormattedName(rent.getCustomer().getPerson().getFormattedName());
            item.setPhone(rent.getCustomer().getPhone());
            item.setRentId(rent.getRentId());
            item.setBookId(rent.getBook().getBookId());
            item.setBookName(rent.getBook().getName());
            item.setRentDay(rent.getDay().toString().substring(0, 10));

            item.setRentFinishDay(finishDate.toString().substring(0, 10));
            long i = ((today.getTime() - finishDate.getTime()));
            long l = i / MILLIS_PER_DAY;
            item.setRentOver((int)(l));

            items.add(item);

        }

        debtorTable.setItems(items);
    }

    public void booksButton(ActionEvent event) {
        Stage stage = (Stage) booksButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/books.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rentsButton(ActionEvent event) {
        Stage stage = (Stage) booksButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/rents.fxml"))));
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

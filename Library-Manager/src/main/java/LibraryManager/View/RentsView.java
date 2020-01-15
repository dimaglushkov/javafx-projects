package LibraryManager.View;

import LibraryManager.Data.DBAObject;
import LibraryManager.Entity.*;
import LibraryManager.View.TableContent.ClientTableContent;
import LibraryManager.View.TableContent.DebtorTableContent;
import LibraryManager.View.TableContent.RentTableContent;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class RentsView implements Initializable {

    public Button booksButton;
    public Button clientsButton;
    public TableView<RentTableContent> rentsTable;
    public TextField bookField;
    public TextField customerField;
    public DatePicker dateField;
    public TextField durationField;
    public Button addButton;
    public Text statusText;

    private DBAObject<Rent, Integer> dbaRent = new DBAObject<>(Rent.class);
    private DBAObject<Customer, Integer> dbaCustomer = new DBAObject<>(Customer.class);
    private DBAObject<Book, Integer> dbaBook = new DBAObject<>(Book.class);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // initializing 'clients' table

        TableColumn<RentTableContent, Integer> col1 = new TableColumn<>("id");
        TableColumn<RentTableContent, Integer> col2 = new TableColumn<>("id книги");
        TableColumn<RentTableContent, String> col3 = new TableColumn<>("Название книги");
        TableColumn<RentTableContent, String> col4 = new TableColumn<>("Автор книги");
        TableColumn<RentTableContent, String> col5 = new TableColumn<>("id клиента");
        TableColumn<RentTableContent, String> col6 = new TableColumn<>("ФИО клиента");
        TableColumn<RentTableContent, String> col7 = new TableColumn<>("Дата выдачи");
        TableColumn<RentTableContent, String> col8 = new TableColumn<>("Дата конца");
        TableColumn<RentTableContent, Integer> col9 = new TableColumn<>("Дней конца");
        col1.setCellValueFactory(new PropertyValueFactory<>("rendId"));
        col2.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        col3.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        col4.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        col5.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        col6.setCellValueFactory(new PropertyValueFactory<>("customer"));
        col7.setCellValueFactory(new PropertyValueFactory<>("rentDay"));
        col8.setCellValueFactory(new PropertyValueFactory<>("rentReturnDay"));
        col9.setCellValueFactory(new PropertyValueFactory<>("rentDaysLeft"));

        rentsTable.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);
        updateRentsTableContent();

    }

    private void updateRentsTableContent() {
        ObservableList<RentTableContent> items = FXCollections.observableArrayList();

        List<Rent> rents = dbaRent.findAll();
        Timestamp today = new Timestamp(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        final long MILLIS_PER_DAY = 1000*60*60*24;

        for (Rent rent : rents){

            Timestamp finishDate = new Timestamp(rent.getDay().getTime());
            c.setTime(finishDate);
            c.add(Calendar.DATE, rent.getDuration());
            finishDate.setTime(c.getTime().getTime());

            RentTableContent item = new RentTableContent();

            item.setRendId(rent.getRentId());
            item.setBookId(rent.getBook().getBookId());
            item.setBookName(rent.getBook().getName());
            item.setBookAuthor(rent.getBook().getAuthor().getPerson().getFormattedName());
            item.setCustomerId(rent.getCustomer().getCustomerId());
            item.setCustomer(rent.getCustomer().getPerson().getFormattedName());
            item.setRentDay(rent.getDay().toString().substring(0, 10));
            item.setRentReturnDay(finishDate.toString().substring(0, 10));
            item.setRentDaysLeft((int)(((today.getTime() - finishDate.getTime()) / MILLIS_PER_DAY)));

            items.add(item);

        }

        rentsTable.setItems(items);

    }


    public void booksButton(ActionEvent event) {
        Stage stage = (Stage) booksButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/books.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientsButton(ActionEvent event) {
        Stage stage = (Stage) booksButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/clients.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void error(){
        this.statusText.setText("Ошибка");
        this.statusText.setVisible(true);
    }

    private void success(){
        this.statusText.setText("Книга выдана!");
        this.statusText.setVisible(true);
    }

    private void clear(){
        this.statusText.setVisible(false);
    }



    public void add(ActionEvent event) {
        clear();
        if (this.bookField.getText().isEmpty()
                || this.customerField.getText().isEmpty()
                || this.dateField.getValue().toString().isEmpty()
                || this.durationField.getText().isEmpty())
        {
            error();
            return;
        }

        try {
            int idStudent = Integer.parseInt(this.customerField.getText()),
                    idBook = Integer.parseInt(this.bookField.getText()),
                    duration = Integer.parseInt(this.durationField.getText());

            Customer customer = dbaCustomer.findById(idStudent);
            Book book = dbaBook.findById(idBook);

            Rent rent = new Rent();
            rent.setBook(book);
            rent.setCustomer(customer);
            rent.setDuration(duration);
            rent.setDay(Timestamp.valueOf(this.dateField.getValue().atStartOfDay()));

            dbaRent.create(rent);

        }
        catch (Exception e){
            e.printStackTrace();
            error();
        }
        success();
        updateRentsTableContent();
    }


}

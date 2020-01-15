package LibraryManager.View;

import LibraryManager.Data.DBAObject;
import LibraryManager.Entity.*;
import LibraryManager.View.TableContent.BookTableContent;
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

public class BooksView implements Initializable {

    public Button booksTab;
    public Button clientsButton;
    public TableView<BookTableContent> booksTable;
    public TextField nameField;
    public ComboBox<String> authorBox;
    public ComboBox<String> genreBox;
    public TextField publisherField;
    public TextField publishedField;
    public TextField pagesField;
    public Button addButton;
    public Text statusText;

    private DBAObject<Genre, Integer> dbaGenre = new DBAObject<>(Genre.class);
    private DBAObject<Book, Integer> dbaBook = new DBAObject<>(Book.class);
    private DBAObject<Rent, Integer> dbaRent = new DBAObject<>(Rent.class);
    private DBAObject<Author, Integer> dbaAuthor = new DBAObject<>(Author.class);

    private HashMap<String, Integer> authors = new HashMap<>();
    private HashMap<String, Integer> genres = new HashMap<>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // initializing 'show' page

        TableColumn<BookTableContent, Integer> col1 = new TableColumn<>("id");
        TableColumn<BookTableContent, String> col2 = new TableColumn<>("Название");
        TableColumn<BookTableContent, String> col7 = new TableColumn<>("Жанр");
        TableColumn<BookTableContent, String> col3 = new TableColumn<>("Автор");
        TableColumn<BookTableContent, String> col4 = new TableColumn<>("Издательство");
        TableColumn<BookTableContent, Integer> col5 = new TableColumn<>("Год издания");
        TableColumn<BookTableContent, String> col6 = new TableColumn<>("Страниц");

        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        col3.setCellValueFactory(new PropertyValueFactory<>("author"));
        col4.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        col5.setCellValueFactory(new PropertyValueFactory<>("published"));
        col6.setCellValueFactory(new PropertyValueFactory<>("size"));
        col7.setCellValueFactory(new PropertyValueFactory<>("genre"));


        booksTable.getColumns().addAll(col1, col2, col3, col7, col4, col5, col6);
        updateBookTableContent();


        //initializing 'add' page

        List<Author> authors = dbaAuthor.findAll();
        List<Genre> genres = dbaGenre.findAll();

        for (Author author : authors)
            this.authors.put(author.getPerson().getFormattedName(), author.getAuthorId());

        for (Genre genre : genres)
            this.genres.put(genre.getValue(), genre.getGenreId());

        this.authorBox.setItems(FXCollections.observableArrayList(this.authors.keySet()));
        this.genreBox.setItems(FXCollections.observableArrayList(this.genres.keySet()));

    }

    private void updateBookTableContent(){
        ObservableList<BookTableContent> items = FXCollections.observableArrayList();

        List<Book> books = dbaBook.findAll();

        for (Book book : books){
            BookTableContent item = new BookTableContent();

            item.setId(book.getBookId());
            item.setAuthor(book.getAuthor().getPerson().getFormattedName());
            item.setBookName(book.getName());
            item.setPublished(book.getPublished());
            item.setSize(book.getPages());
            item.setPublisher(book.getPublisher());
            item.setGenre(book.getGenre().getValue());

            items.add(item);
        }

        booksTable.setItems(items);

    }


    public void clientsButton(ActionEvent event) {
        Stage stage = (Stage) clientsButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/clients.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rentsButton(ActionEvent event) {
        Stage stage = (Stage) clientsButton.getScene().getWindow();
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
        this.statusText.setText("Книга добавлена");
        this.statusText.setVisible(true);
    }

    private void clear(){
        this.statusText.setVisible(false);
    }



    public void add(ActionEvent event) {
        clear();
        if (this.nameField.getText().isEmpty()
                || this.pagesField.getText().isEmpty()
                || this.authorBox.getValue().isEmpty()
                || this.genreBox.getValue().isEmpty()
                || this.publisherField.getText().isEmpty()
                || this.publishedField.getText().isEmpty())
        {
            error();
            return;
        }


        try {
            Author author = dbaAuthor.findById(this.authors.get(this.authorBox.getValue()));
            Genre genre = dbaGenre.findById(this.genres.get(this.genreBox.getValue()));
            Book book = new Book();
            book.setAuthor(author);
            book.setGenre(genre);
            book.setName(this.nameField.getText());
            book.setPages(Integer.parseInt(this.pagesField.getText()));
            book.setPublished(Integer.parseInt(this.publishedField.getText()));
            book.setPublisher(this.publisherField.getText());
            dbaBook.create(book);
        }
        catch (Exception e){
            e.printStackTrace();
            error();
        }
        success();
        updateBookTableContent();
    }
}

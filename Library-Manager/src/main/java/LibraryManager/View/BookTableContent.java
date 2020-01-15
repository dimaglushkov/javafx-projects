package LibraryManager.View;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BookTableContent {

    protected SimpleIntegerProperty id;
    protected SimpleStringProperty bookName;
    protected SimpleStringProperty author;
    protected SimpleStringProperty genre;
    protected SimpleStringProperty publisher;
    protected SimpleIntegerProperty published;
    protected SimpleIntegerProperty size;

    public BookTableContent() {
        id = new SimpleIntegerProperty();
        bookName = new SimpleStringProperty();
        author = new SimpleStringProperty();
        genre = new SimpleStringProperty();
        publisher = new SimpleStringProperty();
        published = new SimpleIntegerProperty();
        size = new SimpleIntegerProperty();
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

    public String getBookName() {
        return bookName.get();
    }

    public SimpleStringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getGenre() {
        return genre.get();
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getPublisher() {
        return publisher.get();
    }

    public SimpleStringProperty publisherProperty() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
    }

    public int getPublished() {
        return published.get();
    }

    public SimpleIntegerProperty publishedProperty() {
        return published;
    }

    public void setPublished(int published) {
        this.published.set(published);
    }

    public int getSize() {
        return size.get();
    }

    public SimpleIntegerProperty sizeProperty() {
        return size;
    }

    public void setSize(int size) {
        this.size.set(size);
    }
}

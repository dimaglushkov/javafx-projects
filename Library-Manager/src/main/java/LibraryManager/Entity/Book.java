package LibraryManager.Entity;


import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookId;

    @Column(name="name")
    String name;

    @OneToOne
    @JoinColumn(name="author_id", referencedColumnName="author_id")
    Author author;

    @Column(name="publisher")
    String publisher;

    @Column(name="published")
    Integer published;

    @OneToOne
    @JoinColumn(name="genre", referencedColumnName="genre_id")
    Genre genre;

    @Column(name="pages")
    Integer pages;

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}

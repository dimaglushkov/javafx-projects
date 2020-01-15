package LibraryManager.Entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rent")
public class Rent {
    @Id
    @Column(name="rent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer rentId;

    @OneToOne
    @JoinColumn(name="customer_id", referencedColumnName="customer_id")
    Customer customer;

    @OneToOne
    @JoinColumn(name="book_id", referencedColumnName="book_id")
    Book book;

    @Column(name="day")
    Date day;

    @Column(name="duration")
    Integer duration;

    public Rent() {
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}

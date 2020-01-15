package LibraryManager.View.TableContent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RentTableContent {

    private SimpleIntegerProperty rendId;
    private SimpleIntegerProperty bookId;
    private SimpleStringProperty bookName;
    private SimpleStringProperty bookAuthor;
    private SimpleIntegerProperty customerId;
    private SimpleStringProperty customer;
    private SimpleStringProperty rentDay;
    private SimpleStringProperty rentReturnDay;
    private SimpleIntegerProperty rentDaysLeft;

    public RentTableContent() {
        rendId = new SimpleIntegerProperty();
        bookId = new SimpleIntegerProperty();
        bookName = new SimpleStringProperty();
        bookAuthor = new SimpleStringProperty();
        customerId = new SimpleIntegerProperty();
        customer = new SimpleStringProperty();
        rentDay = new SimpleStringProperty();
        rentReturnDay = new SimpleStringProperty();
        rentDaysLeft = new SimpleIntegerProperty();
    }

    public int getRendId() {
        return rendId.get();
    }

    public SimpleIntegerProperty rendIdProperty() {
        return rendId;
    }

    public void setRendId(int rendId) {
        this.rendId.set(rendId);
    }

    public int getBookId() {
        return bookId.get();
    }

    public SimpleIntegerProperty bookIdProperty() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId.set(bookId);
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

    public String getBookAuthor() {
        return bookAuthor.get();
    }

    public SimpleStringProperty bookAuthorProperty() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor.set(bookAuthor);
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public SimpleIntegerProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public String getCustomer() {
        return customer.get();
    }

    public SimpleStringProperty customerProperty() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

    public String getRentDay() {
        return rentDay.get();
    }

    public SimpleStringProperty rentDayProperty() {
        return rentDay;
    }

    public void setRentDay(String rentDay) {
        this.rentDay.set(rentDay);
    }

    public String getRentReturnDay() {
        return rentReturnDay.get();
    }

    public SimpleStringProperty rentReturnDayProperty() {
        return rentReturnDay;
    }

    public void setRentReturnDay(String rentReturnDay) {
        this.rentReturnDay.set(rentReturnDay);
    }

    public int getRentDaysLeft() {
        return rentDaysLeft.get();
    }

    public SimpleIntegerProperty rentDaysLeftProperty() {
        return rentDaysLeft;
    }

    public void setRentDaysLeft(int rentDaysLeft) {
        this.rentDaysLeft.set(rentDaysLeft);
    }
}

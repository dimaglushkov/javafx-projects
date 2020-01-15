package LibraryManager.View.TableContent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DebtorTableContent extends ClientTableContent{
    private SimpleStringProperty formattedName;
    private SimpleIntegerProperty bookId;
    private SimpleStringProperty bookName;
    private SimpleIntegerProperty rentId;
    private SimpleStringProperty rentDay;
    private SimpleStringProperty rentFinishDay;
    private SimpleIntegerProperty rentOver;

    public DebtorTableContent() {
        bookId = new SimpleIntegerProperty();
        rentDay = new SimpleStringProperty();
        formattedName = new SimpleStringProperty();
        bookName = new SimpleStringProperty();
        rentOver = new SimpleIntegerProperty();
        rentFinishDay = new SimpleStringProperty();
        rentId = new SimpleIntegerProperty();
    }

    public String getFormattedName() {
        return formattedName.get();
    }

    public SimpleStringProperty formattedNameProperty() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName.set(formattedName);
    }

    public String getRentFinishDay() {
        return rentFinishDay.get();
    }

    public SimpleStringProperty rentFinishDayProperty() {
        return rentFinishDay;
    }

    public void setRentFinishDay(String rentFinishDay) {
        this.rentFinishDay.set(rentFinishDay);
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

    public int getRentId() {
        return rentId.get();
    }

    public SimpleIntegerProperty rentIdProperty() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId.set(rentId);
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

    public String getRentDay() {
        return rentDay.get();
    }

    public SimpleStringProperty rentDayProperty() {
        return rentDay;
    }

    public void setRentDay(String rentDay) {
        this.rentDay.set(rentDay);
    }

    public int getRentOver() {
        return rentOver.get();
    }

    public SimpleIntegerProperty rentOverProperty() {
        return rentOver;
    }

    public void setRentOver(int rentOver) {
        this.rentOver.set(rentOver);
    }
}

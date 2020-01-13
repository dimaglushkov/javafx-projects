package View;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentsRaw {

    private SimpleLongProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty address;
    private SimpleLongProperty courseId;
    private SimpleStringProperty language;

    public StudentsRaw() {
        id = new SimpleLongProperty();
        name = new SimpleStringProperty();
        surname = new SimpleStringProperty();
        address = new SimpleStringProperty();
        courseId = new SimpleLongProperty();
        language = new SimpleStringProperty();
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public long getCourseId() {
        return courseId.get();
    }

    public SimpleLongProperty courseIdProperty() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId.set(courseId);
    }

    public String getLanguage() {
        return language.get();
    }

    public SimpleStringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }
}
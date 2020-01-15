package LibraryManager.View.TableContent;

import LibraryManager.Entity.Customer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClientTableContent {

    protected SimpleIntegerProperty id;
    protected SimpleStringProperty firstName;
    protected SimpleStringProperty secondName;
    protected SimpleStringProperty thirdName;
    protected SimpleStringProperty phone;
    protected SimpleStringProperty address;


    public ClientTableContent() {
        id = new SimpleIntegerProperty();
        firstName = new SimpleStringProperty();
        secondName = new SimpleStringProperty();
        thirdName = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        address = new SimpleStringProperty();
    }

    public ClientTableContent(Customer customer) {
        id = new SimpleIntegerProperty(customer.getCustomerId());
        firstName = new SimpleStringProperty(customer.getPerson().getFirstName());
        secondName = new SimpleStringProperty(customer.getPerson().getSecondName());
        thirdName = new SimpleStringProperty(customer.getPerson().getThirdName());
        phone = new SimpleStringProperty(customer.getPhone());
        address = new SimpleStringProperty(customer.getAddress());
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

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getSecondName() {
        return secondName.get();
    }

    public SimpleStringProperty secondNameProperty() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public String getThirdName() {
        return thirdName.get();
    }

    public SimpleStringProperty thirdNameProperty() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName.set(thirdName);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
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
}

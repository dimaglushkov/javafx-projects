package StorageSystem.Entities;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="VENDOR_CODE")
    private String vendorCode;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="MANUFACTURER")
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "LOCATION", referencedColumnName = "STORAGE_ID")
    private Storage location;

    @Column(name="PRICE")
    private Integer price;

    @Column(name="RECEIVED_TIME")
    private Timestamp receivedTime;

    @Column(name="SOLD_TIME", nullable=true)
    private Timestamp soldTime;

    public Product() {
    }

    public Product(String vendorCode, String category, String description, String manufacturer, Storage location, Integer price, Timestamp receivedTime, Timestamp soldDate) {
        this.vendorCode = vendorCode;
        this.category = category;
        this.description = description;
        this.manufacturer = manufacturer;
        this.location = location;
        this.price = price;
        this.receivedTime = receivedTime;
        this.soldTime = soldDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Storage getLocation() {
        return location;
    }

    public void setLocation(Storage location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Timestamp receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Timestamp getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(Timestamp soldTime) {
        this.soldTime = soldTime;
    }
}


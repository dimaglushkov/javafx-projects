package StorageSystem.Entities;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="VENDOR_CODE")
    private String vendorCode;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="RECEIVED_DATE")
    private Date receivedDate;

    @Column(name="SOLD_DATE")
    private Date soldDate;

    public Product() {
    }

    public Product(String vendorCode, String category, String description, Date receivedDate, Date soldDate) {
        this.vendorCode = vendorCode;
        this.category = category;
        this.description = description;
        this.receivedDate = receivedDate;
        this.soldDate = soldDate;
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

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }
}

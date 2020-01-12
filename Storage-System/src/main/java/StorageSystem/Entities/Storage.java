package StorageSystem.Entities;


import javax.persistence.*;

@Entity
@Table(name="STORAGE")
public class Storage {

    @Id
    @Column(name="STORAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="STREET")
    private String street;

    @Column(name="BUILDING")
    private Integer building;

    public Storage() {
    }

    public Storage(String street, Integer building) {
        this.street = street;
        this.building = building;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }
}

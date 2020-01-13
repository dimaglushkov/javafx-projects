package REAgency.Entity;


import javax.persistence.*;

@Entity
@Table(name="HOUSE")
public class House {
    @Id
    @Column(name="HOUSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DISTRICT")
    private String district;

    @Column(name="STREET")
    private String street;

    @Column(name="TYPE")
    private String type;

    @Column(name="NUM")
    private Integer num;

    @Column(name="NUM_OF_FLOORS")
    private Integer num_of_floors;

    @Column(name="SERIES")
    private String series;

    public House() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum_of_floors() {
        return num_of_floors;
    }

    public void setNum_of_floors(Integer num_of_floors) {
        this.num_of_floors = num_of_floors;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}

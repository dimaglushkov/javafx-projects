package REAgency.Entity;


import javax.persistence.*;

@Entity
@Table(name="PROPERTY")
public class Property {

    @Id
    @Column(name="PROPERTY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "HOUSE_ID", referencedColumnName = "HOUSE_ID")
    private House house;

    @Column(name="FLOOR")
    private Integer floor;

    @Column(name="APARTMENTS")
    private Integer apartments;

    @Column(name="AREA")
    private Integer area;

    @Column(name="NUM_OF_ROOMS")
    private Integer numOfRooms;

    @Column(name="HAS_BATH")
    private String hasBath;

    @Column(name="HAS_BALCONY")
    private  String hasBalcony;

    public Property() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getApartments() {
        return apartments;
    }

    public void setApartments(Integer apartments) {
        this.apartments = apartments;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer num_of_rooms) {
        this.numOfRooms = num_of_rooms;
    }

    public String getHasBath() {
        return hasBath;
    }

    public void setHasBath(String has_bath) {
        this.hasBath = has_bath;
    }

    public String getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(String has_balcony) {
        this.hasBalcony = has_balcony;
    }
}

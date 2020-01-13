package Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="BRANCH")
public class BranchEntity {

    @Id
    @Column(name="BRANCH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="STREET")
    private String street;

    @Column(name="BUILDING")
    private Integer building;

    @Column(name="CREATED")
    private Date created;

    @Column(name="UNFORMED", nullable=true)
    private Date unformed;

    public BranchEntity() {
    }

    public BranchEntity(String street, Integer building, Date created, Date unformed) {
        this.street = street;
        this.building = building;
        this.created = created;
        this.unformed = unformed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUnformed() {
        return unformed;
    }

    public void setUnformed(Date unformed) {
        this.unformed = unformed;
    }
}

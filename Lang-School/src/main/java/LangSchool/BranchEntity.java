package LangSchool;


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

    @Column(name="LOCATION")
    private String location;

    @Column(name="CREATED")
    private Timestamp created;

    @Column(name="UNFORMED", nullable=true)
    private Timestamp unformed;

    public BranchEntity() {
    }

    public BranchEntity(String location, Timestamp created, Timestamp unformed) {
        this.location = location;
        this.created = created;
        this.unformed = unformed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUnformed() {
        return unformed;
    }

    public void setUnformed(Timestamp unformed) {
        this.unformed = unformed;
    }
}

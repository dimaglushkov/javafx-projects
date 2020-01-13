package Data;

import javax.persistence.*;

@Entity
@Table(name="COURSE")
public class CourseEntity {

    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LANGUAGE")
    private String language;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID")
    private BranchEntity branch;

    public CourseEntity() {
    }

    public CourseEntity(String language, BranchEntity branch) {
        this.language = language;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

}



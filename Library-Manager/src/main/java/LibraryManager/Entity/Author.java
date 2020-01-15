package LibraryManager.Entity;

import javax.persistence.*;

@Entity
@Table(name="author")
public class Author {
    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer authorId;

    @OneToOne
    @JoinColumn(name="person_id", referencedColumnName="person_id")
    Person person;

    @Column(name="nationality")
    String nationality;

    public Author() {
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

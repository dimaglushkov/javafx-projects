package LibraryManager.Entity;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer personId;

    @Column(name="first_name")
    String firstName;

    @Column(name="second_name")
    String secondName;

    @Column(name="third_name")
    String thirdName;

    public Person() {
    }

    public String getFormattedName(){
        return this.secondName + " " + this.firstName.charAt(0) + "." + this.thirdName.charAt(0) + ".";
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }
}

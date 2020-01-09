package REAgency.Entity;

import javax.persistence.*;

@Entity
@Table(name="MANAGER")
public class Manager {

    @Id
    @Column(name="MANAGER_ID", columnDefinition = "SERIAL")
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="SPEC")
    private String spec;

    @Column(name="COMISSION")
    private long comission;

    @Column(name="PASSWORD")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public long getComission() {
        return comission;
    }

    public void setComission(long comission) {
        this.comission = comission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

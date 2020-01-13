package REAgency.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="MANAGER")
public class Manager implements Serializable, Cloneable {

    @Id
    @Column(name="MANAGER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME", nullable=false)
    private String surname;

    @Column(name="SPEC", nullable=false)
    private String spec;

    @Column(name="COMISSION", nullable=false)
    private Integer comission;

    @Column(name="PASSWORD", nullable=false)
    private String password;

    public Manager(){}



    public Manager(String name, String surname, String spec, Integer comission, String password) {
        this.name = name;
        this.surname = surname;
        this.spec = spec;
        this.comission = comission;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
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

    public Integer getComission() {
        return comission;
    }

    public void setComission(Integer comission) {
        this.comission = comission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

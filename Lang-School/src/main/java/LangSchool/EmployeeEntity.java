package LangSchool;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity {
    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="CONTRACT_ID")
    private Long contractId;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String surname, Long contractId) {
        this.name = name;
        this.surname = surname;
        this.contractId = contractId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}

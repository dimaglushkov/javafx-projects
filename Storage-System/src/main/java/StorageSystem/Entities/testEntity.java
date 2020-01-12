package StorageSystem.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="test")
public class testEntity implements Serializable, Cloneable {

    @Id
    @Column(name="lul")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public testEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
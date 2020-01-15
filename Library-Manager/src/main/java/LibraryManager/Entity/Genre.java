package LibraryManager.Entity;

import javax.persistence.*;

@Entity
@Table(name="genre")
public class Genre {
    @Id
    @Column(name="genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer genreId;

    @Column(name="value")
    String value;

    public Genre() {
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

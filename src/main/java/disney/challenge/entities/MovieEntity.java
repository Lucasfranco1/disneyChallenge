package disney.challenge.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movie")
@Getter
@Setter
@SQLDelete(sql="UPDATE movie SET deleted = true WHERE id=?")
@Where(clause="deleted=false")
public class MovieEntity {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;
    
    private String image;
    
    private String title;
    

    @Column(name="creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    private Integer qualification;
    
    @ManyToMany(cascade={
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(
        name="associated_characters",
            joinColumns = @JoinColumn(name="movie.id"),
            inverseJoinColumns=@JoinColumn(name="character.id"))
    private List<CharacterEntity> associatedCharacters;

    private Boolean deleted= Boolean.FALSE;
}

package disney.challenge.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate creationDate;
    
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

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE},
        fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_genders",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "gender_id"))
    private List<GenderEntity> genders = new ArrayList<>();
    private Boolean deleted= Boolean.FALSE;
}

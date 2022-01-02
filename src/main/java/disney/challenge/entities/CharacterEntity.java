
package disney.challenge.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="character")
@Getter
@Setter
@SQLDelete(sql="UPDATE character SET deleted = true WHERE id=?")
@Where(clause="deleted=false")
public class CharacterEntity {
    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;
        
    private String image;
    
    private String name;
    
    private Integer age;
    
    private Double weight;
    
    private String story;
    
    @ManyToMany(mappedBy = "associatedCharacters",cascade = CascadeType.ALL)
    private List<MovieEntity> associatedMovies;
    
    
    private Boolean deleted= Boolean.FALSE;

    
}

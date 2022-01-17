
package disney.challenge.entities;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Getter
@Setter
public class GenderEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String image;
    
    private String name;
    
    @ManyToMany(mappedBy = "genders",fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<MovieEntity> movies = new ArrayList<>();

}

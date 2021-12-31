/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.entities;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
public class MovieEntity {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;
    
    private String image;
    
    private String title;
    
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
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

}

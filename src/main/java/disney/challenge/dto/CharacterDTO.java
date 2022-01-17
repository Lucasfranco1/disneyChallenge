package disney.challenge.dto;

import disney.challenge.entities.MovieEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    
    private String id;
        
    private String image;
    
    private String name;
    
    private Integer age;
    
    private Double weight;
    
    private String story;
    
    private List<MovieDTO> associatedMovies;

   
}

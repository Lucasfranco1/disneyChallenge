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
    
    private List<MovieEntity> associatedMovies;

    public void setAssociatedMovies(List<MovieDTO> moviesDTOS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

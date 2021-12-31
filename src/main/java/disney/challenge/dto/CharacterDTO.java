/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
}

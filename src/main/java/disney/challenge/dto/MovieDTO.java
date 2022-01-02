/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.dto;

import disney.challenge.entities.CharacterEntity;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
    
    private String id;
    private String image;
    private String title;
    private Date creationDate;
    private Integer qualification;
    private List<CharacterEntity> associatedCharacters;

    public void setAssociatedCharacters(List<CharacterDTO> charactersDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

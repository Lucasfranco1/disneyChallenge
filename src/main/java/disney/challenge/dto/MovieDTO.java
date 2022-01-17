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
    private String creationDate;
    private Integer qualification;
    private List<CharacterEntity> associatedCharacters;

    private List<GenderDTO> genders;
    public void setCreationDate(String formatDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}

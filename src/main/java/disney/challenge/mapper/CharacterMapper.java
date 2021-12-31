/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.mapper;

import disney.challenge.dto.CharacterDTO;
import disney.challenge.entities.CharacterEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
    
    public CharacterEntity characterDTO2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setStory(dto.getStory());
        characterEntity.setAssociatedMovies(dto.getAssociatedMovies());
        
        return characterEntity;
    }
    
    public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO dto=new CharacterDTO();
        dto.setId((entity.getId()));
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(entity.getStory());
        dto.setAssociatedMovies(entity.getAssociatedMovies());
        
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities) {
     
        List<CharacterDTO>dtos=new ArrayList();
        
        for (CharacterEntity aux : entities) {
            dtos.add(characterEntity2DTO(aux));
            
        }
        return dtos;
    }
}

package disney.challenge.mapper;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.entities.CharacterEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
    
    @Autowired
    private MovieMapper movieMapper;
    
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
    
   public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies){
        CharacterDTO dto=new CharacterDTO();
        dto.setId((entity.getId()));
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(entity.getStory());
        if(loadMovies){
            List<MovieDTO>moviesDTOS=movieMapper.movieEntityList2DTOList(entity.getAssociatedMovies(), loadMovies);
            dto.setAssociatedMovies(moviesDTOS);
        }
                    
        
        return dto;
    }
    
    
    
    public List<CharacterBasicDTO> characterEntitySet2BasicDTOList(Collection<CharacterEntity> entities){
        List<CharacterBasicDTO>dtos=new ArrayList();
        CharacterBasicDTO basicDTO;
        for (CharacterEntity aux : entities) {
            basicDTO=new CharacterBasicDTO();
            basicDTO.setId(aux.getId());
            basicDTO.setImage(aux.getImage());
            basicDTO.setImage(aux.getName());
            dtos.add(basicDTO);
            
        }
        return dtos;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity saveEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

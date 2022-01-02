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
    
   public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO dto=new CharacterDTO();
        dto.setId((entity.getId()));
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(entity.getStory());
//        if(loadMovies){
//            List<MovieDTO>movieDTO=movieMapper.movieEntityList2DTOList(entity.getAssociatedMovies(), loadCharacters false);
//        }
//            dto.setAssociatedMovies(movieDTO);
//        }
//        
        return dto;
    }
    

    //    public CharacterDTO characterEntity2DTO(CharacterEntity entity, Boolean loadMovies){
//        CharacterDTO dto=new CharacterDTO();
//        dto.setId((entity.getId()));
//        dto.setImage(entity.getImage());
//        dto.setName(entity.getName());
//        dto.setAge(entity.getAge());
//        dto.setWeight(entity.getWeight());
//        dto.setStory(entity.getStory());
//        if(loadMovies){
//            List<MovieDTO>movieDTO=movieMapper.movieEntityList2DTOList(entity.getAssociatedMovies(), loadCharacters false);
//            dto.setAssociatedMovies(movieDTO);
//        }
//        
//        return dto;
//    }
//    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities) {
//     
//        List<CharacterDTO>dtos=new ArrayList();
//        
//        for (CharacterEntity aux : entities) {
//            dtos.add(characterEntity2DTO(aux));
//            
//        }
//        return dtos;
//    }
    
    
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
}

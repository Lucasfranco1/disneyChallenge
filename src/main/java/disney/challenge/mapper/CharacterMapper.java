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
    
     public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
        CharacterEntity characterEntity = new CharacterEntity();

        characterEntity.setName(dto.getName());
        characterEntity.setImage(dto.getImage());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setStory(dto.getStory());

        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity characterEntity, boolean loadMovie) {
        CharacterDTO dto = new CharacterDTO();

        dto.setId(characterEntity.getId());
        dto.setName(characterEntity.getName());
        dto.setImage(characterEntity.getImage());
        dto.setAge(characterEntity.getAge());
        dto.setWeight(characterEntity.getWeight());
        dto.setStory(characterEntity.getStory());

        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovie) {
        List<CharacterDTO> dtoList = new ArrayList<>();

        for (CharacterEntity entity : entities) {
            dtoList.add(characterEntity2DTO(entity, loadMovie));
        }
        return dtoList;
    }

    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtoList, boolean load) {
        List<CharacterEntity> entities = new ArrayList<>();

        for (CharacterDTO dto : dtoList) {
            entities.add(this.characterDTO2Entity(dto));
        }
        return entities;
    }

    public CharacterBasicDTO entity2BasicDTO(CharacterEntity charEntity) {
        CharacterBasicDTO dtoBasic = new CharacterBasicDTO();

        dtoBasic.setId(charEntity.getId());
        dtoBasic.setName(charEntity.getName());
        dtoBasic.setImage(charEntity.getImage());

        return dtoBasic;
    }

    public List<CharacterBasicDTO> basicEntityList2DTOBasicList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> basicList = new ArrayList<>();
        
        for (CharacterEntity entity : entities) {
             basicList.add(this.entity2BasicDTO(entity));
        }
        return basicList;
    }
}

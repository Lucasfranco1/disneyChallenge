
package disney.challenge.service;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import disney.challenge.entities.CharacterEntity;
import disney.challenge.mapper.CharacterMapper;
import disney.challenge.repository.CharacterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService{
            
    @Autowired
    private CharacterMapper characterMapper;
    
    @Autowired
    private CharacterRepository characterRepository;
    
    
     public CharacterDTO save(CharacterDTO dto){                 
      CharacterEntity entity= characterMapper.characterDTO2Entity(dto);
      CharacterEntity saveEntity=characterRepository.save(entity);
      CharacterDTO result=characterMapper.characterEntity2DTO(saveEntity);
      return result;
        
    }

  
    public List<CharacterBasicDTO> getAllCharacters() {
       List<CharacterEntity>entities=characterRepository.findAll();
       List<CharacterBasicDTO>result=characterMapper.characterEntitySet2BasicDTOList(entities);
       return result;
    }

    
    public void delete(String id) {
        characterRepository.deleteById(id);
    }
}

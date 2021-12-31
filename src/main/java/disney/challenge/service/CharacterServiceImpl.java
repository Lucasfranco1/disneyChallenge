/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.service;

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

  
    public List<CharacterDTO> getAllCharacters() {
       List<CharacterEntity>entities=characterRepository.findAll();
       List<CharacterDTO>result=characterMapper.characterEntityList2DTOList(entities);
       return result;
    }
}

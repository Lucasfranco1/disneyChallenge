/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.service;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import java.util.List;


public interface CharacterService {
 
     CharacterDTO save(CharacterDTO dto);
     
     
     List<CharacterBasicDTO>getAllCharacters();
     
     //void removePais(Long id, Long idPais);
     
     void delete(String id);
}

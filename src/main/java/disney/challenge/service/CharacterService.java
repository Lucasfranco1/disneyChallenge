/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.service;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import disney.challenge.entities.CharacterEntity;
import java.util.List;
import java.util.Set;


public interface CharacterService {
 
     List<CharacterDTO> getAllCharacters();

    List<CharacterBasicDTO> getBasicCharList();

    CharacterDTO modify(Long id, CharacterDTO charDTO);

    CharacterDTO save(CharacterDTO charDTO);

    CharacterEntity getCharById(String id);

    void delete(Long id);

    List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> movies, String order);

    CharacterDTO getDetailById(Long id);

    void addMovie(Long id, Long idMovie);

    void removeMovie(Long id, Long idMovie);
}

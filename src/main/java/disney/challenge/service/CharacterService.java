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

    List<CharacterBasicDTO> getBasicCharacterList();

    CharacterDTO modify(String id, CharacterDTO charDTO);

    CharacterDTO save(CharacterDTO charDTO);

    CharacterEntity getCharacterById(String id);

    void delete(String id);

    List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> movies, String order);

    CharacterDTO getDetailById(String id);

    void addMovie(String id, String idMovie);

    void removeMovie(String id, String idMovie);
}

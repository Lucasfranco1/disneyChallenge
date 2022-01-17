
package disney.challenge.service;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import disney.challenge.dto.CharacterFilterDTO;
import disney.challenge.entities.CharacterEntity;
import disney.challenge.entities.MovieEntity;
import disney.challenge.exceptions.ParamNotFound;
import disney.challenge.mapper.CharacterMapper;
import disney.challenge.mapper.MovieMapper;
import disney.challenge.repository.CharacterRepository;
import disney.challenge.repository.specification.CharacterSpecification;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService{
            
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private MovieMapper movieMapper;
    
    @Lazy
    @Autowired
    private MovieService movieService;
    @Autowired
    private CharacterSpecification characterSpecification;

    @Override
    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> characterEntities = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(characterEntities, false);
        return result;
    }

    @Override
    public List<CharacterBasicDTO> getBasicCharacterList() {
        List<CharacterEntity> characterList = characterRepository.findAll();
        List<CharacterBasicDTO> resultDTO = characterMapper.basicEntityList2DTOBasicList(characterList);
        return resultDTO;
    }

    @Override
    public CharacterDTO modify(String id, CharacterDTO characterDTO) {
        CharacterEntity savedCharacter = this.getCharacterById(id);

        savedCharacter.setName(characterDTO.getName());
        savedCharacter.setImage(characterDTO.getImage());
        savedCharacter.setAge(characterDTO.getAge());
        savedCharacter.setWeight(characterDTO.getWeight());
        savedCharacter.setStory(characterDTO.getStory());

        savedCharacter.setAssociatedMovies(movieMapper.movieDTOList2EntityList(characterDTO.getAssociatedMovies(), false));

        CharacterEntity editedCharacter = characterRepository.save(savedCharacter);

        CharacterDTO savedDTO = characterMapper.characterEntity2DTO(editedCharacter, false);

        return savedDTO;
    }

    @Override
    public CharacterDTO save(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();

        characterEntity.setName(characterDTO.getName());
        characterEntity.setImage(characterDTO.getImage());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setWeight(characterDTO.getWeight());
        characterEntity.setStory(characterDTO.getStory());

        CharacterEntity savedCharacter = characterRepository.save(characterEntity);
        CharacterDTO savedDTO = characterMapper.characterEntity2DTO(savedCharacter, false);

        return savedDTO;
    }

    @Override
    public CharacterEntity getCharacterById(String id) {

        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        if (!characterEntity.isPresent()) {
            throw new ParamNotFound("This characater does not exist."+ id);
        }
        return characterEntity.get();
    }

    @Override
    public void delete(String id) {
        characterRepository.deleteById(id);
    }

    @Override
    public List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> movies, String order) {
        CharacterFilterDTO characterFilter = new CharacterFilterDTO(name, age, movies, order);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(characterFilter));
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities, true);

        return result;
    }

    @Override
    public CharacterDTO getDetailById(String id) {
        CharacterEntity characterEntity = this.getCharacterById(id);
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntity, true);
        return result;
    }

    @Override
    public void addMovie(String id, String idMovie) {
        CharacterEntity characterEntity = characterRepository.getById(id);
        characterEntity.getAssociatedMovies().size();
        MovieEntity movie = this.movieService.getById(idMovie);
        characterEntity.getAssociatedMovies().add(movie);
        this.characterRepository.save(characterEntity);
    }

    @Override
    public void removeMovie(String id, String idMovie) {
        CharacterEntity characterEntity = characterRepository.getById(id);
        characterEntity.getAssociatedMovies().size();
        MovieEntity movie = this.movieService.getById(idMovie);
        characterEntity.getAssociatedMovies().remove(movie);
        this.characterRepository.save(characterEntity);
    }
}

package disney.challenge.service;

import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.dto.MovieFilterDTO;
import disney.challenge.entities.CharacterEntity;
import disney.challenge.entities.MovieEntity;
import disney.challenge.exceptions.ParamNotFound;
import disney.challenge.mapper.MovieMapper;
import disney.challenge.repository.MovieRepository;
import disney.challenge.repository.specification.MovieSpecification;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterService characterservice;
      @Autowired
    private MovieSpecification movieSpecification;

    @Override
    public MovieDTO save(MovieDTO movie) {
        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movie, true);
        MovieEntity movieSaved = movieRepository.save(movieEntity);
        MovieDTO result = movieMapper.movieEntity2DTO(movieSaved, false);
        return result;
    }


   
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities, true);

        return result;
    }


    public void deleteMovieById(String id) {
        movieRepository.deleteById(id);
    }


    public List<MovieBasicDTO> getBasicList() {
        List<MovieEntity> movieList = movieRepository.findAll();
        List<MovieBasicDTO> resultDTO = movieMapper.entityList2BasicDTO(movieList);
        return resultDTO;
    }


    public MovieDTO modify(String id, MovieDTO movieDTO) {
        MovieEntity savedMovie = this.getById(id);

        savedMovie.setImage(movieDTO.getImage());
        savedMovie.setTitle(movieDTO.getTitle());

        String date = movieDTO.getCreationDate().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate transformedDate = LocalDate.parse(date, formatter);
        savedMovie.setCreationDate(transformedDate);

        savedMovie.setQualification(movieDTO.getQualification());
        
        

        MovieEntity movieEntity = movieRepository.save(savedMovie);
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntity, false);

        return result;
    }

   
    public void addCharacter(String movieId, String characterId) {
        MovieEntity movieEntity = this.getById(movieId);
        movieEntity.getAssociatedCharacters().size();

        CharacterEntity character = characterservice.getCharById(characterId);
        movieEntity.getAssociatedCharacters().add(character);
        movieRepository.save(movieEntity);
    }

    
    public MovieEntity getById(String id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if (!movieEntity.isPresent()) {
            throw new ParamNotFound("Movie does not exist.");
        }
        return movieEntity.get();
    }

   
    public MovieDTO getByDetails(String id) {
        MovieEntity movieEntity = this.getById(id);
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntity, true);
        return result;
    }

   
    

    public List<MovieDTO> getByFilters(String title, Set<Long> gender, String order) {
        MovieFilterDTO movieFilters = new MovieFilterDTO(title, gender, order);
        List<MovieEntity> entityList = movieRepository.findAll(movieSpecification.getFiltered(movieFilters));
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entityList, true);
        return result;
    }

    
    
    
}

package disney.challenge.service;

import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.entities.MovieEntity;
import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save(MovieDTO movie); //Save movie

    List<MovieDTO> getAllMovies(); //List all movies

    List<MovieBasicDTO> getBasicList(); //Basic list movies

    void deleteMovieById(String id);

    MovieDTO modify(String id, MovieDTO movieDTO);

    void addCharacter(String movieId, String characterId);

    MovieEntity getById(String id);

    MovieDTO getByDetails(String id);
    

    List<MovieDTO> getByFilters(String name, Set<Long> genre, String order);
}

package disney.challenge.service;

import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieBasicDTO> getAllMovies();

    //void removePais(Long id, Long idPais);
    void delete(String id);
}

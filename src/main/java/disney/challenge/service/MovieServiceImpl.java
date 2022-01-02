package disney.challenge.service;

import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.entities.MovieEntity;
import disney.challenge.mapper.MovieMapper;
import disney.challenge.repository.MovieRepository;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private MovieMapper movieMapper;
    
    
    
    
    public MovieDTO save(MovieDTO dto) {
        try {
            MovieEntity entity= movieMapper.movieDTO2Entity(dto);
            MovieEntity saveEntity=movieRepository.save(entity);
            MovieDTO result=movieMapper.movieEntity2DTO(saveEntity);
            return result;
        } catch (ParseException ex) {
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public List<MovieBasicDTO> getAllMovies() {
       List<MovieEntity>entities=movieRepository.findAll();
       List<MovieBasicDTO>result=movieMapper.movieEntityList2DTOList(entities);
       return result;
        
        
    }

    
    public void delete(String id) {
    
    }
    
}

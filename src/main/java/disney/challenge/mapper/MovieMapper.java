package disney.challenge.mapper;

import disney.challenge.dto.CharacterDTO;
import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.entities.CharacterEntity;
import disney.challenge.entities.MovieEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.java.SimpleFormatter;

public class MovieMapper {
    @Autowired
    private CharacterMapper characterMapper;
            

//    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, Boolean loadCharacters) {
//        List<MovieDTO>dtos=new ArrayList();
//        for (MovieEntity aux : entities) {            
//            dtos.add(movieEntity2DTO(aux, loadCharacters));
//        }
//        return dtos;
//    }
    public MovieEntity movieDTO2Entity(MovieDTO dto) throws ParseException {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setCreationDate(formatterDate(dto.getCreationDate()));
        movieEntity.setQualification(dto.getQualification());
        movieEntity.setAssociatedCharacters(dto.getAssociatedCharacters());
        return movieEntity;

    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters) {
        MovieDTO movieDTO= new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImage(entity.getImage());
        movieDTO.setTitle(entity.getTitle());
        movieDTO.setCreationDate(entity.getCreationDate());
        movieDTO.setQualification(entity.getQualification());
        if(loadCharacters){
            List<CharacterDTO>charactersDTO= (List<CharacterDTO>) characterMapper.characterEntity2DTO((CharacterEntity) entity.getAssociatedCharacters(), false);
            movieDTO.setAssociatedCharacters(charactersDTO);
        }
        
        return movieDTO;
    }
    
    
    private MovieBasicDTO movieEntity2DTOBasic(MovieEntity aux) {
        MovieBasicDTO movieBasicDto=new MovieBasicDTO();
        movieBasicDto.setId(aux.getId());
        movieBasicDto.setImage(aux.getImage());
        movieBasicDto.setTitle(aux.getTitle());
        movieBasicDto.setCreationDate(aux.getCreationDate());
        
        return movieBasicDto;
    }
    
    public List<MovieBasicDTO> movieEntityList2DTOList(List<MovieEntity> entities) {
        List<MovieBasicDTO>dtos=new ArrayList();
       
        for (MovieEntity aux : entities) {
            dtos.add(movieEntity2DTOBasic(aux));
                        
        }
        return dtos;
    }
    
    public Date formatterDate(Date dateFormatter) throws ParseException{
        Date date=new SimpleDateFormat().parse("yyyy-MM-dd");
        return date;
    }

    List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {
       List<MovieDTO>dtos=new ArrayList();
        for (MovieEntity aux : entities) {
            dtos.add(movieEntity2DTO(aux, loadCharacters));
        }
        return dtos;
    }
    
    

}

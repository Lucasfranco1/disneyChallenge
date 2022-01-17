package disney.challenge.mapper;


import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.entities.MovieEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Lazy
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private GenderMapper genderMapper;

    public MovieEntity movieDTO2Entity(MovieDTO dto, boolean loadCharacters) {
        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        String date = dto.getCreationDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate transformedDate = LocalDate.parse((CharSequence) date, formatter);
        movieEntity.setCreationDate(transformedDate);

        movieEntity.setQualification(dto.getQualification());
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity movieEntity, boolean load) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movieEntity.getId());
        dto.setImage(movieEntity.getImage());
        dto.setTitle(movieEntity.getTitle());
        LocalDate date = movieEntity.getCreationDate();
        String formatDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        dto.setCreationDate(formatDate);
        dto.setQualification(movieEntity.getQualification());
        if (load) {

            dto.setGenders(genderMapper.genderEntityList2DTOList(movieEntity.getGenders(), false));
        }
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean load) {
        List<MovieDTO> dtos = new ArrayList<>();

        for (MovieEntity entity : entities) {
            dtos.add(this.movieEntity2DTO(entity, false));

        }
        return dtos;
    }

    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtoList, boolean load) {
        List<MovieEntity> entities = new ArrayList<>();
        for (MovieDTO dto : dtoList) {
            entities.add(this.movieDTO2Entity(dto, false));
        }
        return entities;
    }

    public MovieBasicDTO entity2BasicDTO(MovieEntity movieEntity) {
        MovieBasicDTO dto = new MovieBasicDTO();

        dto.setImage(movieEntity.getImage());
        dto.setTitle(movieEntity.getTitle());

        LocalDate date = movieEntity.getCreationDate();
        String formatDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        dto.setCreationDate(formatDate);

        return dto;
    }

    public List<MovieBasicDTO> entityList2BasicDTO(List<MovieEntity> entities) {
        List<MovieBasicDTO> basicList = new ArrayList<>();
        for (MovieEntity entity : entities) {
            basicList.add(this.entity2BasicDTO(entity));
        }
        return basicList;
    }

}

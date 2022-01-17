package disney.challenge.service;



import disney.challenge.dto.GenderDTO;
import disney.challenge.entities.GenderEntity;
import disney.challenge.exceptions.ParamNotFound;
import disney.challenge.mapper.GenderMapper;
import disney.challenge.repository.GenderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GenderServiceImp implements GenderService {

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    
    public GenderDTO save(GenderDTO genderDto) {
        GenderEntity genderEntity = genderMapper.genderDTO2Entity(genderDto); 
        GenderEntity genderSaved = genderRepository.save(genderEntity);

        
        GenderDTO result = genderMapper.genderEntity2DTO(genderSaved, false); 
        return result;
    }

    
    public List<GenderDTO> getAllGenders() {
        List<GenderEntity> entities = genderRepository.findAll();
        List<GenderDTO> result = genderMapper.genderEntityList2DTOList(entities, false);
        return result;
    }

    
    public GenderDTO modify(String id, GenderDTO genderDTO) {
        GenderEntity savedGender = this.getById(id);
        savedGender.setName(genderDTO.getName());
        GenderEntity editedGender = genderRepository.save(savedGender);
        GenderDTO result = genderMapper.genderEntity2DTO(editedGender, false);
        return result;
    }

    
    public void deleteGenderById(String id) {
        genderRepository.deleteById(id);
    }

    public GenderEntity getById(String id) {
        Optional<GenderEntity> genderEntity = genderRepository.findById(id);
        if (!genderEntity.isPresent()) {
            throw new ParamNotFound("Genre does not exist: " + id);
        }
        return genderEntity.get();
    }

  
}

package disney.challenge.service;


import disney.challenge.dto.GenderDTO;
import java.util.List;



public interface GenderService {

    GenderDTO save(GenderDTO dto);

    List<GenderDTO> getAllGenders();

    GenderDTO modify(String id, GenderDTO genderDTO);

    void deleteGenderById(String id);
}


package disney.challenge.mapper;

import disney.challenge.dto.GenderDTO;
import disney.challenge.entities.GenderEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {
    public GenderEntity genderDTO2Entity(GenderDTO dto) {
        GenderEntity genderEntity = new GenderEntity();
        genderEntity.setName(dto.getName());
        
        return genderEntity;
    }

    public GenderDTO genderEntity2DTO(GenderEntity genderEntity, boolean loadMovie) {
        GenderDTO dto = new GenderDTO();
        dto.setId(genderEntity.getId());
        dto.setName(genderEntity.getName());
        

        return dto;
    }

    public List<GenderDTO> genderEntityList2DTOList(List<GenderEntity> entities, boolean loadMovie) {
        List<GenderDTO> dtoList = new ArrayList<>();

        for (GenderEntity entity : entities) {
            dtoList.add(this.genderEntity2DTO(entity, loadMovie));
        }
        return dtoList;
    }
    public List<GenderEntity> genderDTOList2EntityList(List<GenderDTO> dtoList, boolean load) {
        List<GenderEntity> entities = new ArrayList<>();

        for (GenderDTO dto : dtoList) {
            entities.add(this.genderDTO2Entity(dto));
        }
        return entities;
    }
}

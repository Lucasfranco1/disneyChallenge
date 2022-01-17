
package disney.challenge.repository;

import disney.challenge.entities.CharacterEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, String> {
    
     List<CharacterEntity> findAll(Specification<CharacterEntity> entitySpecification);
}

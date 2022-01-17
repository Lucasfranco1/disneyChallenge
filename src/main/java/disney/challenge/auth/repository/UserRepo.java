
package disney.challenge.auth.repository;


import disney.challenge.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
   UserEntity findByUsername(String username);
}

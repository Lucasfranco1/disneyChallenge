package disney.challenge.auth.service;


import disney.challenge.auth.dto.UserDTO;
import disney.challenge.auth.entity.UserEntity;
import disney.challenge.auth.repository.UserRepo;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("Username or password not found.");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepo.save(userEntity);
        if (userEntity != null) {
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;

    }
}

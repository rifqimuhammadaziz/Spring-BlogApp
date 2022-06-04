package rifqimuhammadaziz.springblogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springblogapp.model.entity.AppUser;
import rifqimuhammadaziz.springblogapp.model.repository.AppUserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public AppUser registerUser(AppUser user) {
        // Check if user already exist
        boolean isUserExist = appUserRepository.findAllByEmail(user.getEmail()).isPresent();
        if (isUserExist) {
            throw new RuntimeException(
                    String.format("User with email '%s' is already exists", user.getEmail())
            );
        }

        // Register user
        user.setFullName(user.getFullName());
        user.setEmail(user.getEmail());
        user.setAppUserRole(user.getAppUserRole());
        user.setPassword(user.getPassword());
        return appUserRepository.save(user);
    }
}

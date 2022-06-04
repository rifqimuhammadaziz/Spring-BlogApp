package rifqimuhammadaziz.springblogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springblogapp.model.entity.AppUser;
import rifqimuhammadaziz.springblogapp.model.repository.AppUserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                    new UsernameNotFoundException(String.format("User with email '%s' not found", email)));
    }

    public AppUser registerUser(AppUser user) {
        // Check if user already exist
        boolean isUserExist = appUserRepository.findByEmail(user.getEmail()).isPresent();
        if (isUserExist) {
            throw new RuntimeException(
                    String.format("User with email '%s' is already exists", user.getEmail())
            );
        }

        // Register user
//        user.setFullName(user.getFullName());
//        user.setEmail(user.getEmail());
//        user.setAppUserRole(user.getAppUserRole());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return appUserRepository.save(user);
    }

    public Iterable<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}

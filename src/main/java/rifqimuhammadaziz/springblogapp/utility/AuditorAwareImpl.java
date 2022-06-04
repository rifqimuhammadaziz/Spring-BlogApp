package rifqimuhammadaziz.springblogapp.utility;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import rifqimuhammadaziz.springblogapp.model.entity.AppUser;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Get active user
        AppUser activeUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Return email of active user
        return Optional.of(activeUser.getEmail());
    }
}

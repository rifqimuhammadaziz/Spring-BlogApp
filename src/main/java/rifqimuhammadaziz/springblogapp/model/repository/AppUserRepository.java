package rifqimuhammadaziz.springblogapp.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springblogapp.model.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

    Optional<AppUser> findAllByEmail(String email);
}

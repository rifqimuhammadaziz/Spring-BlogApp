package rifqimuhammadaziz.springblogapp.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springblogapp.model.entity.Tag;

import java.util.List;

public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {

    Tag findTagByName(String name);

    List<Tag> findTagByNameContains(String name);
}

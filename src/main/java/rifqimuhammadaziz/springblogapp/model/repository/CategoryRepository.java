package rifqimuhammadaziz.springblogapp.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springblogapp.model.entity.Category;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    Category findCategoryByName(String name);

    List<Category> findCategoryByNameContains(String name);
}

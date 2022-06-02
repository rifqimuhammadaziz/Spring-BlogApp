package rifqimuhammadaziz.springblogapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springblogapp.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}

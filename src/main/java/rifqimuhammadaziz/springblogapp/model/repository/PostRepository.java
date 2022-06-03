package rifqimuhammadaziz.springblogapp.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springblogapp.model.entity.Post;

import javax.websocket.server.PathParam;
import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findPostByTitle(String postTitle);

    List<Post> findPostsByTitleContains(String postTitle);

    List<Post> findPostsByCategoryId(Long id);

//    @Query("SELECT p FROM Post p WHERE p.category.name = :postCategory")
//    List<Post> findPostsByCategory(@PathParam("postCategory") String postCategory);

    List<Post> findPostsByCategoryName(String postCategory);
}

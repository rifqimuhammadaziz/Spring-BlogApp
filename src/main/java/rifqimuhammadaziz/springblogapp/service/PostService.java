package rifqimuhammadaziz.springblogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springblogapp.model.entity.Post;
import rifqimuhammadaziz.springblogapp.model.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    /*
    INSERT NEW / UPDATE POST
     */
    public Post save(Post post) {
        return postRepository.save(post);
    }

    /*
    FIND ALL POSTS
     */
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    /*
    FIND SINGLE POST BY ID
     */
    public Post findById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            return null;
        }
        return post.get();
    }

    /*
    DELETE SINGLE POST BY ID
     */
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }


    /*
    SEARCH POST BY TITLE
     */
    public Post findPostByTitle(String postTitle) {
        return postRepository.findPostByTitle(postTitle);
    }

    /*
    FIND ALL POSTS BY TITLE CONTAINS
     */
    public List<Post> findPostsByTitleContains(String postTitle) {
        return postRepository.findPostsByTitleContains(postTitle);
    }

    /*
    FIND ALL POSTS BY CATEGORY NAME
     */
    public List<Post> findPostsByCategoryName(String postCategory) {
        return postRepository.findPostsByCategoryName(postCategory);
    }
}

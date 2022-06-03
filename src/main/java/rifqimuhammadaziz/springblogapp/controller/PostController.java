package rifqimuhammadaziz.springblogapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springblogapp.dto.PostData;
import rifqimuhammadaziz.springblogapp.dto.ResponseData;
import rifqimuhammadaziz.springblogapp.dto.SearchData;
import rifqimuhammadaziz.springblogapp.model.entity.Post;
import rifqimuhammadaziz.springblogapp.service.PostService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Post>> create(@Valid @RequestBody PostData postData, Errors errors) {
        ResponseData<Post> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // Transform object postData to Post
        Post post = modelMapper.map(postData, Post.class);
        responseData.setStatus(true);
        responseData.getMessages().add("Post successfully saved");
        responseData.setData(postService.save(post));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Long postId) {
        return postService.findById(postId);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Post>> update(@Valid @RequestBody Post post, Errors errors) {
        ResponseData<Post> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.getMessages().add("Post " + post.getTitle() + " successfully updated");
        responseData.setData(postService.save(post));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long postId) {
        postService.deleteById(postId);
    }

    @PostMapping("/search/title")
    public Post findPostByTitle(@RequestBody SearchData searchData) {
        return postService.findPostByTitle(searchData.getSearchKey());
    }

    @PostMapping("/search/title/like")
    public List<Post> findPostsByTitleContains(@RequestBody SearchData searchData) {
        return postService.findPostsByTitleContains(searchData.getSearchKey());
    }

    @PostMapping("/search/category")
    public List<Post> findPostsByCategoryName(@RequestBody SearchData searchData) {
        return postService.findPostsByCategoryName(searchData.getSearchKey());
    }
}

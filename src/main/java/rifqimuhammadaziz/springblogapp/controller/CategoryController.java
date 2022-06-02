package rifqimuhammadaziz.springblogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springblogapp.entity.Category;
import rifqimuhammadaziz.springblogapp.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*
    Save Category
     */
    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /*
    Get All Category
     */
    @GetMapping
    public Iterable<Category> getAll() {
        return categoryService.findAll();
    }

    /*
    Get Category By ID
     */
    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") Long categoryId) {
        return categoryService.findById(categoryId);
    }

    /*
    Get Single Category By Name
     */
    @GetMapping("/name/{name}")
    public Category getByName(@PathVariable("name") String categoryName) {
        return categoryService.findByName(categoryName);
    }

    /*
    Get All Category By Name Contains
     */
    @GetMapping("/contains/{name}")
    public List<Category> getByNameContains(@PathVariable("name") String categoryName) {
        return categoryService.findByNameContains(categoryName);
    }

    /*
    Update Category By ID
     */
    @PutMapping("/{id}")
    public Category updateById(@PathVariable("id") Long categoryId, @RequestBody Category category) {
        Category findCategory = categoryService.findById(categoryId);
        findCategory.setName(category.getName());
        return categoryService.save(findCategory);
    }

    /*
    Delete Category By ID
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long categoryId) {
        categoryService.deleteById(categoryId);
    }

//    public ResponseEntity<Category> create(@RequestBody Category category) {
//        return categoryService.save(category);
//    }
}

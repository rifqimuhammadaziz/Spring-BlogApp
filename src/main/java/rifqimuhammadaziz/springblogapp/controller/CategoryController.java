package rifqimuhammadaziz.springblogapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springblogapp.dto.CategoryData;
import rifqimuhammadaziz.springblogapp.dto.ResponseData;
import rifqimuhammadaziz.springblogapp.model.entity.Category;
import rifqimuhammadaziz.springblogapp.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    /*
    Save Category
     */
    @PostMapping
    public ResponseEntity<ResponseData<Category>> save(@Valid @RequestBody CategoryData categoryData, Errors errors) {
        ResponseData<Category> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // Transform object categoryData to Category
        Category category = modelMapper.map(categoryData, Category.class);
        responseData.setStatus(true);
        responseData.getMessages().add(category.getName() + " succesfully saved");
        responseData.setData(categoryService.save(category));

        return ResponseEntity.ok(responseData);
    }

    /*
    Get All Category
     */
    @GetMapping
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    /*
    Get Category By ID
     */
    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long categoryId) {
        return categoryService.findById(categoryId);
    }

    /*
    Get Single Category By Name
     */
    @GetMapping("/name/{name}")
    public Category findByName(@PathVariable("name") String categoryName) {
        return categoryService.findByName(categoryName);
    }

    /*
    Get All Category By Name Contains
     */
    @GetMapping("/contains/{name}")
    public List<Category> findByNameContains(@PathVariable("name") String categoryName) {
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

    @PutMapping
    public ResponseEntity<ResponseData<Category>> update(@Valid @RequestBody CategoryData categoryData, Errors errors) {
        ResponseData<Category> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // Transform object categoryData to Category
        Category category = modelMapper.map(categoryData, Category.class);
        responseData.setStatus(true);
        responseData.getMessages().add("Category with Id: " + category.getId() + " succesfully updated");
        responseData.setData(categoryService.save(category));

        return ResponseEntity.ok(responseData);
    }

    /*
    Delete Category By ID
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long categoryId) {
        categoryService.deleteById(categoryId);
    }
}

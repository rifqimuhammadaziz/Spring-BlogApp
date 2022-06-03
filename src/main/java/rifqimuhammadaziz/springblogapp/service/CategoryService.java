package rifqimuhammadaziz.springblogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springblogapp.model.entity.Category;
import rifqimuhammadaziz.springblogapp.model.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /*
    INSERT NEW / UPDATE CATEGORY
     */
    public Category save(Category category) {
        // Update
        if (category.getId() != null) {
            Category currentCategory = categoryRepository.findById(category.getId()).get();
            currentCategory.setName(category.getName());
            category = currentCategory;
        }
        // Create New
        return categoryRepository.save(category);
    }

    /*
    FIND ALL CATEGORIES
     */
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    /*
    FIND SINGLE CATEGORY BY ID
     */
    public Category findById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            return null;
        }
        return category.get();
    }

    /*
    FIND SINGLE CATEGORY BY NAME
     */
    public Category findByName(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        return category;
    }

    /*
    FIND ALL CATEGORY BY NAME
     */
    public List<Category> findByNameContains(String categoryName) {
        return categoryRepository.findCategoryByNameContains(categoryName);
    }

    /*
    DELETE SINGLE CATEGORY BY ID
     */
    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

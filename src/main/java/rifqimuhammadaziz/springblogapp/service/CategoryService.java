package rifqimuhammadaziz.springblogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springblogapp.entity.Category;
import rifqimuhammadaziz.springblogapp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            return null;
        }
        return category.get();
    }

    public Category findByName(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        return category;
    }
    public List<Category> findByNameContains(String categoryName) {
        return categoryRepository.findCategoryByNameContains(categoryName);
    }

    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

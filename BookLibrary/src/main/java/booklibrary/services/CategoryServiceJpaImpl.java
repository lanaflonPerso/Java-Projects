package booklibrary.services;

import booklibrary.models.Category;
import booklibrary.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hristo on 27.08.2016 г..
 */
@Service
public class CategoryServiceJpaImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() { return this.categoryRepository.findAll(); }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

}

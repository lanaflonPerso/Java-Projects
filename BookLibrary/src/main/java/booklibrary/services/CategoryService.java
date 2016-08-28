package booklibrary.services;

import booklibrary.models.Category;

import java.util.List;

/**
 * Created by Hristo on 27.08.2016 г..
 */
public interface CategoryService {
    List<Category> findAll();
    Category create(Category category);
}

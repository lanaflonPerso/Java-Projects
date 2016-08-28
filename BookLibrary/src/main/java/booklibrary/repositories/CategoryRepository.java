package booklibrary.repositories;

import booklibrary.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends
        JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}

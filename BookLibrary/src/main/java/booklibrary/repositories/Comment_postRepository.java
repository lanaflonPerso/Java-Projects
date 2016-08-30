package booklibrary.repositories;

import booklibrary.models.Category;
import booklibrary.models.Comment_post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Comment_postRepository extends
        JpaRepository<Comment_post, Long> {
}

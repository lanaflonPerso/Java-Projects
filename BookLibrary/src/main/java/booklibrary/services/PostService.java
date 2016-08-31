package booklibrary.services;

import booklibrary.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.method.P;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    List<Post> findAllByVisits();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
    Page<Post> findAllPageable(Pageable pageable);
    Iterable<Post> save(Iterable<Post> persons);
}
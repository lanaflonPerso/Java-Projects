package booklibrary.services;

import booklibrary.models.Post;
import booklibrary.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Transactional
    @Override
    public Page<Post> findAllPageable(Pageable pageable) { return postRepo.findAll(pageable); }

    @Transactional
    @Override
    public Iterable<Post> save(Iterable<Post> persons) {
        return postRepo.save(persons);
    }

    @Override
    public List<Post> findAll() { return this.postRepo.findAll(); }

    @Override
    public List<Post> findLatest5() {
        return this.postRepo.findLatest5Posts(new PageRequest(0, 5));
    }

    @Override
    public List<Post> findAllByVisits() {
        return this.postRepo.findAllPostsByVisits();
    }

    @Override
    public Post findById(Long id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) { this.postRepo.delete(id); }
}
package booklibrary.services;

import booklibrary.models.Category;
import booklibrary.models.Comment_post;
import booklibrary.models.Post;
import booklibrary.repositories.CategoryRepository;
import booklibrary.repositories.Comment_postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hristo on 27.08.2016 г..
 */
@Service
public class Comment_postServiceJpaImpl implements Comment_postService{

    @Autowired
    Comment_postRepository comment_postRepository;

    @Override
    public List<Comment_post> findAll() { return this.comment_postRepository.findAll(); }

    @Override
    public Comment_post create(Comment_post comment_post) {
        return this.comment_postRepository.save(comment_post);
    }

    @Override
    public Comment_post findById(Long id){ return this.comment_postRepository.findOne(id); }

    @Override
    public void deleteById(Long id){ this.comment_postRepository.delete(id);}
}

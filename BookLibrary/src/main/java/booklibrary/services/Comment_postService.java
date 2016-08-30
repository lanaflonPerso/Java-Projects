package booklibrary.services;

import booklibrary.models.Category;
import booklibrary.models.Comment_event;
import booklibrary.models.Comment_post;
import booklibrary.models.Post;

import java.util.List;

/**
 * Created by Hristo on 27.08.2016 г..
 */
public interface Comment_postService {
    List<Comment_post> findAll();
    Comment_post create(Comment_post comment_post);
    Comment_post findById(Long id);
    void deleteById(Long id);
}

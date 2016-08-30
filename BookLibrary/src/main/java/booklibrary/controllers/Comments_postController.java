package booklibrary.controllers;

import booklibrary.forms.CategoryForm;
import booklibrary.forms.CommentForm;
import booklibrary.models.Category;
import booklibrary.models.Comment_post;
import booklibrary.models.Post;
import booklibrary.models.User;
import booklibrary.repositories.Comment_postRepository;
import booklibrary.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hristo on 27.08.2016 г..
 */
@Controller
public class Comments_postController {

    @Autowired
    NotificationService notifyService;

    @Autowired
    Comment_postRepository comment_postRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    Comment_postService comment_postService;

    @RequestMapping("/comments_post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,  CommentForm commentForm){

        Comment_post comment_post = comment_postRepository.findOne(id);

        model.addAttribute("commentForm", commentForm);
        model.addAttribute("comment_post", comment_post);

        return "comments_post/edit";
    }

    @RequestMapping("**/changeComment/{id}")
    public String saveProduct(@PathVariable("id") Long id, @ModelAttribute("comment_postForm") Comment_post comment_post, @Valid CommentForm commentForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        Comment_post comment_postById = comment_postRepository.findOne(id);

        List<Post> posts = postService.findAll();

        Post post = new Post();

        for (Post p : posts) {
            if(p.getCmntposts().contains(comment_postById)){
                post = p;
            }
        }

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User currentUser = userService.findUserByUsername(user.getUsername());

        comment_postById.setTextComment(commentForm.getTextComment());
        comment_postById.setDateComment(new Date());
        comment_postById.setUser(currentUser);
        comment_postById.setIdpost(post);

        comment_postService.create(comment_postById);

        List<Comment_post> comment_posts = comment_postService.findAll();

        List<Comment_post> comment_postByPost = new ArrayList<>();

        for ( Comment_post comment_post2 : comment_posts) {
            if(comment_post2.getPost() == post)
                comment_postByPost.add(comment_post2);
        }

        model.addAttribute("post", post);
        model.addAttribute("comment_postByPost", comment_postByPost);
        model.addAttribute("currentUser", currentUser);

        notifyService.addInfoMessage("Comment change successful");
        return "posts/details";
    }

    @RequestMapping(value = "/comments_post/confirmdelete/{id}", method = RequestMethod.POST)
    public String ConfirmDeletePost(@PathVariable("id") Long id, @ModelAttribute("comment_postForm") Comment_post comment_post, Model model){

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User currentUser = userService.findUserByUsername(user.getUsername());

        Comment_post comment_postById = comment_postRepository.findOne(id);

        List<Post> posts = postService.findAll();

        Post post = new Post();

        for (Post p : posts) {
            if(p.getCmntposts().contains(comment_postById)){
                post = p;
            }
        }
        model.addAttribute("post", post);

        comment_postService.deleteById(id);

        List<Comment_post> comment_posts = comment_postService.findAll();

        List<Comment_post> comment_postByPost = new ArrayList<>();

        for ( Comment_post comment_post2 : comment_posts) {
            if(comment_post2.getPost() == post)
                comment_postByPost.add(comment_post2);
        }

        model.addAttribute("comment_postByPost", comment_postByPost);
        model.addAttribute("currentUser", currentUser);

        notifyService.addInfoMessage("Comment delete successful");
        return "redirect:/posts/details";
    }

    @RequestMapping("/comments_post/confirmdelete/{id}")
    public String deletePost(@PathVariable("id") Long id, Model model) {
        Comment_post comment_post = comment_postService.findById(id);

        model.addAttribute("comment_post", comment_post);

        return "comments_post/delete";
    }


}

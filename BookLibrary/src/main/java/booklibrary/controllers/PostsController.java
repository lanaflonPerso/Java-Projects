package booklibrary.controllers;

import booklibrary.forms.CreatePostForm;
import booklibrary.models.Category;
import booklibrary.models.Post;
import booklibrary.models.User;
import booklibrary.pagination.Pager;
import booklibrary.repositories.CategoryRepository;
import booklibrary.services.CategoryService;
import booklibrary.services.NotificationService;
import booklibrary.services.PostService;
import booklibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostsController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10, 20 };

    @Autowired
    private UserService userService;


    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts/index")
    public ModelAndView showPostPage(@RequestParam(value= "pageSize", required = false) Integer pageSize, @RequestParam(value = "page", required = false) Integer page){
        ModelAndView modelAndView = new ModelAndView("posts/index");

        int evalPageSize = pageSize == null ? INITIAL_PAGE_SIZE : pageSize;

        int evalPage = (page == null || page < 1) ? INITIAL_PAGE : page - 1;

        Page<Post> posts = postService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(posts.getTotalPages(), posts.getNumber(), BUTTONS_TO_SHOW);

        List<Category> allCategories = categoryService.findAll();

        modelAndView.addObject("posts", posts);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("allCategories", allCategories);

        return modelAndView;
    }

    @RequestMapping("/posts/create")
    public String createPost(CreatePostForm createPostForm, Model model) {

        List<Category> allCategories = categoryRepository.findAll();

        model.addAttribute("allCategories", allCategories);

        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String registerPage(@Valid CreatePostForm createPostForm, BindingResult bindingResult, @ModelAttribute("postForm") Post post) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "posts/create";
        }
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User myUser = userService.findUserByUsername(user.getUsername());

        post.setTitle(createPostForm.getTitle());
        post.setBody(createPostForm.getBody());
        post.setDate(new Date());
        post.setAuthor(myUser);
        post.setCategory(createPostForm.getCategory());

        postService.create(post);

        notifyService.addInfoMessage("Post create successful");
        return "redirect:/posts/index";
    }


    @RequestMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") Long id){
        postService.deleteById(id);
        notifyService.addInfoMessage("Post delete successful");
        return "redirect:/posts/index";
    }

    @RequestMapping("/posts/confirmdelete/{id}")
    public String deletePost(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "posts/delete";
    }

    @RequestMapping("/posts/details/{id}")
    public String detailsPost(@PathVariable("id") Long id, Model model){

        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "posts/details";
    }

    @RequestMapping("/posts/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, CreatePostForm createPostForm){

        List<Category> allCategories = categoryRepository.findAll();

        model.addAttribute("allCategories", allCategories);

        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "posts/edit";
    }

    @RequestMapping("**/changePost/{id}")
    public String saveProduct(@PathVariable("id") Long id, @ModelAttribute("postForm") Post post, @Valid CreatePostForm createPostForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        Post myPost = postService.findById(id);

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User myUser = userService.findUserByUsername(user.getUsername());

        post.setTitle(createPostForm.getTitle());
        post.setBody(createPostForm.getBody());
        post.setDate(new Date());
        post.setAuthor(myUser);
        post.setCategory(createPostForm.getCategory());

        postService.edit(post);
        notifyService.addInfoMessage("Post change successful");
        return "redirect:/posts/index";
    }

    @RequestMapping("/posts/index/{categoryName}")
    public String postsByCategory(@PathVariable("categoryName") String categoryName, Model model){

        Category category = categoryRepository.findCategoryByName(categoryName);

        List<Post> allPosts = postService.findAll();

        List<Post> postsByCategory = new ArrayList<>();

        for (Post post : allPosts) {
            if(post.getCategory() == category){
                postsByCategory.add(post);
            }
        }

        model.addAttribute("postsByCategory", postsByCategory);

        return "posts/postsByCategory";
    }
}


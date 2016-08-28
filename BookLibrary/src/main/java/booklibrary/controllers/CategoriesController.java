package booklibrary.controllers;

import booklibrary.forms.CategoryForm;
import booklibrary.forms.CreatePostForm;
import booklibrary.models.Category;
import booklibrary.models.Post;
import booklibrary.models.User;
import booklibrary.services.CategoryService;
import booklibrary.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Hristo on 27.08.2016 г..
 */
@Controller
public class CategoriesController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    NotificationService notifyService;

    @RequestMapping("/categories/add")
    public String addCategory(CategoryForm categoryForm){
        return "categories/add";
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("catForm") Category category, @Valid CategoryForm categoryForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "categories/add";
        }

        category.setName(categoryForm.getName());
        category.setType(categoryForm.getType());
        category.setAbout(categoryForm.getAbout());

        categoryService.create(category);

        notifyService.addInfoMessage("CategoryName create successful");
        return "redirect:/posts/create";
    }
}

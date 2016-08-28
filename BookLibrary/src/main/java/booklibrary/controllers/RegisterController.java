package booklibrary.controllers;

import booklibrary.forms.RegisterForm;
import booklibrary.models.User;
import booklibrary.services.NotificationService;
import booklibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Hristo on 05.08.2016 г..
 */

@Controller
public class RegisterController {

    @Autowired UserService userService;

    @Autowired NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
        public String registerPage(@ModelAttribute("userForm") User user, @Valid RegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        user.setUsername(registerForm.getUsername());
        user.setPassword_hash(registerForm.getPassword_hash());
        user.setFullname(registerForm.getFullname());
        user.setEmail(registerForm.getEmail());
        user.setRole("User");

        userService.create(user);

        notifyService.addInfoMessage("Register successful");
        return "redirect:/";
    }

}

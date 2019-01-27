package com.example.handson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.handson.entity.User;
import com.example.handson.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new UserCreateForm());
        return "create";
    }

    @PostMapping("/create")
    public String create(
            @ModelAttribute("userCreateForm") @Validated UserCreateForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("form", form);
            return "redirect:/users/create";
        }
        User user = new User();
        user.setName(form.getName());
        user.setAge(form.getAge());
        user.setGender(form.getGender());
        user.setImageUrl(form.getImageUrl());
        user.setHobby(form.getHobby());
        user.setSpeciality(form.getSpeciality());
        User savedUser = userRepository.save(user);

        redirectAttributes.addFlashAttribute("user", savedUser);
        redirectAttributes.addAttribute("id", savedUser.getId());
        return "redirect:/users/{id}";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}

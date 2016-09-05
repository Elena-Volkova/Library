package com.example.application.client.controller.admin;

import com.example.application.client.service.LibraryService;
import com.example.application.client.service.UserService;
import com.example.application.client.service.model.RoleEnum;
import com.example.application.client.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class AdminController {

    private final UserService userService;

    private final LibraryService libraryService;

    @Autowired
    public AdminController(UserService userService, LibraryService libraryService) {
        this.userService = userService;
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(@RequestParam(required = false) AdminMessage message) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        ModelAndView model = new ModelAndView();
        model.addObject("users", userService.getUsers(Arrays.asList(RoleEnum.ADMIN, RoleEnum.USER)));
        model.setViewName("get_users");
        return model;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public ModelAndView getUser() {
        ModelAndView model = new ModelAndView();
        model.addObject("user", new UserDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_user");
        return model;
    }

    @RequestMapping(value = "/admin/user/{userId}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUser(userId));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_user");
        return model;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute UserDTO user) {
        userService.add(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin?message=" + AdminMessage.USER_ADDED);
        return model;
    }

    @RequestMapping(value = "/admin/user/{userId}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable Long userId, @ModelAttribute UserDTO user) {
        userService.update(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin?message=" + AdminMessage.USER_UPDATED);
        return model;
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        userService.delete(userId);
        model.setViewName("redirect:/admin?message=" + AdminMessage.USER_DELETED);
        return model;
    }
}

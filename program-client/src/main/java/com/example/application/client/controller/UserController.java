package com.example.application.client.controller;

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
public class UserController {

    private final UserService userService;

    private final LibraryService libraryService;

    @Autowired
    public UserController(UserService userService, LibraryService libraryService) {
        this.userService = userService;
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ModelAndView getUsers(@RequestParam(required = false) UserMessage message) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        model.addObject("users", userService.getUsers(Arrays.asList(RoleEnum.ADMIN, RoleEnum.USER)));
        model.setViewName("get_users");
        return model;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public ModelAndView getUser() {
        ModelAndView model = new ModelAndView();
        UserDTO currentUser = userService.getCurrentUser();
        model.addObject("role", currentUser.getRole());
        model.addObject("user", new UserDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_user");
        return model;
    }

    @RequestMapping(value = "/admin/user/{userId}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        UserDTO currentUser = userService.getCurrentUser();
        model.addObject("role", currentUser.getRole());
        model.addObject("user", userService.getUser(userId));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_user");
        return model;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute UserDTO user) {
        userService.add(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/users?message=" + UserMessage.USER_ADDED);
        return model;
    }

    @RequestMapping(value = "/admin/user/{userId}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable Long userId, @ModelAttribute UserDTO user) {
        userService.update(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/users?message=" + UserMessage.USER_UPDATED);
        return model;
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        userService.delete(userId);
        model.setViewName("redirect:/admin/users?message=" + UserMessage.USER_DELETED);
        return model;
    }

    @RequestMapping(value = "/user/user", method = RequestMethod.GET)
    public ModelAndView getCurrentUser() {
        ModelAndView model = new ModelAndView();
        UserDTO currentUser = userService.getCurrentUser();
        model.addObject("role", currentUser.getRole());
        model.addObject("user", currentUser);
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_user");
        return model;
    }

    @RequestMapping(value = "/user/user", method = RequestMethod.POST)
    public ModelAndView updateCurrentUser(@ModelAttribute UserDTO user) {
        UserDTO currentUser = userService.getCurrentUser();
        user.setRole(currentUser.getRole());
        user.setLibraries(currentUser.getLibraries());
        userService.update(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/user/user?message=" + UserMessage.USER_UPDATED);
        return model;
    }
}

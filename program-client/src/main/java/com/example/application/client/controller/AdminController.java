package com.example.application.client.controller;

import com.example.application.client.service.LibraryService;
import com.example.application.client.service.UserService;
import com.example.application.client.service.model.LibraryDTO;
import com.example.application.client.service.model.RoleEnum;
import com.example.application.client.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin Controller
 */
@Controller
public class AdminController {

    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(
            @RequestParam(required = false) boolean libraryAdd,
            @RequestParam(required = false) boolean libraryUpdate,
            @RequestParam(required = false) boolean libraryDelete,
            @RequestParam(required = false) boolean userAdd,
            @RequestParam(required = false) boolean userUpdate,
            @RequestParam(required = false) boolean userDelete,
            @RequestParam(required = false) boolean error
    ) {
        ModelAndView model = new ModelAndView();
        if (libraryAdd) {
            model.addObject("msg", "Библиотека успешно добавлена!");
        }
        if (libraryUpdate) {
            model.addObject("msg", "Библиотека успешно обновлена!");
        }
        if (libraryDelete) {
            model.addObject("msg", "Библиотека успешно удалена!");
        }
        if (userAdd) {
            model.addObject("msg", "Сотрудник успешно создан!");
        }
        if (userUpdate) {
            model.addObject("msg", "Сотрудник успешно обновлен!");
        }
        if (userDelete) {
            model.addObject("msg", "Сотрудник успешно удален!");
        }
        if (error) {
            model.addObject("msg", "Сотрудник c такой же фамилией уже был создан создан!");
        }
        model.addObject("users", userService.getUsers());
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/admin/libraries", method = RequestMethod.GET)
    public ModelAndView getLibraries() {
        ModelAndView model = new ModelAndView();
        model.addObject("libraries", libraryService.getLibraries());
        model.setViewName("get_libraries");
        return model;
    }

    @RequestMapping(value = "/admin/library", method = RequestMethod.GET)
    public ModelAndView addLibrary() {
        ModelAndView model = new ModelAndView();
        model.addObject("library", new LibraryDTO());
        model.setViewName("add_library");
        return model;
    }

    @RequestMapping(value = "/admin/library", method = RequestMethod.POST)
    public ModelAndView addLibrary(@ModelAttribute LibraryDTO library) {
        libraryService.add(library);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin?libraryAdd=true");
        return model;
    }

    @RequestMapping(value = "/admin/library/{libraryId}", method = RequestMethod.GET)
    public ModelAndView getLibrary(@PathVariable Long libraryId) {
        ModelAndView model = new ModelAndView();
        model.setViewName("update_library");
        return model;
    }

    @RequestMapping(value = "/admin/library/{libraryId}", method = RequestMethod.PUT)
    public ModelAndView updateLibrary(@PathVariable Long libraryId, @ModelAttribute LibraryDTO libraryDTO) {
        libraryService.update(libraryDTO);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin?libraryUpdate=true");
        return model;
    }

    @RequestMapping(value = "/admin/library/{libraryId}/delete", method = RequestMethod.GET)
    public ModelAndView deleteLibrary(@PathVariable Long libraryId) {
        ModelAndView model = new ModelAndView();
        libraryService.delete(libraryId);
        model.setViewName("redirect:/admin?libraryDelete=true");
        return model;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView model = new ModelAndView();
        model.setViewName("add_user");
        return model;
    }

    @RequestMapping(value = "/admin/update/{userId}", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUser(userId));
        model.setViewName("update_user");
        return model;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute UserDTO user) {
        UserDTO userFromDatabase = userService.getUserByUsername(user.getLogin());
        ModelAndView model = new ModelAndView();
        if (userFromDatabase == null) {
            //user.setRole(RoleEnum.USER);
            userService.add(user);
            model.setViewName("redirect:/admin?successAdd=true");
        } else {
            model.setViewName("redirect:/admin?error=true");
        }
        return model;
    }

    @RequestMapping(value = "/admin/update/{userId}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable Long userId, @ModelAttribute UserDTO user) {
        UserDTO userFromDatabase = userService.getUserByUsername(user.getLogin());
        ModelAndView model = new ModelAndView();
        if (userFromDatabase == null || userFromDatabase.getId().equals(userId)) {
            UserDTO userDB = userService.getUser(userId);
            //user.setRole(userDB.getRole());
            userService.update(user);
            model.setViewName("redirect:/admin?successUpdate=true");
        } else {
            model.setViewName("redirect:/admin?error=true");
        }
        return model;
    }

    @RequestMapping(value = "/admin/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        userService.delete(userId);
        model.setViewName("redirect:/admin?successDelete=true");
        return model;
    }
}

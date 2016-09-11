package com.example.application.client.controller;

import com.example.application.client.service.LibraryService;
import com.example.application.client.service.SearchService;
import com.example.application.client.service.UserService;
import com.example.application.client.service.model.BookSearchDTO;
import com.example.application.client.service.model.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    private final SearchService searchService;

    private final LibraryService libraryService;

    private final UserService userService;

    @Autowired
    public SearchController(SearchService searchService, LibraryService libraryService, UserService userService) {
        this.searchService = searchService;
        this.libraryService = libraryService;
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/users_search", method = RequestMethod.GET)
    public ModelAndView getUsersSearch() {
        ModelAndView model = new ModelAndView();
        model.addObject("search", new UserSearchDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("get_users_search");
        return model;
    }

    @RequestMapping(value = "/admin/users_search", method = RequestMethod.POST)
    public ModelAndView performUsersSearch(@ModelAttribute UserSearchDTO search) {
        ModelAndView model = new ModelAndView();
        model.addObject("search", searchService.searchUsers(search));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("get_users_search");
        return model;
    }

    @RequestMapping(value = {"/admin/books_search", "/user/books_search"}, method = RequestMethod.GET)
    public ModelAndView getBooksSearch() {
        ModelAndView model = new ModelAndView();
        model.addObject("search", new BookSearchDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.addObject("role", userService.getCurrentUser().getRole());
        model.setViewName("get_books_search");
        return model;
    }

    @RequestMapping(value = {"/admin/books_search", "/user/books_search"}, method = RequestMethod.POST)
    public ModelAndView performBooksSearch(@ModelAttribute BookSearchDTO search) {
        ModelAndView model = new ModelAndView();
        model.addObject("search", searchService.searchBooks(search));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.addObject("role", userService.getCurrentUser().getRole());
        model.setViewName("get_books_search");
        return model;
    }
}

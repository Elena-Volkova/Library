package com.example.application.client.controller.admin;

import com.example.application.client.service.LibraryService;
import com.example.application.client.service.model.LibraryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/admin/libraries", method = RequestMethod.GET)
    public ModelAndView getLibraries(@RequestParam(required = false) AdminMessage message) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        model.addObject("libraries", libraryService.getLibraries());
        model.setViewName("get_libraries");
        return model;
    }

    @RequestMapping(value = "/admin/library", method = RequestMethod.GET)
    public ModelAndView getLibrary() {
        ModelAndView model = new ModelAndView();
        model.addObject("library", new LibraryDTO());
        model.setViewName("add_library");
        return model;
    }

    @RequestMapping(value = "/admin/library/{libraryId}", method = RequestMethod.GET)
    public ModelAndView getLibrary(@PathVariable Long libraryId) {
        ModelAndView model = new ModelAndView();
        model.addObject("library", libraryService.getLibrary(libraryId));
        model.setViewName("add_library");
        return model;
    }

    @RequestMapping(value = "/admin/library", method = RequestMethod.POST)
    public ModelAndView addLibrary(@ModelAttribute LibraryDTO library) {
        libraryService.add(library);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/libraries?message=" + AdminMessage.LIBRARY_ADDED);
        return model;
    }

    @RequestMapping(value = "/admin/library/{libraryId}", method = RequestMethod.POST)
    public ModelAndView updateLibrary(@PathVariable Long libraryId, @ModelAttribute LibraryDTO libraryDTO) {
        libraryService.update(libraryDTO);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/libraries?message=" + AdminMessage.LIBRARY_UPDATED);
        return model;
    }

    @RequestMapping(value = "/admin/libraries/{libraryId}", method = RequestMethod.GET)
    public ModelAndView deleteLibrary(@PathVariable Long libraryId) {
        ModelAndView model = new ModelAndView();
        libraryService.delete(libraryId);
        model.setViewName("redirect:/admin/libraries?message=" + AdminMessage.LIBRARY_DELETED);
        return model;
    }
}

package com.example.application.client.controller.admin;

import org.springframework.stereotype.Controller;

@Controller
public class TrackingController {
/*
    private final BookService trackingService;

    private final LibraryService libraryService;*/

    /*@Autowired
    public TrackingController(BookService trackingService, LibraryService libraryService) {
        this.trackingService = trackingService;
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/admin/trackings", method = RequestMethod.GET)
    public ModelAndView getBooks(@RequestParam(required = false) AdminMessage message) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        model.addObject("trackings", trackingService.getBooks());
        model.setViewName("statistic");
        return model;
    }

    @RequestMapping(value = "/admin/tracking", method = RequestMethod.GET)
    public ModelAndView getBook() {
        ModelAndView model = new ModelAndView();
        model.addObject("tracking", new BookDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_tracking");
        return model;
    }

    @RequestMapping(value = "/admin/tracking/{trackingId}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable Long trackingId) {
        ModelAndView model = new ModelAndView();
        model.addObject("tracking", trackingService.getBook(trackingId));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_tracking");
        return model;
    }

    @RequestMapping(value = "/admin/tracking", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute BookDTO tracking) {
        tracking.setAvailability(true);
        trackingService.add(tracking);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/trackings?message=" + AdminMessage.BOOK_ADDED);
        return model;
    }

    @RequestMapping(value = "/admin/tracking/{trackingId}", method = RequestMethod.POST)
    public ModelAndView updateBook(@PathVariable Long trackingId, @ModelAttribute BookDTO trackingDTO) {
        trackingService.update(trackingDTO);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/trackings?message=" + AdminMessage.BOOK_UPDATED);
        return model;
    }

    @RequestMapping(value = "/admin/trackings/{trackingId}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable Long trackingId) {
        ModelAndView model = new ModelAndView();
        trackingService.delete(trackingId);
        model.setViewName("redirect:/admin/trackings?message=" + AdminMessage.BOOK_DELETED);
        return model;
    }*/
}

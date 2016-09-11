package com.example.application.client.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TrackingController {

/*    private final TrackingService trackingService;

    private final LibraryService libraryService;

    @Autowired
    public TrackingController(TrackingService trackingService, LibraryService libraryService) {
        this.trackingService = trackingService;
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/admin/trackings", method = RequestMethod.GET)
    public ModelAndView getTrackings(@RequestParam(required = false) UserMessage message) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        model.addObject("trackings", trackingService.getTrackings());
        model.setViewName("statistic");
        return model;
    }

    @RequestMapping(value = "/admin/tracking", method = RequestMethod.GET)
    public ModelAndView getTracking() {
        ModelAndView model = new ModelAndView();
        model.addObject("tracking", new TrackingDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_tracking");
        return model;
    }

    @RequestMapping(value = "/admin/tracking/library{libraryId}/user/{userId}", method = RequestMethod.GET)
    public ModelAndView getTracking(@PathVariable Long libraryId, @PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        model.addObject("tracking", trackingService.getTracking(trackingId));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_tracking");
        return model;
    }

    @RequestMapping(value = "/admin/tracking", method = RequestMethod.POST)
    public ModelAndView addTracking(@ModelAttribute TrackingDTO tracking) {
        tracking.setAvailability(true);
        trackingService.add(tracking);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/trackings?message=" + UserMessage.BOOK_ADDED);
        return model;
    }

    @RequestMapping(value = "/admin/tracking/{trackingId}", method = RequestMethod.POST)
    public ModelAndView updateTracking(@PathVariable Long trackingId, @ModelAttribute TrackingDTO trackingDTO) {
        trackingService.update(trackingDTO);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/trackings?message=" + UserMessage.BOOK_UPDATED);
        return model;
    }

    @RequestMapping(value = "/admin/trackings/{trackingId}", method = RequestMethod.GET)
    public ModelAndView deleteTracking(@PathVariable Long trackingId) {
        ModelAndView model = new ModelAndView();
        trackingService.delete(trackingId);
        model.setViewName("redirect:/admin/trackings?message=" + UserMessage.BOOK_DELETED);
        return model;
    }*/
}

package com.example.application.client.controller;

import com.example.application.client.service.TrackingService;
import com.example.application.client.service.UserService;
import com.example.application.client.service.model.LibraryDTO;
import com.example.application.client.service.model.TrackingDTO;
import com.example.application.client.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrackingController {

    private final TrackingService trackingService;

    private final UserService userService;

    @Autowired
    public TrackingController(TrackingService trackingService, UserService userService) {
        this.trackingService = trackingService;
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/tracking/library/{libraryId}/user/{userId}", method = RequestMethod.GET)
    public ModelAndView getTracking(@RequestParam(required = false) UserMessage message, @PathVariable Long libraryId, @PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        TrackingDTO tracking = TrackingDTO.newBuilder()
                .withLibrary(LibraryDTO.newBuilder().withId(libraryId).build())
                .withUser(UserDTO.newBuilder().withId(userId).build())
                .build();
        model.addObject("tracking", trackingService.getTracking(tracking));
        model.setViewName("get_tracking");
        return model;
    }

    @RequestMapping(value = "/admin/tracking/library/{libraryId}/user/{userId}", method = RequestMethod.POST)
    public ModelAndView getTracking(@ModelAttribute TrackingDTO tracking, @PathVariable Long libraryId, @PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        model.addObject("tracking", trackingService.getTracking(tracking));
        model.setViewName("get_tracking");
        return model;
    }

    @RequestMapping(value = "/admin/tracking/library/{libraryId}/book/{bookId}/user/{userId}", method = RequestMethod.GET)
    public ModelAndView addTracking(@PathVariable Long libraryId, @PathVariable Long bookId, @PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        trackingService.addTracking(bookId, userId);
        model.setViewName("redirect:/admin/tracking/library/" + libraryId + "/user/" + userId + "?message=" + UserMessage.BOOK_RECEIVED);
        return model;
    }

    @RequestMapping(value = "/admin/tracking/library/{libraryId}/book/{bookId}/user/{userId}/return", method = RequestMethod.GET)
    public ModelAndView updateTracking(@PathVariable Long libraryId, @PathVariable Long bookId, @PathVariable Long userId) {
        ModelAndView model = new ModelAndView();
        trackingService.updateTracking(bookId, userId);
        model.setViewName("redirect:/admin/tracking/library/" + libraryId + "/user/" + userId + "?message=" + UserMessage.BOOK_RETURNED);
        return model;
    }

    @RequestMapping(value = "/user/tracking", method = RequestMethod.GET)
    public ModelAndView getTracking() {
        ModelAndView model = new ModelAndView();
        UserDTO currentUser = userService.getCurrentUser();
        TrackingDTO tracking = TrackingDTO.newBuilder()
                .withUser(currentUser)
                .build();
        model.addObject("tracking", trackingService.getTracking(tracking));
        model.setViewName("get_user_tracking");
        return model;
    }
}

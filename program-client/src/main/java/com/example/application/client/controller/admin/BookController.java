package com.example.application.client.controller.admin;

import com.example.application.client.service.BookService;
import com.example.application.client.service.LibraryService;
import com.example.application.client.service.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    private final BookService bookService;

    private final LibraryService libraryService;

    @Autowired
    public BookController(BookService bookService, LibraryService libraryService) {
        this.bookService = bookService;
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/admin/books", method = RequestMethod.GET)
    public ModelAndView getBooks(@RequestParam(required = false) AdminMessage message) {
        ModelAndView model = new ModelAndView();
        if (message != null) {
            model.addObject("msg", message.getMessage());
        }
        model.addObject("books", bookService.getBooks());
        model.setViewName("get_books");
        return model;
    }

    @RequestMapping(value = "/admin/book", method = RequestMethod.GET)
    public ModelAndView getBook() {
        ModelAndView model = new ModelAndView();
        model.addObject("book", new BookDTO());
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_book");
        return model;
    }

    @RequestMapping(value = "/admin/book/{bookId}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable Long bookId) {
        ModelAndView model = new ModelAndView();
        model.addObject("book", bookService.getBook(bookId));
        model.addObject("allLibraries", libraryService.getLibraries());
        model.setViewName("add_book");
        return model;
    }

    @RequestMapping(value = "/admin/book", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute BookDTO book) {
        book.setAvailability(true);
        bookService.add(book);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/books?message=" + AdminMessage.BOOK_ADDED);
        return model;
    }

    @RequestMapping(value = "/admin/book/{bookId}", method = RequestMethod.POST)
    public ModelAndView updateBook(@PathVariable Long bookId, @ModelAttribute BookDTO bookDTO) {
        bookService.update(bookDTO);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/admin/books?message=" + AdminMessage.BOOK_UPDATED);
        return model;
    }

    @RequestMapping(value = "/admin/books/{bookId}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable Long bookId) {
        ModelAndView model = new ModelAndView();
        bookService.delete(bookId);
        model.setViewName("redirect:/admin/books?message=" + AdminMessage.BOOK_DELETED);
        return model;
    }
}

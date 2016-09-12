package com.example.application.server.endpoint;

import com.example.application.server.model.BookSearchDTO;
import com.example.application.server.model.TrackingDTO;
import com.example.application.server.model.action.GetTrackingRequest;
import com.example.application.server.model.action.GetTrackingResponse;
import com.example.application.server.model.action.SaveTrackingRequest;
import com.example.application.server.model.action.SaveTrackingResponse;
import com.example.application.server.model.action.SearchBooksRequest;
import com.example.application.server.model.action.UpdateTrackingRequest;
import com.example.application.server.model.action.UpdateTrackingResponse;
import com.example.application.server.repository.BookDao;
import com.example.application.server.repository.LibraryDao;
import com.example.application.server.repository.UserCardDao;
import com.example.application.server.repository.UserDao;
import com.example.application.server.repository.model.BookDB;
import com.example.application.server.repository.model.LibraryDB;
import com.example.application.server.repository.model.UserCardDB;
import com.example.application.server.util.BookBuilderUtil;
import com.example.application.server.util.LibraryBuilderUtil;
import com.example.application.server.util.UserCardBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class TrackingEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/application/server/model";

    private final UserDao userDao;

    private final BookDao bookDao;

    private final UserCardDao userCardDao;

    private final LibraryDao libraryDao;

    @Autowired
    public TrackingEndpoint(UserDao userDao, BookDao bookDao, UserCardDao userCardDao, LibraryDao libraryDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.userCardDao = userCardDao;
        this.libraryDao = libraryDao;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTrackingRequest")
    @ResponsePayload
    @Transactional
    public GetTrackingResponse getTrackingRequest(@RequestPayload GetTrackingRequest request) {
        GetTrackingResponse response = new GetTrackingResponse();
        TrackingDTO tracking = request.getTracking();
        response.setTracking(tracking);
        List<UserCardDB> userCards = userCardDao.findAllUserCards(tracking.getUser().getId());
        tracking.setUserCards(UserCardBuilderUtil.convertUserCardsDBToUserCards(userCards));
        if (tracking.getLibrary() != null) {
            LibraryDB library = libraryDao.findById(tracking.getLibrary().getId());
            tracking.setLibrary(LibraryBuilderUtil.convertLibraryDBToLibrary(library));
        }

        BookSearchDTO bookSearchDTO = BookSearchDTO.newBuilder()
                .withName(request.getTracking().getName())
                .withAuthor(request.getTracking().getAuthor())
                .withPublisher(request.getTracking().getPublisher())
                .withLibrary(tracking.getLibrary())
                .build();
        List<BookDB> books = bookDao.findBooksBySearchDTO(bookSearchDTO);
        tracking.setBooks(books.stream()
                .map(BookBuilderUtil::convertBookDBToBook)
                .collect(Collectors.toList()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveTrackingRequest")
    @ResponsePayload
    @Transactional
    public SaveTrackingResponse saveTrackingRequest(@RequestPayload SaveTrackingRequest request) {
        SaveTrackingResponse response = new SaveTrackingResponse();
        UserCardDB userCard = UserCardBuilderUtil.convertUserCardToUserCardDB();
        userCard.setUser(userDao.findById(request.getUserId()));
        BookDB book = bookDao.findById(request.getBookId());
        book.setAvailability(false);
        bookDao.updateBook(book);
        userCard.setBook(book);
        userCardDao.saveUserCard(userCard);
        response.setResult(true);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateTrackingRequest")
    @ResponsePayload
    @Transactional
    public UpdateTrackingResponse updateTrackingRequest(@RequestPayload UpdateTrackingRequest request) {
        UpdateTrackingResponse response = new UpdateTrackingResponse();
        UserCardDB userCard = userCardDao.findUserCardByUserAndBook(request.getUserId(), request.getBookId());
        userCard.setReturned(Boolean.TRUE);
        userCardDao.updateUserCard(userCard);
        BookDB book = userCard.getBook();
        book.setAvailability(true);
        bookDao.updateBook(book);
        response.setResult(true);
        return response;
    }
}

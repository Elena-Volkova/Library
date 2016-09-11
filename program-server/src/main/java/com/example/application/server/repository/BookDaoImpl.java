package com.example.application.server.repository;

import com.example.application.server.model.BookSearchDTO;
import com.example.application.server.repository.model.BookDB;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings(value = "unchecked")
public class BookDaoImpl extends AbstractDao implements BookDao {

    @Override
    public List<BookDB> findAllBooks() {
        Criteria criteria = getSession().createCriteria(BookDB.class);
        return (List<BookDB>) criteria.list();
    }

    @Override
    public BookDB findById(Long bookId) {
        Criteria criteria = getSession().createCriteria(BookDB.class);
        criteria.add(Restrictions.eq("id", bookId));
        return (BookDB) criteria.uniqueResult();
    }

    @Override
    public void saveBook(BookDB book) {
        getSession().persist(book);
    }

    @Override
    public void deleteBook(BookDB book) {
        getSession().delete(book);
    }

    @Override
    public void updateBook(BookDB book) {
        getSession().update(book);
    }

    @Override
    public List<BookDB> findBooksBySearchDTO(BookSearchDTO search) {
        Criteria criteria = getSession().createCriteria(BookDB.class);
        if (!search.getName().isEmpty()) {
            criteria.add(Restrictions.eq("name", search.getName()));
        }
        if (!search.getAuthor().isEmpty()) {
            criteria.add(Restrictions.eq("author", search.getAuthor()));
        }
        if (!search.getPublisher().isEmpty()) {
            criteria.add(Restrictions.eq("publisher", search.getPublisher()));
        }
        if (search.getLibrary() != null) {
            criteria.createAlias("libraries", "libraries");
            criteria.add(Restrictions.eq("libraries.id", search.getLibrary().getId()));
        }
        return (List<BookDB>) criteria.list();
    }
}

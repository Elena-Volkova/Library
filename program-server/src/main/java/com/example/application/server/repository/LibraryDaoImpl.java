package com.example.application.server.repository;

import com.example.application.server.repository.model.LibraryDB;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings(value = "unchecked")
public class LibraryDaoImpl extends AbstractDao implements LibraryDao {

    @Override
    public List<LibraryDB> findAllLibraries() {
        Criteria criteria = getSession().createCriteria(LibraryDB.class);
        return (List<LibraryDB>) criteria.list();
    }

    @Override
    public LibraryDB findById(Long libraryId) {
        Criteria criteria = getSession().createCriteria(LibraryDB.class);
        criteria.add(Restrictions.eq("id", libraryId));
        return (LibraryDB) criteria.uniqueResult();
    }

    @Override
    public void saveLibrary(LibraryDB library) {
        getSession().persist(library);
    }

    @Override
    public void deleteLibrary(LibraryDB library) {
        getSession().delete(library);
    }

    @Override
    public void updateLibrary(LibraryDB library) {
        getSession().update(library);
    }
}

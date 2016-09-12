package com.example.application.server.repository;

import com.example.application.server.repository.model.UserCardDB;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings(value = "unchecked")
public class UserCardDaoImpl extends AbstractDao implements UserCardDao {

    @Override
    public List<UserCardDB> findAllUserCards(Long userId) {
        Criteria criteria = getSession().createCriteria(UserCardDB.class);
        criteria.createAlias("user", "user");
        criteria.add(Restrictions.eq("user.id", userId));
        return (List<UserCardDB>) criteria.list();
    }

    @Override
    public void saveUserCard(UserCardDB userCard) {
        getSession().persist(userCard);
    }

    @Override
    public void updateUserCard(UserCardDB userCard) {
        getSession().update(userCard);
    }

    @Override
    public UserCardDB findUserCardByUserAndBook(Long userId, Long bookId) {
        Criteria dateCriteria = getSession().createCriteria(UserCardDB.class);
        dateCriteria.createAlias("user", "user");
        dateCriteria.add(Restrictions.eq("user.id", userId));
        dateCriteria.createAlias("book", "book");
        dateCriteria.add(Restrictions.eq("book.id", bookId));
        dateCriteria.setProjection(Projections.max("dateFrom"));

        Criteria criteria = getSession().createCriteria(UserCardDB.class);
        criteria.createAlias("user", "user");
        criteria.add(Restrictions.eq("user.id", userId));
        criteria.createAlias("book", "book");
        criteria.add(Restrictions.eq("book.id", bookId));
        criteria.add(Restrictions.eq("dateFrom", dateCriteria.uniqueResult()));

        return (UserCardDB) criteria.uniqueResult();
    }
}

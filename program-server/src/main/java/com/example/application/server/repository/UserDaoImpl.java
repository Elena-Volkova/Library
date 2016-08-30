package com.example.application.server.repository;

import com.example.application.server.model.RoleEnum;
import com.example.application.server.repository.model.UserDB;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

    @SuppressWarnings(value = "unchecked")
    @Override
    public List<UserDB> findAllUsers() {
        Criteria criteria = getSession().createCriteria(UserDB.class);
        criteria.add(Restrictions.ne("role", RoleEnum.ADMIN));
        return (List<UserDB>) criteria.list();
    }

    @Override
    public UserDB findById(Long userId) {
        Criteria criteria = getSession().createCriteria(UserDB.class);
        criteria.add(Restrictions.eq("id", userId));
        return (UserDB) criteria.uniqueResult();
    }

    @Override
    public UserDB findByUsername(String username) {
        Criteria criteria = getSession().createCriteria(UserDB.class);
        criteria.add(Restrictions.eq("login", username));
        return (UserDB) criteria.uniqueResult();
    }

    @Override
    public void saveUser(UserDB user) {
        getSession().persist(user);
    }

    @Override
    public void updateUser(UserDB user) {
        getSession().update(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Query query = getSession().createSQLQuery("DELETE FROM user WHERE id = :id");
        query.setLong("id", userId);
        query.executeUpdate();
    }
}

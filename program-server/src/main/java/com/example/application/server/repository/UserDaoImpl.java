package com.example.application.server.repository;

import com.example.application.server.model.RoleEnum;
import com.example.application.server.model.UserSearchDTO;
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
    public List<UserDB> findUsersByRole(List<RoleEnum> roles) {
        Criteria criteria = getSession().createCriteria(UserDB.class);
        criteria.add(Restrictions.in("role", roles));
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
    public List<UserDB> findUsersBySearchDTO(UserSearchDTO search) {
        Criteria criteria = getSession().createCriteria(UserDB.class);
        if (!search.getName().isEmpty()) {
            criteria.add(Restrictions.eq("name", search.getName()));
        }
        if (!search.getSurname().isEmpty()) {
            criteria.add(Restrictions.eq("surname", search.getSurname()));
        }
        if (!search.getPatronymic().isEmpty()) {
            criteria.add(Restrictions.eq("patronymic", search.getPatronymic()));
        }
        if (search.getLibrary() != null) {
            criteria.createAlias("libraries", "libraries");
            criteria.add(Restrictions.eq("libraries.id", search.getLibrary().getId()));
        }
        return (List<UserDB>) criteria.list();
    }

    @Override
    public void deleteUser(Long userId) {
        Query query = getSession().createSQLQuery("DELETE FROM user WHERE id = :id");
        query.setLong("id", userId);
        query.executeUpdate();
    }
}

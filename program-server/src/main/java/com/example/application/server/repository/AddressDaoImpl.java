package com.example.application.server.repository;

import com.example.application.server.repository.model.AddressDB;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings(value = "unchecked")
public class AddressDaoImpl extends AbstractDao implements AddressDao {

    @Override
    public AddressDB findById(Long addressId) {
        Criteria criteria = getSession().createCriteria(AddressDB.class);
        criteria.add(Restrictions.eq("id", addressId));
        return (AddressDB) criteria.uniqueResult();
    }

    @Override
    public void saveAddress(AddressDB address) {
        getSession().persist(address);
    }

    @Override
    public void deleteAddress(Long addressId) {
        Query query = getSession().createSQLQuery("DELETE FROM address WHERE id = :id");
        query.setLong("id", addressId);
        query.executeUpdate();
    }

    @Override
    public void updateAddress(AddressDB address) {
        getSession().update(address);
    }
}

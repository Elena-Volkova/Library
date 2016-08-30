package com.example.application.server.repository;

import org.springframework.stereotype.Repository;

/**
 * Process Dao Impl
 */
@Repository
public class ProcessDaoImpl extends AbstractDao implements ProcessDao {

/*
    @Autowired
    private DateBuilderUtil dateBuilderUtil;

    @Override
    public List<ProcessDB> findAll(Search search) {
        Criteria criteria = getSession().createCriteria(ProcessDB.class);
        criteria.createAlias("foreClosure", "foreClosure");
        if (search.getSubType() != null && !(search.getSubType() == 0)) {
            criteria.createAlias("foreClosure.subType", "subType");
            criteria.add(Restrictions.eq("subType.id", search.getSubType()));
        }

        if (search.getDebtor() != null && !search.getDebtor().isEmpty() && !search.getDebtor().equals("")) {
            criteria.createAlias("debtor", "debtor");
            criteria.add(Restrictions.like("debtor.name", search.getDebtor(), MatchMode.ANYWHERE));
        }

        if (search.getUser() != null && !(search.getUser() == 0)) {
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("user.id", search.getUser()));
        }

        if (search.getCreditor() != null && !search.getCreditor().isEmpty() && !search.getCreditor().equals("")) {
            criteria.add(Restrictions.like("foreClosure.creditor", search.getCreditor(), MatchMode.ANYWHERE));
        }

        if (search.getResult() != null && !search.getResult().isEmpty() && !search.getResult().equals("")) {
            criteria.add(Restrictions.like("result", search.getResult(), MatchMode.ANYWHERE));
        }
        if (search.getDate() != null && !search.getDate().isEmpty() && !search.getDate().equals("")) {
            criteria.createAlias("production", "production");
            criteria.add(Restrictions.eq("production.addedDate", dateBuilderUtil.convertStringToDate(search.getDate())));
        }
        return (List<ProcessDB>) criteria.list();
    }

    @Override
    public ProcessDB findById(Long processId) {
        Criteria criteria = getSession().createCriteria(ProcessDB.class);
        criteria.add(Restrictions.eq("id", processId));
        return (ProcessDB) criteria.uniqueResult();
    }

    @Override
    public void save(ProcessDB process) {
        getSession().persist(process);
    }

    @Override
    public void delete(Long processId) {
        Query query = getSession().createSQLQuery("DELETE FROM process WHERE id = :id");
        query.setLong("id", processId);
        query.executeUpdate();
    }

    @Override
    public void update(ProcessDB process) {
        getSession().update(process);
    }
*/
}

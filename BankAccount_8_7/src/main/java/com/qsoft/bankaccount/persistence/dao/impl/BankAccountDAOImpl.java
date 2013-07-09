package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:53
 */

@Transactional
public class BankAccountDAOImpl implements BankAccountDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BankAccountEntity getAccount(String accountNumber)
    {
        System.out.println("12222222222222222222222222222222");
        System.out.println(entityManager);
        Query query = entityManager.createQuery("select o from BankAccountEntity o where o.accountNumber = :qAccountNumber");
        query.setParameter("qAccountNumber", accountNumber);
        return (BankAccountEntity) query.getResultList().get(0);

//        entityManager.
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void add()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save(BankAccountEntity bankAccountEntity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public BankAccountEntity get(String accountNumber)
    {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}

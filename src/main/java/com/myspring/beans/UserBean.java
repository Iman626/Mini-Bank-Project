package com.myspring.beans;

import com.myspring.entities.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBean {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addManager(Users user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void addAccount(Accounts account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    public List<Users> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        List<Users> allUsers = session.createQuery(query).getResultList();
        session.close();
        return allUsers;
    }

    public List<TransactionHistories> getAllTasks() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TransactionHistories> criteriaQuery = builder.createQuery(TransactionHistories.class);
        Root root = criteriaQuery.from(TransactionHistories.class);
        List<TransactionHistories> tasksList = session.createQuery(criteriaQuery).list();
        return tasksList;
    }

    public void deleteUser(int id) {
        Users user = new Users();
        user.setId(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public Users getUser(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return users;
    }

    public Users getUser(String login) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("login"), login))).getSingleResult();
        session.close();
        return users;
    }

    public void saveUser(Users users) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(users);
        transaction.commit();
        session.close();
    }

    public List<BankTotalBalance> getTotalBalance() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BankTotalBalance> criteriaQuery = builder.createQuery(BankTotalBalance.class);
        Root root = criteriaQuery.from(BankTotalBalance.class);
        List<BankTotalBalance> balance = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return balance;
    }

    public List<TransactionHistories> getTransactionList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TransactionHistories> criteriaQuery = builder.createQuery(TransactionHistories.class);
        Root root = criteriaQuery.from(TransactionHistories.class);
        List<TransactionHistories> list = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return list;
    }

    public List<Accounts> getAccountsList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Accounts> criteriaQuery = builder.createQuery(Accounts.class);
        Root root = criteriaQuery.from(Accounts.class);
        List<Accounts> list = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return list;
    }

    public Accounts getAccountInformationById(int accountId) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Accounts> criteriaQuery = builder.createQuery(Accounts.class);
        Root root = criteriaQuery.from(Accounts.class);
        Predicate predicate = builder.equal(root.get("id"), accountId);
        Accounts account = session.createQuery(criteriaQuery.where(predicate)).getSingleResult();
        session.close();
        return account;
    }

    public Accounts getAccountInformationByIin(String iin) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Accounts> criteriaQuery = builder.createQuery(Accounts.class);
        Root root = criteriaQuery.from(Accounts.class);
        Predicate predicate = builder.equal(root.get("iin_number"), iin);
        Accounts account = session.createQuery(criteriaQuery.where(predicate)).getSingleResult();
        session.close();
        return account;
    }

    public List<Operations> getOperationsList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Operations> criteriaQuery = builder.createQuery(Operations.class);
        Root root = criteriaQuery.from(Operations.class);
        List<Operations> list = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return list;
    }


    public List<CurrencyExchange> getCurrencyExList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CurrencyExchange> criteriaQuery = builder.createQuery(CurrencyExchange.class);
        Root root = criteriaQuery.from(CurrencyExchange.class);
        List<CurrencyExchange> list = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return list;
    }

    public List<TransactionHistories> getAccountTransactionList(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TransactionHistories> criteriaQuery = builder.createQuery(TransactionHistories.class);
        Root root = criteriaQuery.from(TransactionHistories.class);
        Predicate predicate = builder.equal(root.get("receiver").get("id"), id);
        Predicate predicate2 = builder.equal(root.get("sender").get("id"), id);
        List<TransactionHistories> list = session.createQuery(criteriaQuery.where(builder.or(predicate, predicate2))).getResultList();
        session.close();
        return list;
    }

    public List<TransactionHistories> getManagerTransactionList(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TransactionHistories> criteriaQuery = builder.createQuery(TransactionHistories.class);
        Root root = criteriaQuery.from(TransactionHistories.class);
        Predicate predicate = builder.equal(root.get("manager").get("id"), id);
        List<TransactionHistories> list = session.createQuery(criteriaQuery.where(predicate)).getResultList();
        session.close();
        return list;
    }

    public void editCurrencyEx(CurrencyExchange tempCurrencyExchange) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tempCurrencyExchange);
        transaction.commit();
        session.close();
    }

    public List<Currencies> getCurrencies() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Currencies> criteriaQuery = builder.createQuery(Currencies.class);
        Root root = criteriaQuery.from(Currencies.class);
        List<Currencies> list = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return list;
    }

    public Currencies getCurrencyById(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Currencies> criteriaQuery = builder.createQuery(Currencies.class);
        Root root = criteriaQuery.from(Currencies.class);
        Predicate predicate = builder.equal(root.get("id"), id);
        Currencies currency = session.createQuery(criteriaQuery.where(predicate)).getSingleResult();
        session.close();
        return currency;
    }

    public void debet(Users manager, int accountId, double value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Accounts tempAccount = getAccountInformationById(accountId);
        List<BankTotalBalance> bankBalance = getTotalBalance();
        bankBalance.get(tempAccount.getCurrency_id().getId() - 1).setValue(bankBalance.get(tempAccount.getCurrency_id().getId() - 1).getValue() + value / 100);
        tempAccount.setAmount(tempAccount.getAmount() + value - value / 100);
        session.update(tempAccount);
        session.update(bankBalance.get(tempAccount.getCurrency_id().getId() - 1));
        TransactionHistories th = new TransactionHistories(manager, null, tempAccount, new Operations(3, "DEBET"), tempAccount.getCurrency_id(), value, String.valueOf(new Date()));
        session.save(th);
        transaction.commit();
        session.close();
    }

    public void credit(Users manager, int accountId, double value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Accounts tempAccount = getAccountInformationById(accountId);
        List<BankTotalBalance> bankBalance = getTotalBalance();
        bankBalance.get(tempAccount.getCurrency_id().getId() - 1).setValue(bankBalance.get(tempAccount.getCurrency_id().getId() - 1).getValue() + value / 100);
        tempAccount.setAmount(tempAccount.getAmount() - value);
        session.update(tempAccount);
        session.update(bankBalance.get(tempAccount.getCurrency_id().getId() - 1));
        TransactionHistories th = new TransactionHistories(manager, tempAccount, null, new Operations(4, "CREDIT"), tempAccount.getCurrency_id(), value, String.valueOf(new Date()));
        session.save(th);
        transaction.commit();
        session.close();
    }

    public void transfer(Users manager, int fromId, double value, String targetIin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Accounts fromAccount = getAccountInformationById(fromId);
        Accounts toAccount = getAccountInformationByIin(targetIin);
        List<BankTotalBalance> bankBalance = getTotalBalance();
        List<CurrencyExchange> currencyExchanges = getCurrencyExList();

        bankBalance.get(fromAccount.getCurrency_id().getId() - 1).setValue(bankBalance.get(fromAccount.getCurrency_id().getId() - 1).getValue() + value);
        fromAccount.setAmount(fromAccount.getAmount() - value);


        if (fromAccount.getCurrency_id().getId() == toAccount.getCurrency_id().getId()){
            toAccount.setAmount(toAccount.getAmount() + value);
        } else {
            if (toAccount.getCurrency_id().getId() == 1){
                value = value * currencyExchanges.get(fromAccount.getCurrency_id().getId() - 2).getPurchase_value();
            } else if (fromAccount.getCurrency_id().getId() == 1) {
                value = value / currencyExchanges.get(toAccount.getCurrency_id().getId()-2).getSale_value();
            } else {
                value = value * currencyExchanges.get(fromAccount.getCurrency_id().getId() - 2).getPurchase_value();
                value = value / currencyExchanges.get(toAccount.getCurrency_id().getId()-2).getSale_value();
            }
            toAccount.setAmount(toAccount.getAmount() + value);
        }

        session.update(fromAccount);
        session.update(toAccount);
        session.update(bankBalance.get(fromAccount.getCurrency_id().getId() - 1));

        TransactionHistories th = new TransactionHistories(manager, fromAccount, toAccount, new Operations(1, "MONEY_TRANSFER"), toAccount.getCurrency_id(), value, String.valueOf(new Date()));
        session.save(th);

        transaction.commit();
        session.close();
    }

    public void exchange(Users manager, int fromId, int curId, int newCurId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Accounts fromAccount = getAccountInformationById(fromId);
        List<CurrencyExchange> currencyExchanges = getCurrencyExList();
        Currencies currency = getCurrencyById(newCurId);

        TransactionHistories th = new TransactionHistories(manager, fromAccount, fromAccount, new Operations(2, "EXCHANGE"), fromAccount.getCurrency_id(), fromAccount.getAmount(), String.valueOf(new Date()));
        session.save(th);

        if (curId == 1) {
            fromAccount.setAmount(fromAccount.getAmount() / currencyExchanges.get(newCurId - 1).getSale_value());
        } else {
            fromAccount.setAmount(currencyExchanges.get(curId - 1).getPurchase_value() * fromAccount.getAmount());
            if (newCurId != 1) {
                fromAccount.setAmount(fromAccount.getAmount() / currencyExchanges.get(newCurId - 1).getSale_value());
            }
        }
        fromAccount.setCurrency_id(currency);
        session.update(fromAccount);
        transaction.commit();
        session.close();
    }
}
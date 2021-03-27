package repository.hibernate;

import model.Account;
import org.hibernate.Session;
import repository.AccountRepository;

public class AccountHibernateRepositoryImpl implements AccountRepository {

    @Override
    public Account saveToDB(Account account) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        }
        return account;
    }

    @Override
    public Account getFromDB(Long accountId) {
        Account account = new Account();
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            account = session.get(Account.class, accountId);
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Account not found!");
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account updateInDB(Account account) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            session.update(account);
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Account not found!");
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account deleteInDB(Long accountId) {
        Account account=new Account();
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            account = session.get(Account.class, accountId);
            session.delete(account);
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Account not found!");
            e.printStackTrace();
        }
        return account;
    }

}

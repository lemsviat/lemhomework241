package controller;

import model.Account;
import repository.AccountRepository;
import repository.hibernate.AccountHibernateRepositoryImpl;

public class AccountController {
    AccountRepository accountRepository= new AccountHibernateRepositoryImpl();

    public Account saveAccount(Account account) {
        return accountRepository.saveToDB(account);
    }
    public Account readAccount(Long accountId) {
        return accountRepository.getFromDB(accountId);
    }
    public Account updateAccount(Account account) {
        return accountRepository.updateInDB(account);
    }
    public Account deleteAccount(Long accountId) {
        return accountRepository.deleteInDB(accountId);
    }
}

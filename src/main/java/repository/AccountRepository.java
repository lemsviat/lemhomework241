package repository;

import model.Account;

public interface AccountRepository extends GenericRepository {
    Account saveToDB(Account account);

    Account getFromDB(Long accountId);

    Account updateInDB(Account account);

    Account deleteInDB(Long accountId);
}

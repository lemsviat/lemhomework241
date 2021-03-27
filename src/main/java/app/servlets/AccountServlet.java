package app.servlets;

import controller.AccountController;
import model.Account;
import model.AccountStatus;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/accounts")
public class AccountServlet extends HttpServlet {
    String freeAccountValue;
    String freeAccountStatus;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        if ("delete".equals(request.getParameter("action"))) {
            doDelete(request, response);
        } else if ("put".equals(request.getParameter("action"))) {
            doPut(request, response);
        } else {
            response.setContentType("text/html");

            Account freeAccount = new Account();


            try (PrintWriter writer = response.getWriter()) {
                freeAccountValue = request.getParameter("account");
                freeAccountStatus = request.getParameter("accountStatus");

                freeAccount.setAccountValue(Long.parseLong(freeAccountValue));
                switch (Integer.parseInt(freeAccountStatus)) {
                    case (1) -> freeAccount.setAccountStatus(AccountStatus.ACTIVE);
                    case (2) -> freeAccount.setAccountStatus(AccountStatus.BANNED);
                    case (3) -> freeAccount.setAccountStatus(AccountStatus.DELETED);
                }


                System.out.println(freeAccount);

                AccountController accountController = new AccountController();
                accountController.saveAccount(freeAccount);

                writer.println("<h3>Account: " + freeAccount + " was added to database</h3>");


            } catch (Exception e) {
                System.out.println("Can`t work");
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        Account account;

        try (PrintWriter writer = response.getWriter()) {
            Long accountId = Long.parseLong(request.getParameter("accountID"));
            AccountController accountController = new AccountController();
            account = accountController.readAccount(accountId);

            if (account == null)
                writer.println("<h3>Sorry, account with ID: '" + accountId + "' not found in the database!</h3>");

            else
                writer.println("<h3>Account: " + account + " with ID: '" + accountId + "' was found in the database</h3>");

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            Long accountId = Long.parseLong(request.getParameter("accountID"));
            String newAccountValue = request.getParameter("accountValue");
            String newAccountStatus = request.getParameter("accountStatus");

            AccountController accountController = new AccountController();

            Account account = accountController.readAccount(accountId);

            if (account == null)
                writer.println("<h3>Sorry, account with ID: '" + accountId + "' not found in the database!</h3>");

            else {
                account.setAccountValue(account.getAccountValue() + Long.parseLong(newAccountValue));

                switch (Integer.parseInt(newAccountStatus)) {
                    case (1) -> account.setAccountStatus(AccountStatus.ACTIVE);
                    case (2) -> account.setAccountStatus(AccountStatus.BANNED);
                    case (3) -> account.setAccountStatus(AccountStatus.DELETED);
                }

                accountController.updateAccount(account);
                writer.println("<h3>Account with ID: " + account.getAccountId() + " was updated in DB</h3>");
                writer.println("<h3>New Account value: " + account.getAccountValue() + "</h3>");
                writer.println("<h3>New Account status: " + account.getAccountStatus() + "</h3>");
            }

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            Long accountId = Long.parseLong(request.getParameter("accountID"));
            AccountController accountController = new AccountController();
            Account account = accountController.readAccount(accountId);
            if (account == null)
                writer.println("<h3>Sorry, account with ID: '" + accountId + "' not found in the database!</h3>");
            else {
                accountController.deleteAccount(accountId);
                writer.println("<h3>Account: " + account + " was deleted</h3>");
            }

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }
}

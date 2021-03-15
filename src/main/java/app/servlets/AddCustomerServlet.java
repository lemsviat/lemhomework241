package app.servlets;

import controller.CustomerController;
import model.Account;
import model.AccountStatus;
import model.Customer;
import model.Specialty;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {

    String customerName;
    String customerAccountValue;
    String customerAccountStatus;
    String customerSpecialities;

    Customer customer = new Customer();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        Account customerAccount = new Account();
        Set<Specialty> specialtySet= new LinkedHashSet<>();


        try (PrintWriter writer = response.getWriter()) {
            customerName = request.getParameter("username");
            customerAccountValue = request.getParameter("account");
            customerAccountStatus = request.getParameter("accountStatus");
            customerSpecialities = request.getParameter("specialities");

            customerAccount.setAccountValue(Long.parseLong(customerAccountValue));
            switch (Integer.parseInt(customerAccountStatus)) {
                case (1) -> customerAccount.setAccountStatus(AccountStatus.ACTIVE);
                case (2) -> customerAccount.setAccountStatus(AccountStatus.BANNED);
                case (3) -> customerAccount.setAccountStatus(AccountStatus.DELETED);
            }

            specialtySet.add(new Specialty(customerSpecialities));
            customer.setName(customerName);
            customer.setAccount(customerAccount);
            customer.setSpecialties(specialtySet);

            System.out.println(customer);

            CustomerController customerController = new CustomerController();
            customerController.saveCustomer(customer);

            writer.println("<h3>Customer with name: " + customer.getName() + " was added to DB</h3>");
            writer.println("<h3>Account: " + customer.getAccount() + "</h3>");
            writer.println("<h3>Specialities: " + customer.getSpecialties() + "</h3>");


        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
        System.out.println(customerName+customerAccountValue+customerAccountStatus+customerSpecialities);
    }
}

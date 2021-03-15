package app.servlets;

import controller.CustomerController;
import model.Account;
import model.Customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String customerName = request.getParameter("username");
            String customerNewAccountValue = request.getParameter("accountValue");

            CustomerController customerController = new CustomerController();
            for (Customer customer : customerController.readCustomer(customerName)) {

                Account account = customer.getAccount();
                account.setAccountValue(customer.getAccount().getAccountValue() + Long.parseLong(customerNewAccountValue));

                customerController.updateCustomer(customer);
                writer.println("<h3>Customer with name: " + customer.getName() + " was updated in DB</h3>");
                writer.println("<h3>New Account value: " + customer.getAccount().getAccountValue() + "</h3>");
                writer.println("<h3>Specialities: " + customer.getSpecialties() + "</h3>");
            }

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }
}

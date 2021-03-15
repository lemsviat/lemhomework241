package app.servlets;

import controller.CustomerController;
import model.Customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String customerName = request.getParameter("username");
            CustomerController customerController = new CustomerController();
            for (Customer customer : customerController.readCustomer(customerName)) {
                customerController.deleteCustomer(customer);
                writer.println("<h3>Customer with name: " + customer.getName() + " was deleted from DB</h3>");
                writer.println("<h3>Customer had Account: " + customer.getAccount() + "</h3>");
                writer.println("<h3>Customer had Specialities: " + customer.getSpecialties() + "</h3>");
            }

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }
}

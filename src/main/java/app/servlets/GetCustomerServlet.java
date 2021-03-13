package app.servlets;

import controller.CustomerController;
import model.Customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getCustomer")
public class GetCustomerServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String customerName = request.getParameter("username");
            CustomerController customerController = new CustomerController();
            for (Customer customer : customerController.readCustomer(customerName)) {
                writer.println("<h3>Customer`s ID: " + customer.getId() + "</h3>");
                writer.println("<h3>Customer`s Name: " + customer.getName() + "</h3>");
                writer.println("<h3>Account: " + customer.getAccount() + "</h3>");
                writer.println("<h3>Specialities: " + customer.getSpecialties() + "</h3>");
            }
            //writer.println("<h2>Name: " + customerController.readCustomer(customerName) + "</h2>");
            //writer.println("<h2>Name: " + customerName + "</h2>");

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }
}

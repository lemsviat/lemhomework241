package app.servlets;

import controller.SpecialtyController;
import model.Specialty;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/specialties")
public class SpecialtyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        if ("delete".equals(request.getParameter("action"))) {
            doDelete(request, response);
        } else if ("put".equals(request.getParameter("action"))) {
            doPut(request, response);
        } else {
            response.setContentType("text/html");

            Set<Specialty> freeSpecialties = new LinkedHashSet<>();

            try (PrintWriter writer = response.getWriter()) {
                Specialty specialty = new Specialty();
                specialty.setSpecialtyName(request.getParameter("specialties"));
                freeSpecialties.add(specialty);

                System.out.println(freeSpecialties);

                SpecialtyController specialtyController = new SpecialtyController();
                specialtyController.saveSpecialties(freeSpecialties);

                writer.println("<h3>Specialties: " + freeSpecialties + " were added to database</h3>");


            } catch (Exception e) {
                System.out.println("Can`t work");
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        Set<Specialty> specialties;

        try (PrintWriter writer = response.getWriter()) {
            Integer specialtiesID = Integer.parseInt(request.getParameter("specialtiesID"));
            SpecialtyController specialtyController = new SpecialtyController();
            specialties = specialtyController.readSpecialties(specialtiesID);

            System.out.println(specialties);

            if (specialties.contains(null))
                writer.println("<h3>Sorry, specialties with ID: '" + specialtiesID + "' not found in the database!</h3>");

            else
                writer.println("<h3>Specialties: " + specialties + " with ID: '" + specialtiesID + "' were found in the database</h3>");

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            Integer specialtiesID = Integer.parseInt(request.getParameter("specialtiesID"));
            String newSpecialties = request.getParameter("newSpecialties");

            SpecialtyController specialtyController = new SpecialtyController();
            Set<Specialty> specialties = specialtyController.readSpecialties(specialtiesID);
            System.out.println(specialties);

            if (specialties.contains(null))
                writer.println("<h3>Sorry, specialties with ID: '" + specialtiesID + "' not found in the database!</h3>");

            else {
                for (Specialty specialty: specialties
                     ) {
                    specialty.setSpecialtyName(newSpecialties);
                }

                System.out.println(specialties);

                specialtyController.updateSpecialties(specialties);
                writer.println("<h3>Specialties with ID: " + specialtiesID + " were updated in DB</h3>");
                writer.println("<h3>New Specialties value: " + specialties + "</h3>");
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
            Integer specialtiesID = Integer.parseInt(request.getParameter("specialtiesID"));
            SpecialtyController specialtyController = new SpecialtyController();
            Set<Specialty> specialties = specialtyController.readSpecialties(specialtiesID);
            if (specialties.contains(null))
                writer.println("<h3>Sorry, specialties with ID: '" + specialtiesID + "' not found in the database!</h3>");
            else {
                specialtyController.deleteSpecialties(specialtiesID);
                writer.println("<h3>Specialties: " + specialties + " were deleted from the database</h3>");
            }

        } catch (Exception e) {
            System.out.println("Can`t work");
            e.printStackTrace();
        }
    }
}

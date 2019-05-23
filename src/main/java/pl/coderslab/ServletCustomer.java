package pl.coderslab;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "ServletCustomer", urlPatterns = "/customers")
public class ServletCustomer extends HttpServlet {


    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String BIRTHDAY = "birthday";

    public static final String EDITED_ID = "editedId";
    public static final String EDITED_FIRST_NAME = "editedFirstName";
    public static final String EDITED_LAST_NAME = "editedLastName";
    public static final String EDITED_BIRTHDAY = "editedBirthday";
    public static final String REMOVE = "remove";
    public static final String EDIT = "edit";
    public static final String CUSTOMERS = "customers";
    private Customer customer;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int editedId = request.getParameter(EDITED_ID) == null ? 0 : Integer.parseInt(request.getParameter(EDITED_ID));

        if (editedId != 0) {
            String editedFirstName = request.getParameter(EDITED_FIRST_NAME);
            String editedLastName = request.getParameter(EDITED_LAST_NAME);
            LocalDate editedBirthday = LocalDate.parse(request.getParameter(EDITED_BIRTHDAY));
            customer = new Customer(editedId, editedFirstName, editedLastName, editedBirthday);
            try {
                CustomerDao.update(customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("http://localhost:8080/customers");
            return;
        }

        String name = request.getParameter(FIRST_NAME);
        String surname = request.getParameter(LAST_NAME);
        LocalDate birthday = LocalDate.parse(request.getParameter(BIRTHDAY));
        customer = new Customer(name, surname, birthday);

        try {
            CustomerDao.save(customer);
            response.sendRedirect("http://localhost:8080/customers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int remove = request.getParameter(REMOVE) == null ? 0 : Integer.parseInt(request.getParameter(REMOVE));
        int edit = request.getParameter(EDIT) == null ? 0 : Integer.parseInt(request.getParameter(EDIT));

        try {
            ArrayList<Customer> customers = (ArrayList<Customer>) CustomerDao.loadAll();
            request.setAttribute(CUSTOMERS, customers);

            if (remove != 0) {
                for (Customer customer : customers) {
                    if (customer.getId() == remove) {
                        CustomerDao.delete(customer);
                        response.sendRedirect("http://localhost:8080/customers");
                        return;
                    }
                }
            } else if (edit != 0) {
                request.setAttribute(EDITED_ID, edit);
                getServletContext().getRequestDispatcher("/JSP/customers.jsp").forward(request,response);
            } else {
                getServletContext().getRequestDispatcher("/JSP/customers.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

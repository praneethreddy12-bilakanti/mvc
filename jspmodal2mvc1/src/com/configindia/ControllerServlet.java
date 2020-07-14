package com.configindia;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ControllerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }
protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException {

		// retrieving value of action parameter
        String userAction = request.getParameter("action");

        // if request comes to move to addemployee.jsp from hyperlink
        if (userAction.equals("addemployee")) {
            response.sendRedirect("addemployee.jsp");
        } // if request comes to move to searchemployee.jsp from hyperlink
        else if (userAction.equals("searchemployee")) {
            response.sendRedirect("searchemployee.jsp");
        }

        // if “save” button clicked on 
        if (userAction.equals("save")) {
            addEmployee(request, response);
        } // if “search” button clicked on searchperson.jsp for search
        else if (userAction.equals("search")) {
            searchEmployee(request, response);
        }
    }

    // if request comes to add/save person
    private void addEmployee(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {

            EmployeeDAO eDB = new EmployeeDAO();
            Employee employee = new Employee();

            // setting properties of Employee object
            String eId = request.getParameter("empId");
            int empId = Integer.parseInt(eId);
            employee.setEmpId(empId);

            String fName = request.getParameter("firstName");
            employee.setFirstName(fName);

            String lName = request.getParameter("lastName");
            employee.setLastName(lName);

            String sal = request.getParameter("salary");
            int salary = Integer.parseInt(sal);
            employee.setSalary(salary);

            eDB.addEmployee(employee);

            // redirecting page to saveemployee.jsp
            response.sendRedirect("saveemployee.jsp");

        } catch (SQLException sqlex) {
            // setting SQLException instance
            request.setAttribute("javax.servlet.jsp.JspException", sqlex);
            RequestDispatcher rd =
                    request.getRequestDispatcher("emperror.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException cnfe) {
            // setting ClassNotFoundException instance
            request.setAttribute("javax.servlet.jsp.JspException", cnfe);
            RequestDispatcher rd =
                    request.getRequestDispatcher("emperror.jsp");
            rd.forward(request, response);
        }
    }

    // if request comes to search employee record from database
    private void searchEmployee(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmployeeDAO eDB = new EmployeeDAO();
            String fName = request.getParameter("fName");

            ArrayList employeeList = eDB.retrieveEmployeesList(fName);
            request.setAttribute("list", employeeList);

            // forwarding request to showemployee, so it can render employeeList
            RequestDispatcher rd =
                    request.getRequestDispatcher("showemployee.jsp");
            rd.forward(request, response);
        } catch (SQLException sqlex) {
            request.setAttribute("javax.servlet.jsp.JspException", sqlex);
            RequestDispatcher rd =
                    request.getRequestDispatcher("emperror.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException cnfe) {
            request.setAttribute("javax.servlet.jsp.JspException", cnfe);
            RequestDispatcher rd =
                    request.getRequestDispatcher("emperror.jsp");
            rd.forward(request, response);
        }
    }
}

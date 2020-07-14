<%-- defining error page --%>
<%@page errorPage="emperror.jsp" %>
<%-- importing required packages --%>
<%@page import="java.util.*" %>
<%@page import="com.configindia.*" %>

<html>
    <body>
        <center>
            <h2> Employee Record </h2>
            <h3> Following results meet your search criteria</h3>
            <TABLE BORDER="1" >
                <TR>
                    <TH> Employee ID </TH>
                    <TH> First Name </TH>
                    <TH> Last Name </TH>
                    <TH> Salary </TH>
                </TR>
                <jsp:useBean id="edao" class="com.configindia.EmployeeDAO" scope="page" />
                <%
                // getting search criteria sent by searchemployee.jsp
                            String fName = request.getParameter("fName");

                // retrieving matching records from the Database using
                // retrieveEmployeesList() method of EmployeeDB
                            ArrayList empList = edao.retrieveEmployeesList(fName);
                            Employee e = null;

                // Showing all matching records by iterating over ArrayList
                            for (int i = 0; i < empList.size(); i++) {
                                e = (Employee) empList.get(i);
                %>
                <TR>
                    <TD> <%= e.getEmpId()%> </TD>
                    <TD> <%= e.getFirstName()%> </TD>
                    <TD> <%= e.getLastName()%> </TD>
                    <TD> <%= e.getSalary()%> </TD>
                </TR>
                <%
                            } // end for
                %>
            </TABLE >
            <h3> <a href="addemployee.jsp" > Add Employee </a> </h3>
            <h3> <a href="searchemployee.jsp" > Search Employee </a> </h3>
        </center>
    </body>
</html>
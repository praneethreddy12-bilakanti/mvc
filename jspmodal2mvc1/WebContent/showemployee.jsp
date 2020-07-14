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

                <%
                            // retrieving ArrayList stored on controller
                            ArrayList empList = (ArrayList) request.getAttribute("list");
                            Employee employee = null;

                            // Showing all matching records by iterating over ArrayList
                            for (int i = 0; i < empList.size(); i++) {
                                employee = (Employee) empList.get(i);
                %>
                <TR>
                    <TD> <%= employee.getEmpId()%> </TD>
                    <TD> <%= employee.getFirstName()%> </TD>
                    <TD> <%= employee.getLastName()%> </TD>
                    <TD> <%= employee.getSalary()%> </TD>
                </TR>
                <%
                            }
                %>
            </TABLE >
            <h3> <a href="controller?action=addemployee" > Add Employee </a> </h3>
            <h3> <a href="controller?action=searchemployee" > Search Employee </a> </h3>
        </center>
    </body>
</html>
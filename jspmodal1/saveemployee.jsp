<%@page errorPage="emperror.jsp" %>
<%@ page import="java.sql.*" %>
<html>
    <body>

        <%-- creating EmployeeDAO object and storing in page scope --%>
 <jsp:useBean id="edao" class="com.configindia.EmployeeDAO" scope="page" />
 <%--creating Employee object and storing in page scope --%>
<jsp:useBean id="e" class="com.configindia.Employee" scope = "page" />

<%--
setting all properties of employee object with input parameters using * --%>
        <jsp:setProperty name="e" property="*" />

<%--
 to save record into the database, calling addEmployee method of EmployeeDAO
   --%>
        <%
                    edao.addEmployee(e);
        %>

        <center>
            <h3> New Employee Record has been saved successfully!</h3>
            <h4>
                <a href="addemployee.jsp" > Add Employee </a>
            </h4>
            <h4>
                <a href="searchemployee.jsp" > Search Employee </a>
            </h4>
        </center>

    </body>
</html>
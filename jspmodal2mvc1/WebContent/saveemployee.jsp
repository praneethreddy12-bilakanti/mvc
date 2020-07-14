<%-- defining error page --%>
<%@page errorPage="emperror.jsp" %>
<html>
    <body>
        
        <center>
            <h3> New Employee Record has been saved successfully!</h3>
            <h4>
                <a href="controller?action=addemployee" > Add Employee </a>
            </h4>
            <h4>
                <a href="controller?action=searchemployee" > Search Employee </a>
            </h4>
        </center>

    </body>
</html>
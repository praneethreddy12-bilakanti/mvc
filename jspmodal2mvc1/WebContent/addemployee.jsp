<%@page errorPage="emperror.jsp" %>
<html>
    <body>
        <center>
            <h2> Employee Record </h2>
            <h3> Add New Employee</h3>

            <%-- Form that containing Text input fields and sending it to saveemployee.jsp --%>
            <form name ="register" action="controller" >
                <TABLE BORDER="1" >
                    <TR>
                        <TD> <h4 > Employee ID </h4> </TD>
                        <TD> <input type="text" name="empId" /> </TD>
                    </TR>
                    <TR>
                        <TD> <h4> First Name </h4> </TD>
                        <TD> <input type="text" name="firstName" /> </TD>
                    </TR>
                    <TR>
                        <TD> <h4>Last Name</h4> </TD>
                        <TD> <input type="text" name="lastName" /> </TD>
                    </TR>
                    <TR>
                    <TR>
                        <TD> <h4 > Salary </h4> </TD>
                        <TD> <input type="text" name="salary" /> </TD>
                    </TR>
                    <TD COLSPAN="2" ALIGN="CENTER" >
                        <input type="submit" name="action" value="save" />
                        <input type="reset" value="clear" />
                    </TD>
                    </TR>
                </TABLE>
            </form>
            <h4>
                <%-- A link to searchemployee.jsp --%>
                <a href="controller?action=searchemployee" > Search Employee </a>
            </h4>
        </center>
    </body>
</html>
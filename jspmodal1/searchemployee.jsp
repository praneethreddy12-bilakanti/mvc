<%-- defining error page --%>
<%@page errorPage="emperror.jsp" %>
<html>
    <body>
        <center>
            <h2> Employee Record </h2>
            <h3> Search Employee</h3>
            <%--
            Form that contains Text input field and sending it to showemployee.jsp
            --%>
            <form name ="search" action="showemployee.jsp" >
                <TABLE BORDER="1" >
                    <TR>
                        <TD> <h4 >First Name</h4> </TD>
                        <TD> <input type="text" name="fName" /> </TD>
                    </TR>
                    <TR>
                        <TD COLSPAN="2" ALIGN="CENTER"">
                            <input type="submit" value="search" />
                            <input type="reset" value="clear" />
                        </TD>
                    </TR>
                </TABLE>
            </form>
            <h4>
                <a href="addemployee.jsp" > Add Employee </a>
            </h4>
        </center>
    </body>
</html>
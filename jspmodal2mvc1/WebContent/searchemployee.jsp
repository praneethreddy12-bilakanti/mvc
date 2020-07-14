<%-- defining error page --%>
<%@page errorPage="emperror.jsp" %>
<html>
    <body>
        <center>
            <h2> Employee Record </h2>
            <h3> Search Employee</h3>
          
            <form name ="search" action="controller" >
                <TABLE BORDER="1" >
                    <TR>
                        <TD> <h4 >First Name</h4> </TD>
                        <TD> <input type="text" name="fName" /> </TD>
                    </TR>
                    <TR>
                        <TD COLSPAN="2" ALIGN="CENTER">
                            <input type="submit" name="action" value="search" />
                            <input type="reset" value="clear" />
                        </TD>
                    </TR>
                </TABLE>
            </form>
            <h4>
                <a href="controller?action=addemployee" > Add Employee </a>
            </h4>
        </center>
    </body>
</html>
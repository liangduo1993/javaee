<html>
    <%
        String info = (String)request.getAttribute("info");
        if(info != null){
        %>
            <font color="red"><%=info %></font>
        <%
        }
    %>
    <form action="login" method="get">
        <table>
            <tr>
                <td>
                    User Name:
                </td>
                <td>
                    <input name="userName" type="text" />
                </td>
             </tr>

             <tr>
                             <td>
                                 Password:
                             </td>
                             <td>
                                 <input name="password" type="password" />
                             </td>
                          </tr>
             <tr>
                             <td>
                                 <input type="submit" value="Submit" />
                             </td>
                             <td>
                                 <input type="reset" value="Cancel" />
                             </td>
                          </tr>
        </table>
    </form>
</html>
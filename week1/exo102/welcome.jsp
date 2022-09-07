<%
    Boolean logged = (Boolean) session.getAttribute("logged");
    if(logged == null || !logged){
        out.print("<div> Please <a href=\"auth.jsp\"> login</a>  </div>");
        return;
    }
%>
<h1>Welcome Admin !</h1>

[ <a href="auth?logout" style="color: red; text-decoration: none">DISCONNECT</a> ]

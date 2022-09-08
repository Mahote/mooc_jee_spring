<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Sac</title>

    </head>

    <body>
        <%@ page import="web.Bag" %>

        <% Bag bag = (Bag) request.getAttribute("bag"); %>

        <h1>Sac</h1>
        <%

        if (bag != null){
            bag.print(out);
        }

        %>

        <form  method="post" action="bag">
            ref : <input name="ref"><br>
            qty : <input name="qty"><br>
            <input type="submit" value="envoi">
        </form>
    </body>
</html>
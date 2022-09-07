<!DOCTYPE html>
<html lang="en">
<% String ctxPath = request.getContextPath(); %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Signin Template for Bootstrap</title>

  <link href="<%= ctxPath %>/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%= ctxPath %>/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
  <link href="<%= ctxPath %>/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">

      <form class="form-signin" method="post" action="auth">
        
        <%
          String error = (String) request.getAttribute("errorMessage");
          if(error != null){
            out.print("<div class=\"alert alert-danger\" role=\"alert\">" + "failed to login wrong credentials" + "</div>");
          } 
        %>
        <%
          String logout = (String) request.getAttribute("logout");
          if(logout != null){
            out.print("<div> logged out</div>");
          }
        %>

        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus=""  name="login">
        <label for="inputPassword" class="sr-only">Password</label>
        <input id="inputPassword" class="form-control" placeholder="Password" required="" type="password" name="password">
        <div class="checkbox">
          <label>
            <input value="remember-me" type="checkbox"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

</div>


  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="<%= ctxPath %>/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
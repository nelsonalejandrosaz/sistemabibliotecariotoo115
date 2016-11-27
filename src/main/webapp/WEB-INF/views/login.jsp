<%-- 
    Document   : login
    Created on : 11-26-2016, 08:53:54 PM
    Author     : Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
--%>
<%@include file="taglib_include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head_include.jsp" %>
    </head>
    <body>
        <div class="container">

            <form class="form-signin" method="POST">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="text" id="inputEmail" class="form-control" placeholder="Email address" name="user" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

        </div> <!-- /container -->

    </body>
</html>
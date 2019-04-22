<%-- 
    Document   : login
    Created on : 06-mar-2019, 17:06:38
    Author     : edwin.lebreton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Login ISDCM Videos</title>
  
    
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
  <div class="login-page">
  <div class="form">
    <form name="login_form" class="login-form" action="servletUsarios">
    <h1 align="center">ISDCM Videos</h1>
      <input type="text" maxlength="30" required='required' placeholder="Nombre de usuario"  name="username" >
      <input type="password" maxlength="30" required='required' placeholder="Contraseña" name="password">
      <%
        if(request.getAttribute("message") != null && request.getAttribute("message") != ""){
            if(request.getAttribute("registerIsDone")==null){
      %>
            <p style="color:red"> ${message}</p>
      <%
            }
            else{
      %>
                <p style="color:green"> ${message}</p>
      <%
          }
        }
      %>
      <button type="submit" name="action" value="Login">Iniciar Sesión</button>
      <p class="message">¿No registrado? <a href="registroUsu.jsp">Crear una cuenta</a></p>
    </form>
  </div>
</div>


</body>

</html>

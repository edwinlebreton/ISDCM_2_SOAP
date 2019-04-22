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
  <title>Register user</title>
  
  
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="login-page">
  <div class="form">
    <form class="login-form" action="servletUsarios">
      <h3 align="center">NUEVO USUARIO</h3>
      <input type="text" maxlength="30" required='required' placeholder="Nombre" class="form-control" name="name" >
      <input type="text" maxlength="30" required='required' placeholder="Apellidos" class="form-control" name="surname">
      <input type="email" maxlength="50" required='required' placeholder="Email" class="form-control" name="email">
      <input type="text" maxlength="20" required='required' placeholder="Nombre de usuario" class="form-control" name="username">
      <input type="password" maxlength="20" required='required' placeholder="Contraseña" class="form-control" name="password">
      <input type="password" required='required' placeholder="Repetir contraseña" class="form-control" name="repeatPassword">
      <%
        if(request.getAttribute("message") != null && request.getAttribute("message") != ""){
      %>
        <p style="color:red"> ${message}</p>
      <%
        }
      %>
      <button type="submit" name="action" value="Registrar">Registrar usuario</button>
      <p class="message">¿Ya registrado? <a href="login.jsp">Iniciar Sesión</a></p>
    </form>
  </div>
</div>


</body>

</html>

<%-- 
    Document   : searchVideos
    Created on : 3 avr. 2019, 17:24:12
    Author     : edwinlebreton
--%>

<%@page import="org.me.video.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Busqueda de videos</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="css/style2.css">
      <link rel="stylesheet" href="css/table2.css">
</head>

<body>
    <%
    if(session.getAttribute("userSession")==null)
            response.sendRedirect("login.jsp");
    %>
    <%
        if(request.getAttribute("message") != null && request.getAttribute("message") != ""){
    %>
        <p style="color:white"> ${message}</p>
    <%
        }
    %>
    <form class="login-form" action="servletRegistroVid">
        <p align="right">
                    <button align="right" type="submit" name="action" value="close" onclick="parent.location='registroVid.jsp'">Cerrar sesión</button>
        </p>
    </form>
    <form class="login-form" action="servletBusqueda" method="post">
        <p align="right">
                <h1>Busqueda de Videos</h1>
        </p>
        <!-- Buttons and imput for search -->
        <div class="input-append" align="center">
            <input type="text" maxlength="100" placeholder="Titulo" name="title">
            <button type="submit" name="action" value="searchByTitle">Buscar</button>
        </div>
        <div class="input-append" align="center">
            <input type="text" maxlength="100" placeholder="Autor" name="author">
            <button type="submit" name="action" value="searchByAuthor">Buscar</button>
        </div>
        <div class="input-append" align="center">
            <input type="date" placeholder="Fecha" name="date">
            <button type="submit" name="action" value="searchByDate">Buscar</button>
        </div>
        <p align="right" >
        <div class="tbl-header">
        <!-- ------------------------------ -->
        
        <!-- provide an html table start tag -->
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
                <tr>
                  <th>ID</th>
                  <th>Titulo</th>
                  <th>Autor</th>
                  <th>Fecha de creacion</th>
                  <th>Duracion</th>
                  <th>Reproducciones</th>
                  <th>Descripcion</th>
                  <th>Formato</th>
                </tr>
              </thead>
        </table>
        </div>
        <!--get the collection from the attribute from appropriate scope (here, request) -->
        <% 
            if(request.getAttribute("videoList")!=null) {
        ArrayList videoList = (ArrayList)request.getAttribute("videoList"); 
        %>  
            <!-- create an html table row -->
            <div class="tbl-content">
            <TABLE cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                <%
                for (int i = 0; i < videoList.size(); i++) {
                    Video vid = (Video) videoList.get(i);
                %>
                <TR>
                <TD><% out.print(vid.getId()); %></TD>
                <TD><% out.print(vid.getTitle()); %></TD>
                <TD><% out.print(vid.getAuthor()); %></TD>
                <TD><% out.print(vid.getDate()); %></TD>
                <TD><% out.print(vid.getDuration()); %></TD>
                <TD><% out.print(vid.getReproductions()); %></TD>
                <TD><% out.print(vid.getDescription()); %></TD>
                <TD><% out.print(vid.getFormat()); %></TD>
                </TR>
                <%}} %>
            </TABLE>
        </tbody>
        </div>
    </form>
        <div align="center">
                <button type="submit" name="action" value="volverListado" onclick="parent.location='listadoVid.jsp'" >Volver</button>    
        </div>
</body>

</html>

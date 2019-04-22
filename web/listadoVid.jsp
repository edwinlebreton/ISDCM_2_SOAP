<%-- 
    Document   : listadoVid
    Created on : 06-mar-2019, 17:47:31
    Author     : edwin.lebreton
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import= "conexion.JdbcDerbyConnection" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISDCM Videos</title>
        <link rel="stylesheet" href="css/table.css">
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
                <p float="right" align="right">
                            <button float="right" align="right" type="submit" name="action" value="close" onclick="parent.location='registroVid.jsp'">Cerrar sesión</button>
                </p>
            </form>
            <div float="left">
                <button float="left" type="submit" name="action" value="buscarVid" onclick="parent.location='busqueda.jsp'" >Buscar video</button>    
            </div>
            <p align="center">
                <h1>Lista de Videos</h1>
            </p>
            <div class="tbl-header">
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
            <%
                List<Video> videoList = Video.getFullVideoList();
                %>
                <div class="tbl-content">
                <TABLE cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                <%
                for (int i = 0; i < videoList.size(); i++) {
                    Video vid = videoList.get(i);
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
                <% i++; } %>
            </TABLE>
            </tbody>
            </div>
            </font>
        <div class="form">
                <button type="submit" name="action" value="registerNewVid" onclick="parent.location='registroVid.jsp'" >Añadir nuevo video</button>    
        </div>
    </body>
</html>

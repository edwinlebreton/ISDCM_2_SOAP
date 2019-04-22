/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Video;

/**
 *
 * @author edwinlebreton
 */
@WebServlet(name = "servletRegistroVid", urlPatterns = {"/servletRegistroVid"})
public class servletRegistroVid extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try {
            String action = request.getParameter("action");
            HttpSession session = request.getSession(false);
            if(session.getAttribute("userSession")==null)
                        response.sendRedirect("login.jsp");
            else if("close".equals(action)){
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response); 
            }
            else if("registrarVid".equals(action)){
                    String title = request.getParameter("title");
                    String author = request.getParameter("author");
                    String dateStr = request.getParameter("date");
                    String timeStr = request.getParameter("duration");
                    String reprod = request.getParameter("reproductions");
                    String description = request.getParameter("description");
                    String format = request.getParameter("format");
                    int reproductions = Integer.parseInt(reprod);
                    Date date = Date.valueOf (dateStr);
                    Time duration = Time.valueOf(timeStr);
                    Video video = new Video(title, author, date, duration, reproductions, description, format);
                    if(video.alreadyExists()){
                        String message= "Este video ya existe";
                        boolean videoAlreadyExists = true;
                        request.setAttribute("videoAlreadyExists", videoAlreadyExists);
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/registroVid.jsp").forward(request, response); 
                        message=null;
                    }
                    else{
                        video.addVideo();
                        String message = "El nuevo video ha sido agregado correctamente";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/registroVid.jsp").forward(request, response); 
                        message=null;
                    }    
        }

            
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "servlet for video management";
    }// </editor-fold>

}

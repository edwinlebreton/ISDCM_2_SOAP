/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import org.me.video.VideoWS_Service;

/**
 *
 * @author edwinlebreton
 */
@WebServlet(name = "servletBusqueda", urlPatterns = {"/servletBusqueda"})
public class servletBusqueda extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VideoWS/VideoWS.wsdl")
    private VideoWS_Service service;

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
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if(session.getAttribute("userSession")==null)
                        response.sendRedirect("login.jsp");
        String action = request.getParameter("action");
        if("searchByTitle".equals(action)){
            String title = request.getParameter("title");
            List<org.me.video.Video> newListVid = findByTitle(title);
            request.setAttribute("videoList", newListVid);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("busqueda.jsp");
            requestDispatcher.forward(request, response);
        }
        if("searchByAuthor".equals(action)){
            String author = request.getParameter("author");
            List<org.me.video.Video> newListVid = findByAuthor(author);
            request.setAttribute("videoList", newListVid);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("busqueda.jsp");
            requestDispatcher.forward(request, response);
        }   
        if("searchByDate".equals(action)){
            String date = request.getParameter("date");
            List<org.me.video.Video> newListVid = findByDate(date);
            request.setAttribute("videoList", newListVid);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("busqueda.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<org.me.video.Video> findByTitle(java.lang.String title) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.me.video.VideoWS port = service.getVideoWSPort();
        return port.findByTitle(title);
    }
    
    private java.util.List<org.me.video.Video> findByAuthor(java.lang.String author) {        
        org.me.video.VideoWS port = service.getVideoWSPort();
        return port.findByAuthor(author);
    }
    
    private java.util.List<org.me.video.Video> findByDate(java.lang.String date) {
        org.me.video.VideoWS port = service.getVideoWSPort();
        return port.findByDate(date);
    }

}

package controlador;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author edwin.lebreton
 */
@WebServlet(urlPatterns = {"/servletUsarios"})
public class servletUsarios extends HttpServlet {

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
        try{
            String action = request.getParameter("action");
            String message = null;
            if("Login".equals(action)){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username+" "+password);
                Usuario usr = new Usuario(username, password);
                if(usr.exists()){
                        HttpSession session = request.getSession(true); 
                        session.setAttribute("userSession", usr);
                        message= "Inicio de sesión correcto. ¡Bienvenido!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("listadoVid.jsp").forward(request, response); 
                        message=null;                   
                }
                else{
                        message="Usuario o contraseña incorrecto";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/login.jsp").forward(request, response); 
                        message=null;

                }
            }
            else if("Registrar".equals(action)){
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String repeatPassword = request.getParameter("repeatPassword");
                Usuario usr = new Usuario(username, name, surname, email, password);
                if(!password.equals(repeatPassword)){
                    message="Contraseñas diferentes";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/registroUsu.jsp").forward(request, response); 
                    message=null;
                }
                else if(usr.userNameExists()){
                    message= "Nombre de usuario o correo electrónico ya existe";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/registroUsu.jsp").forward(request, response); 
                    message=null;
                }
                else{
                    usr.addUser();
                    boolean registerIsDone=true;
                    message= "¡Registro hecho! Ahora puede iniciar sesión";
                    request.setAttribute("message", message);
                    request.setAttribute("registerIsDone", registerIsDone);
                    request.getRequestDispatcher("/login.jsp").forward(request, response); 
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
        return "servlet for user account management";
    }// </editor-fold>

}
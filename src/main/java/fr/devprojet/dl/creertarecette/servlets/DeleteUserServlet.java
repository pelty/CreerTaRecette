/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.servlets;

import fr.devprojet.dl.creertarecette.metiers.utils.UserUtils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dev-pro
 */
@WebServlet(urlPatterns = {"/deleteuser"})
public class DeleteUserServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUserDeleteString = req.getParameter("iddeleteuser");
        
        boolean deleteUser = UserUtils.deleteUser(idUserDeleteString);
        if (deleteUser){
            String msg = "user supprimer";
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher = req.getServletContext()
                    .getRequestDispatcher("/home");
            dispatcher.forward(req, resp);
        }
    }
    
    
}

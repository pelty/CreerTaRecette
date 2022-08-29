/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.servlets;

import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.entities.Users;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private final UserImplement userImplement = DaoFactory.getInstance().getUserImplement();

    public HomeServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> listUser = null;
        String errorString = null;
        
        try {listUser = userImplement.findAll();} 
        catch (Exception e) {e.printStackTrace();errorString = e.getMessage();}
        
        req.setAttribute("listUser", listUser);
        req.setAttribute("errorString", errorString);
        req.setAttribute("admin", "ADMIN");
        
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/user/listUser.jsp");
        dispatcher.forward(req, resp);
        
    }

}

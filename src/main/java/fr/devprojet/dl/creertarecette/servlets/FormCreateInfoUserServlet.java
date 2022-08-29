/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.servlets;

import fr.devprojet.dl.creertarecette.metiers.utils.UserInfoUtils;
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

@WebServlet("/createinfouser")
public class FormCreateInfoUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/user/formInfoUser.jsp");
        dispatcher.forward(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String number = req.getParameter("number");
        long idUser = Long.parseLong(req.getParameter("idUser"));
        String msg = null;
        
        if(!firstname.isEmpty() && !lastname.isEmpty() && !number.isEmpty() && !email.isEmpty() && idUser>0){
            msg = UserInfoUtils.createUserInfo(firstname, lastname, number, email, idUser);
            String idUsersString = String.valueOf(idUser);
            resp.sendRedirect(req.getContextPath()+"/profiluser?id="+idUser);
        }
        
        //req.setAttribute("returnMsg", msg);
        resp.sendRedirect(req.getContextPath()+"/profiluser");
        
    }

    
    
    
}

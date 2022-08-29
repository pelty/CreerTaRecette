/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.servlets;

import fr.devprojet.dl.creertarecette.entities.Users;
import fr.devprojet.dl.creertarecette.metiers.utils.UserUtils;
import java.io.IOException;
import java.time.LocalDateTime;
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
@WebServlet(urlPatterns = {"/edituser"})
public class EditUserServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUserEditString = req.getParameter("idedituser");
        Users users = UserUtils.findIdeditUser(idUserEditString);
        
        if(users!=null){
            req.setAttribute("users", users);
            initDispatcher(req, resp);
        }
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gender = req.getParameter("gender");
        String role = req.getParameter("role");
        String pseudo = req.getParameter("pseudo");
        String password = req.getParameter("password");
        String errMsg = null;
        LocalDateTime dateNow = LocalDateTime.now();
        long idUser = Long.parseLong(req.getParameter("id"));
        
        if(!gender.isEmpty() && !role.isEmpty() && !password.isEmpty() && !pseudo.isEmpty() && idUser > -1){
            System.out.println("EditUserServlet doPost() 1 ##################################################################");
            boolean result = UserUtils.updateUser(gender, role, pseudo, password, idUser, dateNow);
            if (result) {
                resp.sendRedirect(req.getContextPath()+"/home");
                return;
            }else{
                errMsg = "La mise à jour ne c'est pas effectué";
                req.setAttribute("errMsg",errMsg);
            }
        }else{
            errMsg = "Les champs ne sont pas remplis";
            req.setAttribute("errMsg", errMsg);
        }
        resp.sendRedirect(req.getContextPath()+"/home");
        
    }
    
    

        
    private void initDispatcher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("admin", "ADMIN");
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/WEB-INF/views/user/editUser.jsp");
        dispatcher.forward(req, resp);
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.servlets;


import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.entities.UserDetail;
import fr.devprojet.dl.creertarecette.entities.Users;
import fr.devprojet.dl.creertarecette.metiers.utils.CookieUtils;
import static fr.devprojet.dl.creertarecette.metiers.utils.CookieUtils.ATT_NAME_USER_ID;
import fr.devprojet.dl.creertarecette.metiers.utils.SessionUtils;
import fr.devprojet.dl.creertarecette.metiers.utils.UserInfoUtils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dev-pro
 */
@WebServlet(urlPatterns = {"/profiluser"})
public class ProfilServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public ProfilServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieUtils.initCookie(req, resp);
        HttpSession session = req.getSession();
        Users userSession = SessionUtils.getLoginedUser(session);
        System.out.println("@@@@@@@@@  test 1 : "+ userSession.toString());
        
        
        UserDetail userInfo = null;
        try {
            //long idUser = Long.parseLong(req.getParameter("id"));
            userInfo = UserInfoUtils.findUserInfo(userSession.getIdUser());
            //userInfo = UserInfoUtils.findUserInfo(idUser);
            req.setAttribute("userInfo", userInfo);} 
        catch (Exception e) {System.out.println("Err ProfilServlet doGet");}
        
        req.setAttribute("admin", "ADMIN");
        RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/user/profilUser.jsp");
        dispatcher.forward(req, resp);
        
    }
    
    
    
    
    
    

    
    
    
}

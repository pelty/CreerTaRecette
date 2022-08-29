/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.servlets;

import fr.devprojet.dl.creertarecette.metiers.utils.CookieUtils;
import fr.devprojet.dl.creertarecette.metiers.utils.Gender;
import fr.devprojet.dl.creertarecette.metiers.utils.UserUtils;
import fr.devprojet.dl.creertarecette.security.Utils.Role;
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
@WebServlet("/formregisteruser")
public class FormRegisterUser extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private UserUtils userUtils;

    public FormRegisterUser() {
        super();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        initDispatcher(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo = req.getParameter("pseudo");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String genderString = req.getParameter("gender");
        String roleString = req.getParameter("role");
        String currentUser = req.getParameter("currentUser");
        
        Gender gender = userUtils.selectGender(genderString);
        Role role = userUtils.selectRole(roleString);
        
        String returnMsgCreateUser = userUtils.createUser(req.getSession(), pseudo, password,password2, gender, role, currentUser);
        req.setAttribute("returnMsg", returnMsgCreateUser);
        
        switch(returnMsgCreateUser){
            case "creation utilisateur reussi" :
                resp.sendRedirect(req.getContextPath() + "/login");
                break;
            case "Utilisateur ajouté" :
                resp.sendRedirect(req.getContextPath()+"/home");
                break;
            case "Le pseudo est deja utilisé" :
                initDispatcher(req, resp);
                break;
            case "Mot de passe diffèrent" :
                initDispatcher(req, resp);
                break;
            case "Vous devez remplir tous les champs" :
                initDispatcher(req, resp);
                break;
            default:
                return;
        }
    }
    
    public void initDispatcher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        CookieUtils.initCookie(req, resp);
        req.setAttribute("admin", "ADMIN");
        
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/security/registerForm.jsp");
        dispatcher.forward(req, resp);
    }

    
//    private String createUser(HttpSession session, String pseudo, String password,String password2, Gender gender, Role role, String currentUser){
//        String result = null;
//        
//        if(!pseudo.isEmpty() && !password.isEmpty() && !password2.isEmpty() && gender!=null){
//            if(password.equals(password2)){
//                Users pseudoData = userImplement.findByName(pseudo);
//                if(pseudoData == null){
//                    Users users = new Users(pseudo, password, role, gender);
//                    userImplement.create(users);
//                    switch(currentUser){
//                        case "ADMIN":
//                            result = "Utilisateur ajouté";
//                            break;
//                        default:
//                            SessionUtils.storeSessionUser(session, users);
//                            return result = "creation utilisateur reussi";
//                    }                    
//                }else result = "Le pseudo est deja utilisé";
//            }else result = "Mot de passe diffèrent";
//            
//        }else result = "Vous devez remplir tous les champs";
//        
//        return result; 
//    }
    
    
}

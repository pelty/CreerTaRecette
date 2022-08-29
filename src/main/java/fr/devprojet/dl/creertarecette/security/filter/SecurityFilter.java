/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.security.filter;

import fr.devprojet.dl.creertarecette.entities.Users;
import fr.devprojet.dl.creertarecette.metiers.request.UserRoleRequestWrapper;
import fr.devprojet.dl.creertarecette.metiers.utils.SessionUtils;
import fr.devprojet.dl.creertarecette.security.Utils.SecurityUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dev-pro
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest wrapRequest = request;
        String servletPath = request.getServletPath();

        // L'informstion d'utilisateur est stockée dans Session
        // (Après l'achèvement de connexion).
        Users loginedUser = SessionUtils.getLoginedUser(request.getSession());
        
        System.out.println("SecurityFilter 1");//########################################################################################################
        if (servletPath.equals("/login")) {
            System.out.println("SecurityFilter 2");//########################################################################################################
            chain.doFilter(request, response);
            return;
        }
        
        System.out.println("SecurityFilter 2.5");//########################################################################################################
        if (loginedUser != null) {
            System.out.println("SecurityFilter 3"+ loginedUser.toString());//########################################################################################################
            // User Name
            String pseudo = loginedUser.getPseudo();
            // Des rôles (Role).
            String roles = String.valueOf(loginedUser.getRole());
            // Envelopper l'ancienne demande (request) par une nouvelle demande avec les informations pseudo et Roles.
            wrapRequest = new UserRoleRequestWrapper(pseudo, roles, request);
            System.out.println("SecurityFilter 4"+ wrapRequest.toString());//########################################################################################################
        }
        
        System.out.println("SecurityFilter 4.5");//########################################################################################################
        
        // Les pages doivent être connectées.
        if (SecurityUtils.isSecurityPage(request)) {
            System.out.println("SecurityFilter 5");//########################################################################################################
            // Si l'utilisateur n'est pas connecté,
            // Redirect (redirigez) vers la page de connexion
            if (loginedUser == null) {
                System.out.println("SecurityFilter 6");//########################################################################################################
                String requestUri = request.getRequestURI();
                System.out.println("SecurityFilter 6.1 : "+requestUri);//########################################################################################################

                // Stockez la page en cours à rediriger après l'achèvement de la connexion.
                int redirectId = SessionUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
                
                System.out.println("SecurityFilter 7 : "+ redirectId);//########################################################################################################
                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }
            
            System.out.println("SecurityFilter 7.5");//########################################################################################################
            
            // Vérifiez si l'utilisateur a un rôle valide?
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                System.out.println("SecurityFilter 7.6 "+ hasPermission);//########################################################################################################
                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/WEB-INF/views/security/testAuth.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        System.out.println("SecurityFilter 8 fin");//########################################################################################################
        chain.doFilter(wrapRequest, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

}
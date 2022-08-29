/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metier.filter;

import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.entities.Users;
import fr.devprojet.dl.creertarecette.metiers.utils.CookieUtils;
import fr.devprojet.dl.creertarecette.metiers.utils.SessionUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dev-pro
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter{
    private static final UserImplement userImplement =  DaoFactory.getInstance().getUserImplement();
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void destroy() {
        
    }
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        Users userInSession = SessionUtils.getLoginedUser(session);
        
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }

        // La Connecxion a été créée dans JDBCFilter.
        //Connection conn = MyUtils.getStoredConnection(request);
        

        // Le drapeau (flag) sert à vérifier Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null) {
            String userName = CookieUtils.getUserNameInCookie(req);
            try {
                Users user = userImplement.findByName(userName);
                SessionUtils.storeLoginedUser(session, user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Marquez qu'il a vérifié Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }

        chain.doFilter(request, response);
	}
}

    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metier.filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author dev-pro
 */
@WebFilter(filterName = "logFilter", urlPatterns = {"/*"})
public class LogFilter implements Filter {
    public LogFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
            System.out.println("LogFilter init!");
    }

    @Override
    public void destroy() {
            System.out.println("LogFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
                        + ", URL =" + req.getRequestURL());

        // Passez à l'élément suivant (filtre ou cible) en chaîne.
        chain.doFilter(request, response);
    }
    
    
}

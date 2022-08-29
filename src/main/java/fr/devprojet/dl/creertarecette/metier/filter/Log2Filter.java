/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metier.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author dev-pro
 */
public class Log2Filter implements Filter{
    private String logFile;

    public Log2Filter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
            this.logFile = fConfig.getInitParameter("logFile");

            System.out.println("Log File " + logFile);
    }

    @Override
    public void destroy() {
            System.out.println("Log2Filter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (this.logFile != null) {
            // Enregistrez les informtions de Log dans le fichier.
            this.logToFile(this.logFile);
        }

        // Autorisez la demande de passer à l'élément suivant (filtre ou cible) en chaîne.
        chain.doFilter(request, response);
    }

    private void logToFile(String fileName) {
            // Enregistrez le log au fichier.
            System.out.println("Write log to file " + fileName);
    }
}

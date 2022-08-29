/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.security.Utils;

import fr.devprojet.dl.creertarecette.security.config.SecurityConfig;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dev-pro
 */
public class SecurityUtils {
    
    // Vérifiez si cette 'request' est requise de se connecter ou non.
    public static boolean isSecurityPage(HttpServletRequest request) {
        System.out.println("SecurityUtils isSecurityPage() 1");//##################################################################
        String urlPattern = UrlPatternUtils.getUrlPattern(request);
        System.out.println("SecurityUtils isSecurityPage() 1.5");//##################################################################
        Set<String> roles = SecurityConfig.getAllAppRoles();

        for (String role : roles) {
            System.out.println("SecurityUtils isSecurityPage() 2 "+ role);//##################################################################
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            System.out.println("SecurityUtils isSecurityPage() 3"+ urlPatterns);//##################################################################
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                System.out.println("SecurityUtils isSecurityPage() 3.5"+ urlPatterns);//##################################################################
                return true;
            }
        }
        return false;
    }
    
    
    // Vérifiez si cette 'request' dont le rôle est validé ou non?
    public static boolean hasPermission(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);
        System.out.println("SecurityUtils hasPermission() 4"+ urlPattern);//##################################################################

        Set<String> allRoles = SecurityConfig.getAllAppRoles();
        System.out.println("SecurityUtils hasPermission() 5"+ allRoles);//##################################################################
        
        for (String role : allRoles) {
            if (!request.isUserInRole(role)) {
                System.out.println("SecurityUtils hasPermission() 6"+ request);//##################################################################
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                System.out.println("SecurityUtils hasPermission() 7"+ urlPatterns);//##################################################################
                return true;
            }
        }
        return false;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.security.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author dev-pro
 */
public class SecurityConfig {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String,List<String>> mapConfig = new HashMap<String,List<String>>();

    static {
        init();
    }

    /**
     * Init configure les roles et les accès aux pages
     */
    private static void init() {
        // Configurez pour le rôle "USER".
        List<String> urlPatterns1 = new ArrayList<String>();
        urlPatterns1.add("/profiluser");
        urlPatterns1.add("/login");
        
        mapConfig.put(ROLE_USER, urlPatterns1);

        // Configurez pour le rôle "ADMIN".
        List<String> urlPatterns2 = new ArrayList<String>();
        urlPatterns2.add("/profiluser");
        urlPatterns2.add("/home");
        urlPatterns2.add("/login");
        mapConfig.put(ROLE_ADMIN, urlPatterns2);
        System.out.println("SecurityConfig init() 1");//########################################################################################################
    }

    public static Set<String> getAllAppRoles() {
        System.out.println("SecurityConfig getAllAppRoles() 2"+ mapConfig.keySet());//########################################################################################################
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        System.out.println("SecurityConfig getUrlPatternsForRole() 3"+ mapConfig.get(role));//########################################################################################################
        return mapConfig.get(role);
    }

}

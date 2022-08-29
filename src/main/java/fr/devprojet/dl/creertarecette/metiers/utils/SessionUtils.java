/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import fr.devprojet.dl.creertarecette.entities.Users;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dev-pro
 */
public class SessionUtils {
    private static final String SESSION_USER_KEY = "SESSION_USER_KEY";
    //public static final String SESSION_LOGINED_USER = "LOGINED_USER";
    private static final String SESSION_LOGINED_USER = "loginedUser";
    private static final Map<Integer, String> ID_URI_MAP = new HashMap<Integer, String>();
    private static final Map<String, Integer> URI_ID_MAP = new HashMap<String, Integer>();

    private static int REDIRECT_ID = 0;

    
    //Stock la session user
    public static void storeSessionUser(HttpSession session, Users user) {
        System.out.println("SessionUtils storeSessionUser() 1 : session ="+ session +" user = "+ user);
        session.setAttribute(SESSION_USER_KEY, user);
    }

    //recupere la key de l'inscription du user
    public static Users getSessionUser(HttpSession session) {
        Users sessionUser = (Users) session.getAttribute(SESSION_USER_KEY);
        System.out.println("SessionUtils getSessionUser() 2 : sessionUser ="+ sessionUser );
        return sessionUser;
    }
    
    // Stockez l'information d'utilisateur dans Session.
    public static void storeLoginedUser(HttpSession session, Users loginedUser) {
        // Sur JSP il est possible d'accéder via ${loginedUser}
        System.out.println("SessionUtils storeLoginedUser() 3 : session ="+ session +" user = "+ loginedUser );
        session.setAttribute(SESSION_LOGINED_USER, loginedUser);
        
    }

    // Obtenez de l'information d'utilisateur stockée dans Session.
    public static Users getLoginedUser(HttpSession session) {
        Users loginedUser = (Users) session.getAttribute(SESSION_LOGINED_USER);
        System.out.println("SessionUtils getLoginedUser() 4 : " + loginedUser );
        return loginedUser;
    }
    
    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        System.out.println("SessionUtils storeRedirectAfterLoginUrl() 5 : session = " + session + " requestUri = " + requestUri );
        
        Integer id = URI_ID_MAP.get(requestUri);
        System.out.println("SessionUtils storeRedirectAfterLoginUrl() 6 : " + id);
        if (id == null) {
            System.out.println("SessionUtils storeRedirectAfterLoginUrl() 7 : " + id);
            id = REDIRECT_ID++;
            System.out.println("SessionUtils storeRedirectAfterLoginUrl() 8 : " + id);

            URI_ID_MAP.put(requestUri, id);
            ID_URI_MAP.put(id, requestUri);
            return id;
        }

        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = ID_URI_MAP.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }
    
    

}

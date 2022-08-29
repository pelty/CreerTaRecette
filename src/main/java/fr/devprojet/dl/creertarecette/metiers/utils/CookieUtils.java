/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import fr.devprojet.dl.creertarecette.entities.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dev-pro
 */
public class CookieUtils {
    public static final String ATT_NAME_USER_NAME = "ATT_NAME_USER_NAME";
    public static final String ATT_NAME_USER_ID = "ATT_NAME_USER_ID";
    
    //Stoker les informations de  l'utilisateur dans cookie
    public static void storeUserNameCookie(HttpServletResponse response, Users user) {
        String idUserString = String.valueOf(user.getIdUser());
        Cookie cookiePseudo = new Cookie(ATT_NAME_USER_NAME, user.getPseudo());
        Cookie cookieIdUser = new Cookie(ATT_NAME_USER_ID, idUserString);
        
        // duree de vie du coookie 1ans (ss * mn * hr * jr * ms)
        cookiePseudo.setMaxAge(60 * 60 * 24 * 30 * 12);
        cookieIdUser.setMaxAge(60 * 60 * 24 * 30 * 12);
        
        response.addCookie(cookiePseudo);
        response.addCookie(cookieIdUser);
        System.out.println("Memoriser le cookie de l'utilisateur");
    }
    
    
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
	}
    
    public static void initCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CookieUtils.ATT_NAME_USER_NAME) ) {
                    req.setAttribute("usernameCookie", cookie.getValue());
                }
            }
        }
    }
    
    

    //Supprime les cookies
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // ce cookie expirera immédiatement
        cookieUserName.setMaxAge(-0);
        response.addCookie(cookieUserName);
    }
}

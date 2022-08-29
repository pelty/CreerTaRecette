/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.dao.implementation.UserInfoImplement;
import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.entities.UserDetail;
import fr.devprojet.dl.creertarecette.entities.Users;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dev-pro
 */
public class UserInfoUtils {
    private static final UserInfoImplement userInfoImplement =  DaoFactory.getInstance().getUserInfoImplement();
    private static final UserImplement userImplement =  DaoFactory.getInstance().getUserImplement();
    
    
    public static String createUserInfo(String firstname, String lastname, String numberString, String email, long idUser) {
        String msg = null;
        if(firstname.length() > 25 || lastname.length() > 25)return msg = "Attention 25 caractere MAX";
        if(!checkNumber(numberString)) return msg = "Vérifier le numéro";
        if(!checkEmail(email)) return msg = "Email incorrecte";
        int number = Integer.parseInt(numberString);
        
        try {
            Users users = userImplement.findById(idUser);
            users.getIdUser();
            
            UserDetail userDetail = new UserDetail(lastname, firstname, number, email, users);
            userDetail.setUsers(users);
            
            userInfoImplement.create(userDetail);
            return msg = "Info user complet";
        } catch (Exception e) {System.out.println("Err UserInfoUtils createUserInfo() : "+ e);}
        return msg;
    }
    
    private static boolean checkNumber(String number){
        String regex = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    
    private static boolean checkEmail(String email){
        boolean bool = false;
        Matcher matcher = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(email);
        if(matcher.find()) bool = true;
        return bool;
      
    }
    /**
     * Cette fonction va recupere les infomations de l'objet UserInfor via ça clef etrangere  
     * @param id_user
     * @return 
     */
    public static UserDetail findUserInfo(long id_user){
        UserDetail userDetail = null;
        Users users = null;
        if (id_user > 0 )
            try {userDetail = userInfoImplement.findByKeyStranger(id_user);} 
            catch (Exception e) {System.out.println("Err UserInfoUtils findUserInfo() : "+ e.getMessage());}
        
        return userDetail;
    }
            
    
}

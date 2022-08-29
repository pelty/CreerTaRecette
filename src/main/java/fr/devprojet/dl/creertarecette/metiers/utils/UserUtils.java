/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.entities.Users;
import fr.devprojet.dl.creertarecette.security.Utils.Role;
import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;


/**
 *
 * @author dev-pro
 */
public class UserUtils {
    private static final UserImplement userImplement =  DaoFactory.getInstance().getUserImplement();
    
    
    
    /**
     * La fonction creer un utilisateur avec les parametres ajouté
     * controle si l'utilisateur hexiste deja 
     * @param session
     * @param pseudo
     * @param password
     * @param password2
     * @param gender
     * @param role
     * @param currentUser
     * @return 
     */
    public static String createUser(HttpSession session, String pseudo, String password,String password2, Gender gender, Role role, String currentUser){
        String result = null;
        
        if(!pseudo.isEmpty() && !password.isEmpty() && !password2.isEmpty() && gender!=null){
            if(password.equals(password2)){
                Users pseudoData = null;
                try {pseudoData = userImplement.findByName(pseudo);} 
                catch (Exception e) {}
                
                if(pseudoData == null){
                    Users users = new Users(pseudo, password, role, gender);
                    try{userImplement.create(users);}
                    catch(Exception e){}
                    
                    switch(currentUser){
                        case "ADMIN":
                            result = "Utilisateur ajouté";
                            break;
                        default:
                            SessionUtils.storeSessionUser(session, users);
                            return result = "creation utilisateur reussi";
                    }                    
                }else result = "Le pseudo est deja utilisé";
            }else result = "Mot de passe diffèrent";
            
        }else result = "Vous devez remplir tous les champs";
        
        return result; 
    }
    
    /**
     * La fonction renvoi le role passé en parametre
     * @param roleString
     * @return 
     */
    public static Role selectRole(String roleString) {
        Role role;
        if(!roleString.equals("ADMIN"))role = Role.USER;
        else {role = Role.ADMIN;}
        return role;
    }
    
    /**
     * La fonction revoi le genre passé en parametre
     * @param gender
     * @return 
     */
    public static Gender selectGender(String gender){
        switch(gender){
            case "M":
                return Gender.M;
            case "F":
                return Gender.F;
            default:
                return null;
        }
    }
    
    /**
     * La fonction cherche l'id user à modifier et renvoi l'objet associé
     * @param idUserString
     * @return 
     */
    public static Users findIdeditUser(String idUserString){
        Users users = null;
        if(!idUserString.isEmpty()){
            long idUser = Long.parseLong(idUserString);
            users = userImplement.findById(idUser);
        }
        return users;
    }
    
    /**
     * La fonction met à jour les données utilisateur
     * @param genderString
     * @param roleString
     * @param pseudo
     * @param password
     * @param idUser
     * @param dateTime
     * @return 
     */
    public static boolean updateUser(String genderString, String roleString, String pseudo, String password, long idUser, LocalDateTime dateTime){
        Role role = selectRole(roleString);
        Gender gender = selectGender(genderString);
        boolean result = false;
        try { 
            Users userUpdate = new Users(pseudo, password, role, gender, dateTime);
            userImplement.update(userUpdate, idUser);
            result = true;
        } catch (Exception e) {}
        return result;
        
    }
    
    /**
     * La fonction supprime le compte de l'utilisateur
     * @param idUserDeleteString
     * @return 
     */
    public static boolean deleteUser(String idUserDeleteString) {
        boolean result = false;
        
        if(!idUserDeleteString.isEmpty()){
            long idUser = Long.parseLong(idUserDeleteString);
            result = userImplement.delete(idUser);
        }
        return result;
    }
    
    
}

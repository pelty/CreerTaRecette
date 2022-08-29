/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.dao.implementation;

import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.daopg.DaoInterface;
import fr.devprojet.dl.creertarecette.daopg.EntityManagerOption;
import fr.devprojet.dl.creertarecette.entities.Users;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev-pro
 */
public class UserImplement extends EntityManagerOption implements DaoInterface<Users>{
    private final DaoFactory DAO_FACTORY;

    public UserImplement(DaoFactory DaoFactory) {
        this.DAO_FACTORY = DaoFactory;
    }

    @Override
    public Users create(Users objet) {
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            setTransaction();
            transaction.begin();
            //entityManager.merge(objet);
            entityManager.persist(objet);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Err creation User \n" + e);
            if(transaction != null){rollbackTransaction();}
        }finally{
            if(entityManager != null){
                closeEntityManager();
            }
        }
        return objet;
    }
    

    @Override
    public List<Users> findAll() {
        List<Users> list = new ArrayList<>();
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            list = entityManager
                    .createQuery("SELECT u FROM Users u")
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Err : FindAll \n"+ e);
        }finally{
            if(entityManager != null){
                closeEntityManager();
            }
        }
        return list;
    }
    
    @Override
    public Users findById(long id) {
        Users user = null;
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            user = entityManager.find(Users.class, id);
        } catch (Exception e) {System.out.println("Err findById User \n" + e);
        } finally {if (entityManager != null) {closeEntityManager(); }}
        return user;
    }
    
    
    @Override
    public Users update(Users newObjet, long id) {
        Users users = findById(id);
        users.setGender(newObjet.getGender());
        users.setRole(newObjet.getRole());
        users.setPseudo(newObjet.getPseudo());
        users.setPassword(newObjet.getPassword());
        
        if(users != null){
            try {
                entityManager = DAO_FACTORY.getEntityManager();
                setTransaction();
                transaction.begin();
                entityManager.merge(users);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Err : Update implement \n"+ e);
                rollbackTransaction();
            }finally{
                if(entityManager != null){
                    closeEntityManager();
                }
            }
        }
        return users;
    }
    public Users updateUsers(Users newObjet, long id){
        Users users = findById(id);
        users.setGender(newObjet.getGender());
        users.setRole(newObjet.getRole());
        users.setPseudo(newObjet.getPseudo());
        users.setPassword(newObjet.getPassword());
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            setTransaction();
            transaction.begin();
            entityManager.merge(users);
            transaction.commit();
            
        } catch (Exception e) {
            System.out.println("Err : Update implement \n"+ e);
                rollbackTransaction();
        }finally{
            if(entityManager != null){
                    closeEntityManager();
                }
        }
        return users;
    }

    @Override
    public boolean delete(long id) {
        Users user = findById(id);
        boolean result = false;
        if(user != null){
            try {
                entityManager = DAO_FACTORY.getEntityManager();
                setTransaction();
                transaction.begin();
                entityManager.remove(entityManager.merge(user));
                transaction.commit();
                result = true;
            } catch (Exception e) {
                System.out.println("Err deleteUser : "+ e);
                rollbackTransaction();
            }finally{
                if(entityManager != null){
                    closeEntityManager();
                }
            }
        }
        return result;
    }
    
    public Users findByName(String pseudo){
        Users users = null;
            try {
                entityManager = DAO_FACTORY.getEntityManager();
                //users = entityManager.find(Users.class, pseudo);
                users = (Users) entityManager.createQuery("SELECT u FROM Users u WHERE u.pseudo LIKE : custName ")
                        .setParameter("custName", pseudo)
                        .getSingleResult();
                
            } catch (Exception e) {System.out.println("Err findByName User \n" + e);
            }finally{if (entityManager != null) {closeEntityManager();}}
        return users;
    }
    
    /**
     * La fonction verifie le Mdp lors de la connexion
     * @param pseudo
     * @param password
     * @return 
     */
    public Users findByName(String pseudo, String password){        
        if(pseudo != null){
            Users pseudoUsers = findByName(pseudo);
            String passwordUsers = pseudoUsers.getPassword();
            System.out.println("################################################################################################");
            System.out.println("Resultat UserImplement findByName() " + pseudoUsers.toString());
            System.out.println("Resultat UserImplement findByName() " + pseudoUsers.getRole());
            System.out.println("UserImplement Mdp formulaire :"+ password);
            System.out.println("UserImplement Mdp bdd :"+ passwordUsers);
            System.out.println("################################################################################################");
            if(password.equals(passwordUsers)){
                System.out.println("Le mot de passe est correcte");
                return pseudoUsers;
            }else System.out.println("UserImplement findByName() Mdp incorrecte");
        }else{System.out.println("UserImplement findByName() Err controlerUsers");}
        return null;
    }
    
    public Users findByPseudo(String pseudo){        
        Users users = null;
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            users = entityManager.find(Users.class, pseudo);
        } catch (Exception e) { System.out.println("Err findByPseudo : "+ pseudo+ "\n" + e);
        }finally{if (entityManager != null) {closeEntityManager();}}
        return users;            
    }
    
    
    
//    public Users signIn(String pseudoString, String passwordString){
//        Users users = findByPseudo(pseudoString);
//        
//        if(pseudoString !=null && passwordString != null){  
//            
//            String pseudo = users.getPseudo();
//            String password = users.getPassword();
//        }
//        return users;
//    }
    /**
    public boolean signIn(String pseudoString, String passwordString){
        boolean result = false;
        if(pseudoString !=null && passwordString != null){  
            Users users = findByPseudo(pseudoString);
            if(users != null){
                String pseudo = users.getPseudo();
                String password = users.getPassword();
            }
        }
        return result;
    }**/
    
    
    
    
    
}

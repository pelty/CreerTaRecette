/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.dao.implementation;

import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.daopg.DaoInterface;
import fr.devprojet.dl.creertarecette.daopg.EntityManagerOption;
import fr.devprojet.dl.creertarecette.entities.UserDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev-pro
 */
public class UserInfoImplement extends EntityManagerOption implements DaoInterface<UserDetail>{
    private final DaoFactory DAO_FACTORY;

    public UserInfoImplement(DaoFactory DaoFactory) {
        this.DAO_FACTORY = DaoFactory;
    }

    @Override
    public UserDetail create(UserDetail objet) {
        try{
            entityManager = DAO_FACTORY.getEntityManager();
            setTransaction();
            transaction.begin();
            entityManager.merge(objet);
            transaction.commit();
        }catch(Exception e){
            System.out.println("Err creation UserDetail \n"+ e);
            if(entityManager != null){rollbackTransaction();}
        }finally{if(entityManager != null)closeEntityManager();}
        return objet;
    }

    @Override
    public List<UserDetail> findAll() {
        List<UserDetail> list = new ArrayList<>();
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            list = entityManager
                    .createQuery("SELECT ud FROM UserDetail ud")
                    .getResultList();
        } catch (Exception e) {System.out.println("Err UserDetail FindAll : \n "+ e);}
        finally{if(entityManager != null)closeEntityManager();}
        return list;
    }

    @Override
    public UserDetail update(UserDetail newObjet, long id) {
        String lastname = newObjet.getLastname();
        String firstname = newObjet.getFirstname();
        int number = newObjet.getNumber();
        String email = newObjet.getEmail();
        
        UserDetail userDetail = new UserDetail(lastname, firstname, number, email);
        if(userDetail != null){
            try {
                entityManager = DAO_FACTORY.getEntityManager();
                setTransaction();
                transaction.begin();
                entityManager.merge(userDetail);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Err UserDetail Update : \n"+ e);
                rollbackTransaction();
            }finally{if(entityManager != null)closeEntityManager();}
        }
        return userDetail;
    }

    @Override
    public boolean delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UserDetail findById(long id) {
        UserDetail userDetail = null;
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            userDetail = entityManager.find(UserDetail.class, id);
        } catch (Exception e) {System.out.println("Err findById UserDetail \n" + e);
        } finally {if (entityManager != null) closeEntityManager();}
        return userDetail;
    }
    
    public UserDetail findByKeyStranger(long id_user){
        UserDetail userDetail = null;
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            userDetail = entityManager.find(UserDetail.class, id_user);
          } 
        
        catch (Exception e) {System.out.println("Err UserInfoImplement findByKeyStranger : \n" + e);}
        finally{if (entityManager != null) closeEntityManager();}
        return userDetail;
    }
    
}

/**
 * userDetail = (UserDetail) entityManager.createQuery("SELECT u FROM UserDetail u WHERE u.id_user LIKE : custId ")
        .setParameter("custId", id_user)
        .getSingleResult();System.out.println("######## test FindByKeyStranger  : "+ userDetail.toString());
 */
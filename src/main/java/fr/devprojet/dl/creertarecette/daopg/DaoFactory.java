package fr.devprojet.dl.creertarecette.daopg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fr.devprojet.dl.creertarecette.dao.implementation.ImageImplement;
import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.dao.implementation.UserInfoImplement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dev-pro
 */
public class DaoFactory {
    private static final String PU_NAME ="jpa-hibernate";
    private final EntityManagerFactory entityManagerFactory;
    private static DaoFactory daoFactory;
    
    
    public DaoFactory(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PU_NAME);
    }
    
    public EntityManager getEntityManager(){
        return this.entityManagerFactory.createEntityManager();
    }
    
    public static DaoFactory getInstance(){
        if(daoFactory == null){daoFactory = new DaoFactory();}
        return  daoFactory;
    }
    
    public void closeEntityManagerFactory(){
        this.entityManagerFactory.close();
    }
    
    public UserImplement getUserImplement(){
        return new UserImplement(this);
    }
    public UserInfoImplement getUserInfoImplement(){
        return new UserInfoImplement(this);
    }
    public ImageImplement getImageImplement(){
        return new ImageImplement(this);
    }
}

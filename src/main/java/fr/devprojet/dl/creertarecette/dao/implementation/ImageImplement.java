/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.dao.implementation;

import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.daopg.DaoImageInterface;
import fr.devprojet.dl.creertarecette.daopg.EntityManagerOption;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author dev-pro
 */
public class ImageImplement extends EntityManagerOption implements DaoImageInterface{
    private final DaoFactory DAO_FACTORY;

    public ImageImplement(DaoFactory DAO_FACTORY) {
        this.DAO_FACTORY = DAO_FACTORY;
    }
    
    @Override
    public void persist(Collection collection) {
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            setTransaction();
            transaction.begin();
            collection.forEach(serializable -> {
                entityManager.persist(serializable);
            });
            transaction.commit();} 
        catch (Exception e) {System.out.println("Err ImageImplement persist(Co) : \n" + e);} 
        finally {if (entityManager != null) closeEntityManager();}
        
    }

    /**
     * Enregistre un objet mappé via des annotations JPA
     * @param data
     */
    @Override
    public void persist(Serializable data) {
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            setTransaction();
            transaction.begin();
            entityManager.persist(data);
            transaction.commit();} 
        catch (Exception e) {System.out.println("Err ImageImplement persit(Se)" + e);} 
        finally {if (entityManager != null) closeEntityManager();}
    }

    /**
     * Retourne toutes les instances d'une classe donnée 
     * @param className : le nom d'une classe annotée par JPA
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List load(String className) {
        Query q = null;
        try {
            entityManager = DAO_FACTORY.getEntityManager();
            q = entityManager.createQuery("from " + className);} 
        catch (Exception e) {System.out.println("Err ImageImplement load() : " + e);} 
        finally {if (entityManager != null) closeEntityManager();}
        
        return q.getResultList();
    }

    
}
 
    
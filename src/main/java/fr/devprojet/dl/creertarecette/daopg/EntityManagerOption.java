/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.daopg;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author dev-pro
 */
public class EntityManagerOption {
    public EntityManager entityManager;
    public EntityTransaction transaction;
    
    public void setTransaction(){
        this.transaction = entityManager.getTransaction();
    }
    
    public void rollbackTransaction(){
        if(transaction != null){
            transaction.rollback();
        }
    }
    
    
    public void closeEntityManager(){
        if(entityManager != null){
            entityManager.close();
        }
    }
}

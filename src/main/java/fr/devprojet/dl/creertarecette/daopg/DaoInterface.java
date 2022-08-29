/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.daopg;

import java.util.List;

/**
 *
 * @author dev-pro
 */
public interface DaoInterface<T> {
    public T create(T objet);
    public List<T> findAll();
    public T update(T newObjet, long id);
    public boolean delete(long id);
    public T findById(long id);
}

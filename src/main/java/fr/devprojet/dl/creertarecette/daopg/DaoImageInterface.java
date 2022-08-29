/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.daopg;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author dev-pro
 */
public interface DaoImageInterface {
    public void persist(Collection collection);
    public void persist(Serializable data);
    public List load(String className);
}

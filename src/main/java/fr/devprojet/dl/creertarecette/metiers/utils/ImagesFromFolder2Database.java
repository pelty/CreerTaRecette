/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;



/**
 *
 * @author dev-pro
 */
public class ImagesFromFolder2Database {
    /**public static void main(String[] args) {
        //Permet d'avoir des chemins de types "C:\Mes Documents", 
        //sinon les espace seront considérés comme des séparateurs
        StringBuilder sb = new StringBuilder();
        //for (int i = 0; i "&lt;" args.length; i++) {
        //    sb.append(args[i]).append("&quot;");
        //}
        File folder = new File(sb.toString());      
        //charger les images depuis le repertoire
        List images = null;
        try {
            images = ImageSerializator.serializeFolder(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }       
        //enregistrement en base
        //GenericDao.persist(images);*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import fr.devprojet.dl.creertarecette.dao.implementation.ImageImplement;
import java.io.File;
import java.util.List;

/**
 *
 * @author dev-pro
 */
public class ImageFromDataBase2Folder {
    /**public static void main(String[] args) {
        //Permet d'avoir des chemins de types "C:\Mes Documents", 
        //sinon les espace seront considérés comme des séparateurs
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i &lt; args.length; i++) {
            sb.append(args[i]).append(&quot; &quot;);
        }
        File folder = new File(sb.toString());      
        //Chargement de la liste d&#039;images sérialisées en base de données
        @SuppressWarnings(&quot;unchecked&quot;)
        List images = ImageImplement.load("MonImage");
        try {
            //Créer le répertoire si il n'existe pas
            if(!folder.exists()){
                folder.mkdir();
            }
            //Ecrire les fichiers
            ImageSerializator.writeFilesIntoFolder(images, folder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

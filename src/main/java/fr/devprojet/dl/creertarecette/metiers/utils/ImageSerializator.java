/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import fr.devprojet.dl.creertarecette.entities.ImageUser;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

/**
 *
 * @author dev-pro
 */
public class ImageSerializator {
    public static ImageUser serializeImage(File imageFile) throws IOException {
        ImageUser imageUser = new ImageUser();
        imageUser.setName(imageFile.getName().substring(0, imageFile.getName() .lastIndexOf(".")));
        imageUser.setMimeType((String) ImageUser.acceptedMimeType.get(imageFile.getName().substring(imageFile.getName() .lastIndexOf(".")+1)));
        imageUser.setImage(ImageIO.read(imageFile));
        return imageUser;
    }
    public static void writeFileIntoFolder(ImageUser imageUser, File folder) throws IOException{
        String extension = getExtension(imageUser.getMimeType());
        File file = new File(folder + "/" + imageUser.getName() + "." + extension);
        file.createNewFile();
        FileImageOutputStream fos = new FileImageOutputStream(file);
        fos.write(imageUser.getImage());
        fos.close();
    }
    
    /**
     * Récupère l'extension du fichier en fonction du type mime dans le dictionnaire des formats d'image acceptés
     * @param mimeType
     * @return
     */
    private static String getExtension(String mimeType) {
        
        for (Iterator it = ImageUser.acceptedMimeType.entrySet().iterator(); it.hasNext();) {
            Entry typeMimeEntry = (Entry) it.next();
            if(mimeType.equals(typeMimeEntry.getValue())){
                return (String) typeMimeEntry.getKey();
            }
        }
        return null;
//        for (Entry typeMimeEntry : ImageUser.acceptedMimeType.entrySet()) {
//            if(mimeType.equals(typeMimeEntry.getValue())){
//                return (String) typeMimeEntry.getKey();
//            }
//        }
        
    }
    
    /**
    * Crée plusieurs fichiers images à partir d'une liste d'images sérialisées, dans le dossier passé en paramètre
    */
    public static void writeFilesIntoFolder(List images, File folder) throws IOException{
        for (Iterator it = images.iterator(); it.hasNext();) {
            ImageUser imageMudu = (ImageUser) it.next();
            writeFileIntoFolder(imageMudu, folder);
        }
    }
    
    /**
    * Sérialise l'ensemble des images contenues dans le répertoire passé en paramètre
    */
    public static List serializeFolder(File folder) throws IOException {
        List images = new ArrayList();
        //Filtre pour ne garder que les fichiers images acceptés
        FileFilter imageFileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                String fileName = file.getName();
                //on extrait l'extension du fichier puis on vérifie qu'elle existe dans le dictionnaire
                String extension = fileName.substring(fileName.lastIndexOf(".")+1);
                if(extension == null || extension.isEmpty()) return false;
                else return ImageUser.acceptedMimeType.containsKey(extension);
            }
        };
        for (File imageFile : folder.listFiles(imageFileFilter)) {
            ImageUser image = serializeImage(imageFile);
            if(image != null){
                images.add(image);
            }
        }
        return images;
    }
}

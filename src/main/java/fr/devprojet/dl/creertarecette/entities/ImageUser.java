/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.entities;

import fr.devprojet.dl.creertarecette.metiers.utils.DictionnaireMimeType;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author dev-pro
 */
@Entity
@Table(name="images")
public class ImageUser extends DictionnaireMimeType implements Serializable{
    @Id
    private String name;
    @Lob()
    private byte[] image;
    @Column(name="mime_type")
    private String mimeType;

    
    public void setImage(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, mimeType.split("image/")[1], baos);
        baos.flush();
        this.image = baos.toByteArray();
        baos.close();
    }
    
    public BufferedImage getBufferedImage() throws IOException {
        return ImageIO.read(new ByteArrayInputStream(image));
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
    
}

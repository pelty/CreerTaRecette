/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author dev-pro
 */
@Entity
public class Comment implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;
    private String comment;
    private LocalDateTime createDate;
    
    @ManyToOne @JoinColumn(name = "id_recette")
    private Recipe recipe;
    
    @ManyToOne @JoinColumn(name = "id_user")
    private Users user;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
        this.createDate = LocalDateTime.now();
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment{idComment=").append(idComment);
        sb.append(", comment=").append(comment);
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}

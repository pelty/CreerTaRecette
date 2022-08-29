/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.entities;

import fr.devprojet.dl.creertarecette.metiers.utils.Gender;
import fr.devprojet.dl.creertarecette.security.Utils.Role;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 *
 * @author dev-pro
 */
@Entity
public class Users implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    //  @Column(name="DESC", nullable=false, length=512)
    @Column(unique = true, length = 25)
    private String pseudo;
    @Column(nullable=false, length=30)
    private String password;
    private Role role;
    private Gender gender;
    private LocalDateTime createDate;
    private LocalDateTime updateDateTime;
    private boolean actif = true;
    
    
    @OneToOne(mappedBy = "users")
    private UserDetail userDetail;
    
    public Users() {
    }

    /**
     * Constructeur utilisé pour update les donnés user
     * @param pseudo
     * @param password
     * @param gender 
     */
    public Users(String pseudo, String password, Role role, Gender gender, LocalDateTime updateDateTime) {
        this.pseudo = pseudo;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.updateDateTime = LocalDateTime.now();
    }
    
    

    /**
     * Constructeur de creation de user
     * @param pseudo
     * @param password
     * @param role
     * @param gender 
     */
    public Users(String pseudo, String password, Role role, Gender gender) {
        this.pseudo = pseudo;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.createDate = LocalDateTime.now();  
    }
    

    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users{idUser=").append(idUser);
        sb.append(", pseudo=").append(pseudo);
        sb.append(", password=").append(password);
        sb.append(", role=").append(role);
        sb.append(", gender=").append(gender);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDateTime=").append(updateDateTime);
        sb.append(", actif=").append(actif);
        sb.append(", userDetail=").append(userDetail);
        sb.append('}');
        return sb.toString();
    }

    
}

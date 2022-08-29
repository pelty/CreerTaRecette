/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dev-pro
 */
@Entity
@Table(name = "userDetail")
public class UserDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUserDetail;
    private String lastname;
    private String firstname;
    
    @Column(unique = true)
    private int number;
    
    @Column(unique = true)
    private String email;

    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private Users users;
    
    
    public UserDetail() {
    }

    public UserDetail(String lastname, String firstname, int number, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.number = number;
        this.email = email;
    }

    public UserDetail(String lastname, String firstname, int number, String email, Users users) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.number = number;
        this.email = email;
        this.users = users;
    }

    
    
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    
    public long getId() {
        return idUserDetail;
    }

    public void setId(long idUserDetail) {
        this.idUserDetail = idUserDetail;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserDetail{idUserDetail=").append(idUserDetail);
        sb.append(", lastName=").append(lastname);
        sb.append(", firstname=").append(firstname);
        sb.append(", number=").append(number);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
    
}

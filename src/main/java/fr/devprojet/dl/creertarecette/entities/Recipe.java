/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author dev-pro
 */
@Entity
public class Recipe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRecipe;
    private String title;
    private String difficult;
    private String recipeType;
    private String description;
    private String nbPerson;
    private String preparationTime;
    private String cookingTime;
    private LocalDateTime createDate;

    @ManyToOne @JoinColumn(name = "id_user")
    private Users user;
    
    @OneToMany @JoinColumn(name = "id_ingredient")
    private List<Ingredient> ingredients = new ArrayList<>(); 
    
    
    public Recipe() {
    }

    public Recipe(String title, String difficult, String recipeType, String description, String nbPerson, String preparationTime, String cookingTime) {
        this.title = title;
        this.difficult = difficult;
        this.recipeType = recipeType;
        this.description = description;
        this.nbPerson = nbPerson;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.createDate = LocalDateTime.now();
    }

    public long getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(long idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNbPerson() {
        return nbPerson;
    }

    public void setNbPerson(String nbPerson) {
        this.nbPerson = nbPerson;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
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
        sb.append("Recipe{idRecipe=").append(idRecipe);
        sb.append(", title=").append(title);
        sb.append(", difficult=").append(difficult);
        sb.append(", recipeType=").append(recipeType);
        sb.append(", description=").append(description);
        sb.append(", nbPerson=").append(nbPerson);
        sb.append(", preparationTime=").append(preparationTime);
        sb.append(", cookingTime=").append(cookingTime);
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
    
    
}

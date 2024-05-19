package br.com.project.model;

//Profile = Perfil

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_profile")
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String biography;
    
    @Column(name = "number_followers")
    private Integer numberFollowers;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getNumberFollowers() {
        return numberFollowers;
    }

    public void setNumberFollowers(Integer numberFollowers) {
        this.numberFollowers = numberFollowers;
    }
}
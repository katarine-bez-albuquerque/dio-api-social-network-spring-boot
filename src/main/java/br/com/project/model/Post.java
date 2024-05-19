package br.com.project.model;

//Post = Poste

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Post {
    protected String title;
    protected String description;
    protected String image;

    public Post() {
    }

    public Post(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
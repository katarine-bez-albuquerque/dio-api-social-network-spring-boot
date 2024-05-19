package br.com.project.model;

//Person = Pessoa

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    protected String photo;
    protected String nome;

    public Person() {
    }
    
    public Person(String photo, String nome) {
        this.photo = photo;
        this.nome = nome;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
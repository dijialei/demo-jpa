package com.diginamic.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "livre")
public class LivreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "TITRE")
    private String titre;
    @Basic
    @Column(name = "AUTEUR")
    private String auteur;

    public LivreEntity() {
    }

    public LivreEntity( String titre, String auteur) {

        this.titre = titre;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivreEntity that = (LivreEntity) o;
        return id == that.id && Objects.equals(titre, that.titre) && Objects.equals(auteur, that.auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, auteur);
    }

    @Override
    public String toString() {
        return "LivreEntity{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}

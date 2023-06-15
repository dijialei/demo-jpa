package com.diginamic.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "article", schema = "compta", catalog = "")
public class ArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "REF")
    private String ref;
    @Basic
    @Column(name = "DESIGNATION")
    private String designation;
    @Basic
    @Column(name = "PRIX")
    private double prix;
    @Basic
    @Column(name = "ID_FOU")
    private int idFou;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdFou() {
        return idFou;
    }

    public void setIdFou(int idFou) {
        this.idFou = idFou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity that = (ArticleEntity) o;
        return id == that.id && Double.compare(that.prix, prix) == 0 && idFou == that.idFou && Objects.equals(ref, that.ref) && Objects.equals(designation, that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ref, designation, prix, idFou);
    }
}

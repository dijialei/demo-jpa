package com.diginamic.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "compo", schema = "compta", catalog = "")
public class CompoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "ID_LIV")
    private int idLiv;
    @Basic
    @Column(name = "ID_EMP")
    private int idEmp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLiv() {
        return idLiv;
    }

    public void setIdLiv(int idLiv) {
        this.idLiv = idLiv;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompoEntity that = (CompoEntity) o;
        return id == that.id && idLiv == that.idLiv && idEmp == that.idEmp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idLiv, idEmp);
    }
}

package com.diginamic.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "emprunt", schema = "compta", catalog = "")
public class EmpruntEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE_DEBUT")
    private Timestamp dateDebut;

    @Column(name = "DATE_FIN")
    private Timestamp dateFin;

    @Column(name = "DELAI")
    private Integer delai;



    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    private ClientEntity client;

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpruntEntity that = (EmpruntEntity) o;
        return id == that.id && client.getId() == that.client.getId() && Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin) && Objects.equals(delai, that.delai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateDebut, dateFin, delai, client.getId());
    }

    @Override
    public String toString() {
        return "EmpruntEntity{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                ", client=" + client.getId() +
                '}';
    }
}

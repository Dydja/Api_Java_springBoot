package com.oda.api.reservation.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
//fichier model la ou je definis mes classes

@Data //Ajout des getters et setters
@Entity//permet de specifier l'entite
@Table(name="users") //spécifie la table correspondant dans la BD
public class User {

    @Id //c'est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) //signifie auto-incremente
    private BigInteger id;

    @Column(name = "lastname")
    private String nom;

    @Column(name = "firstname")
    private String prenom;

    @Column(name="email")
    private String email;

    @Column(name = "phone")
    private String numero;

    @Column(name = "password")
    private String mot_passe;

    //Constructeur
    public User() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }
}

package com.example.applicationroulette.Class;

public class Randonne {
    private int id;
    private String nom;
    private String description;
    private String detail;
    private  int nbParticipant;
    private int nbParticipantRequis;
    private String dateDebut;
    private String imageUrl;


    public Randonne(int id, String nom, String description, String detail, int nbParticipant, int nbParticipantRequis, String dateDebut, String imageUrl) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.detail = detail;
        this.nbParticipant = nbParticipant;
        this.nbParticipantRequis = nbParticipantRequis;
        this.dateDebut = dateDebut;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNbParticipant() {
        return nbParticipant;
    }

    public void setNbParticipant(int nbParticipant) {
        this.nbParticipant = nbParticipant;
    }

    public int getNbParticipantRequis() {
        return nbParticipantRequis;
    }

    public void setNbParticipantRequis(int nbParticipantRequis) {
        this.nbParticipantRequis = nbParticipantRequis;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


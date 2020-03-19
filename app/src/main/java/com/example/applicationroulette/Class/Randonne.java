package com.example.applicationroulette.Class;

import org.json.JSONObject;


public class Randonne {
    private int id;
    private String nomRando;
    private String date;
    private String lieu;
    private String NbParticipant;
    private int NbParticipantRequis;
    private String image;
    private String dateDeFin;

    public Randonne() { }

    public Randonne(int id, String nomRando, String date, String lieu, String nbParticipant, int nbParticipantRequis, String image, String dateDeFin) {
        this.id = id;
        this.nomRando = nomRando;
        this.date = date;
        this.lieu = lieu;
        NbParticipant = nbParticipant;
        NbParticipantRequis = nbParticipantRequis;
        this.image = image;
        this.dateDeFin = dateDeFin;
    }




    /*public Randonne(JSONObject jObject) {
        this.id = jObject.optInt("id");
        this.nomRando = jObject.optString("nomRando");
        this.date = jObject.optString("date");
        this.lieu = jObject.optString("lieu");
        this.NbParticipant = jObject.optInt("NbParticipant");
        this.NbParticipantRequis = jObject.optInt("NbParticipantRequis");
        this.dateDeFin = jObject.optString("dateDeFin");
    }*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomRando() {
        return nomRando;
    }

    public void setNomRando(String nomRando) {
        this.nomRando = nomRando;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNbParticipant() {
        return NbParticipant;
    }

    public void setNbParticipant(String nbParticipant) {
        NbParticipant = nbParticipant;
    }

    public int getNbParticipantRequis() {
        return NbParticipantRequis;
    }

    public void setNbParticipantRequis(int nbParticipantRequis) {
        NbParticipantRequis = nbParticipantRequis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(String dateDeFin) {
        this.dateDeFin = dateDeFin;
    }
}

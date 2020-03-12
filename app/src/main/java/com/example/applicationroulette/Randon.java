package com.example.applicationroulette;

import org.json.JSONObject;

import java.util.Date;

public class Randon {
    private Integer id;
    private String nomRando;
    private String date;
    private String lieu;
    private String nbParticipantRequis;
    private String echeance;


    public Randon(JSONObject jObject) {
        this.id = jObject.optInt("id");
        this.nomRando = jObject.optString("NomRando");
        this.date = jObject.optString("Date");
        this.lieu = jObject.optString("Lieu");
        this.nbParticipantRequis = jObject.optString("NbParticipantRequis");
        this.echeance = jObject.optString("Echeance");
    }
    public Randon(int id, String nom, String d, String l,String nb,String e) {
        this.id = id;
        this.nomRando = nom;
        this.date = d;
        this.lieu = l;
        this.nbParticipantRequis = nb;
        this.echeance = e;
    }
    public int getid() { return id; }
    public String getNomRando() { return nomRando; }
    public String getDate() { return date; }
    public String getLieu() { return lieu; }
    public String getNbParticipantRequis() { return nbParticipantRequis; }
    public String getEcheance() { return echeance; }

}



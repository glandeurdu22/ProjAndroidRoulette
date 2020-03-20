package com.example.applicationroulette;

import android.os.Parcelable;

import org.json.JSONObject;

public class Membre {

        private Integer id;
        private String Nom;
        private String type;
        private String mdp;
        private String prenom;
        private String Adresse;
        private String Telephone;

        public Membre(JSONObject jObject) {
            this.id = jObject.optInt("id");
            this.Nom = jObject.optString("Nom");
            this.type = jObject.optString("type");
            this.mdp = jObject.optString("mdp");
            this.prenom = jObject.optString("Prenom");
            this.Adresse = jObject.optString("Adresse");
            this.Telephone = jObject.optString("Telephone");
        }

        public int getid() { return id; }
        public String getNom() { return Nom; }
        public String gettype() { return type; }
        public String getmdp() { return mdp; }
        public String getprenom() { return prenom; }
        public String getAdresse() { return Adresse; }
        public String getTelephone() { return Telephone; }


}

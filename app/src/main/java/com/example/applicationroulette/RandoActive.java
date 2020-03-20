package com.example.applicationroulette;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RandoActive extends AppCompatActivity {
    TextView NomId;
    TextView DateId;
    TextView LieuId;
    TextView NombreRequisId;
    TextView EcheanceId;
    // private ProgressBar loading;
    private static String REGISTER_URL = "https://randojoe.000webhostapp.com/DetailRando.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        NomId = findViewById(R.id.textViewNom);
        DateId = findViewById(R.id.textViewdate);
        LieuId = findViewById(R.id.textViewLaval);
        NombreRequisId = findViewById(R.id.textViewnb);
        EcheanceId = findViewById(R.id.textViewEcheance);
        DetailRando();
    }

    private void DetailRando() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response","********************** lancement randoactive ");
                        Log.i("randoactive ", "["+response+"]");
                        Toast.makeText(getApplicationContext(),"this is response rando active: "+response,Toast.LENGTH_LONG).show();
                        Log.d("Response", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            Randon a = new Randon(jsonObject);
                            String nom = a.getNomRando();
                            String date = a.getDate();
                            String lieu = a.getLieu();
                            String nb = a.getNbParticipantRequis();
                            String echean = a.getEcheance();
                            NomId.setText(nom);
                            DateId.setText(date);
                            LieuId.setText(lieu);
                            NombreRequisId.setText(nb);
                            EcheanceId.setText(echean);

                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(RandoActive.this,"L'enregistrement a échoué "+e.toString(), Toast.LENGTH_LONG).show();
                            //loading.setVisibility(View.GONE);
                            // btnEnregistrerId.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RandoActive.this,"L'enregistrement a échoué 2 "+error.toString(), Toast.LENGTH_SHORT).show();
                        // loading.setVisibility(View.GONE);
                        //btnEnregistrerId.setVisibility(View.VISIBLE);
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}

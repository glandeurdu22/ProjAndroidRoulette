package com.example.applicationroulette;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.applicationroulette.Class.Randonne;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RandoActive extends AppCompatActivity {
    TextView NomId;
    TextView DateId;
    TextView LieuId;
    TextView NombreRequisId;
    TextView EcheanceId;
    private static String REGISTER_URL = "https://randojoe.000webhostapp.com/AfficherRando.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fake_detail_rando_montblanc);
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

                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray array=jsonObject.getJSONArray("data");
                            if(response.contains("data")) {
                                Log.d("Response 3", response);
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject ob = array.getJSONObject(i);
                                    Log.d("Response 4", response);
                                    Randonne randonneList = new Randonne(ob.getInt("id"), ob.getString("nom"), ob.getString("description"), ob.getString("detail"), ob.getInt("nbParticipant"), ob.getInt("nbParticipantRequis"), ob.getString("dateDebut"), ob.getString("imageUrl"));
                                    String nom = randonneList.getNom();
                                    String date = randonneList.getDateDebut();
                                    String lieu = randonneList.getDescription();
                                    int nb = randonneList.getNbParticipantRequis();
                                    String echean = randonneList.getDetail();
                                    NomId.setText(String.valueOf(nom));
                                    DateId.setText(String.valueOf(date));
                                    LieuId.setText(String.valueOf(lieu));
                                    NombreRequisId.setText(String.valueOf(nb));
                                    EcheanceId.setText(String.valueOf(echean));
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
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

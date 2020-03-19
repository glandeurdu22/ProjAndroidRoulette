package com.example.applicationroulette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.applicationroulette.Class.Adapter;
import com.example.applicationroulette.Class.Randonne;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    Adapter adapter;
    ArrayList<Randonne> randonnes;
    LinearLayoutManager linearLayoutManager;
    Context ctx;
    Randonne randonne;

    private static String AfficherRando_URL = "https://randojoe.000webhostapp.com/AffichageRando.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.LesRandos);
        randonnes = new ArrayList<>();
        parseJson();

    }

    private void parseJson() {
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, AfficherRando_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("Response","********************** lancement HomeActivity ");
                Log.i("tagconvertstr 1 ", "["+response+"]");
                Log.d("Response", String.valueOf(response));


                    for (int i = 0; i<response.length(); i++) {
                        try {


                            JSONObject randoObjet = response.getJSONObject(i);

                            Randonne randonne = new Randonne();
                            randonne.setNomRando(randoObjet.getString("NomRando"));
                            randonne.setNbParticipant(randoObjet.getString("NbParticipant"));
                            randonne.setImage(randoObjet.getString("image"));

                            randonnes.add(randonne);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    adapter = new Adapter(getApplicationContext(),randonnes);
                    recyclerView.setAdapter(adapter);
                }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse: " +  error.getMessage());

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}

package com.example.applicationroulette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.applicationroulette.Class.Randonne;
import com.example.applicationroulette.Class.RandonneAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static final String Affichage_Url = "https://randojoe.000webhostapp.com/AffichageRando.php";
    private RecyclerView recyclerView;
    private List<Randonne> randonnes;
    private RandonneAdapter randonneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) this.findViewById(R.id.ViewRando);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        randonnes = new ArrayList<>();
        randonneAdapter = new RandonneAdapter(randonnes,this);
        recyclerView.setAdapter(randonneAdapter);

        RecupData();

    }

    private void RecupData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Affichage_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("Response","********************** lancement HomeActivity ");
                Log.d("Response", response);
                try {

                    Log.d("Response 2", response);

                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray  array=jsonObject.getJSONArray("data");
                    if(response.contains("data")){
                        Log.d("Response 3", response);

                        for (int i = 0; i <array.length(); i++) {
                            JSONObject ob = array.getJSONObject(i);
                            Log.d("Response 4", response);

                            Randonne randonneList = new Randonne(ob.getInt("id"), ob.getString("nom"), ob.getString("description"), ob.getString("detail"), ob.getInt("nbParticipant"), ob.getInt("nbParticipantRequis"), ob.getString("dateDebut"), ob.getString("imageUrl"));

                            randonnes.add(randonneList);
                            recyclerView.setAdapter(randonneAdapter);
                            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
                            recyclerView.addItemDecoration(dividerItemDecoration);

                        }
                        }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
//Décoration

}


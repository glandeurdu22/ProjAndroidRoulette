package com.example.applicationroulette;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMembreActivity extends AppCompatActivity {
    RecyclerView Rando;
    RecyclerView RandoPasActive;
    private static String REGISTER_URL = "https://randojoe.000webhostapp.com/AffichageRando.php";
    // FOR DESIGN
    @BindView(R.id.RandoActive) RecyclerView recyclerView; // 1 - Declare RecyclerView

    // 2 - Declare list of users (GithubUser) & Adapter
    private List<Randon> lesRando;
    private AdapterRando adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_membre, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView();
        this.duredure();
        return view;
    }

    private void updateUI(List<Randon> lesRandos){
        lesRando.addAll(lesRandos);
        adapter.notifyDataSetChanged();
    }


    private void configureRecyclerView(){
        this.lesRando = new ArrayList<>();
        //  Create adapter passing the list of users
        this.adapter = new AdapterRando(this.lesRando);
        // Attach the adapter to the recyclerview to populate items
        this.recyclerView.setAdapter(this.adapter);
    }
    public void duredure(){
        Randon ra = new Randon(1, "Rando1", "03/10/2020", "Laval","3","06/09/2020");
        lesRando.add(ra);
        updateUI(lesRando);
    }
    private void executeSearchRando(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            Randon ra = new Randon(1, "Rando1", "03/10/2020", "Laval","3","06/09/2020");
                            lesRando.add(ra);
                            updateUI(lesRando);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeMembreActivity.this,"L'enregistrement a échoué 2 "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });



    }

}

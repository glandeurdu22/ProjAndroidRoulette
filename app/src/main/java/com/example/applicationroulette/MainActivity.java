package com.example.applicationroulette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button ConnexionId, CreerCompteId;
    EditText EmailId, PasswordId;
    private static String LOGIN_URL = "https://randojoe.000webhostapp.com/login.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailId = findViewById(R.id.txtEmail);
        PasswordId = findViewById(R.id.txtPasswordLogin);
        ConnexionId = findViewById(R.id.btnConnexion);
        CreerCompteId = findViewById(R.id.btnCreerUnCompte);
        ecouteConnexion();
        ecouteEnregistrement();



    }

    private void ecouteConnexion() {
        ConnexionId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EmailId.getText().toString().trim();
                String password = PasswordId.getText().toString().trim();
                //on vérifie que l'email et le mot de passe sont rentrés
                if (email.isEmpty()) {
                    EmailId.setError("Veuillez saisir un identifiant");
                    EmailId.requestFocus();
                } else if (password.isEmpty()) {
                    PasswordId.setError("Veuillez saisir un mot de passe");
                    PasswordId.requestFocus();

                    //on vérifie si aucun champs n'est remplis
                } else {
                   Login(email,password);

                }


            }
        });

    }

    private void Login(final String email, final String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if(success.equals("1")){
                                for (int i = 0; i < jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();

                                    startActivity(new Intent(MainActivity.this,RegistrationActivity.class));

                                    Toast.makeText(MainActivity.this,"Vous êtes connecté. \nVotre nom est: "+ name+" Votre email est "+email, Toast.LENGTH_SHORT).show();

                                }
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this,"la connexion a échoué "+e.toString(), Toast.LENGTH_SHORT).show();
                           // loading.setVisibility(View.GONE);
                            //btnEnregistrerId.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"La connexion a échoué "+error.toString(), Toast.LENGTH_SHORT).show();
                        //loading.setVisibility(View.GONE);
                       // btnEnregistrerId.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };
    }

    //Ecoute évènement sur bouton connexion
    private void ecouteEnregistrement(){
        CreerCompteId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));

                Toast.makeText(MainActivity.this,"Enregistrer un compte",Toast.LENGTH_LONG).show();

            }
        });
    }


}

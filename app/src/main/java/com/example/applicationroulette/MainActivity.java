package com.example.applicationroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button ConnexionId, CreerCompteId;
    EditText EmailId, PasswordId;
    private static String LOGIN_URL = "https://randojoe.000webhostapp.com/login.php";
    RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailId = findViewById(R.id.txtEmail);
        PasswordId = findViewById(R.id.txtPasswordLogin);
        ConnexionId = findViewById(R.id.btnConnexion);
        CreerCompteId = findViewById(R.id.btnCreerUnCompte);
        requestQueue = Volley.newRequestQueue(MainActivity.this);

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
                if (email.isEmpty() || password.isEmpty()) {
                    EmailId.setError("Veuillez saisir un identifiant");
                    PasswordId.setError("Veuillez saisir un mot de passe");
                    EmailId.requestFocus();
                    PasswordId.requestFocus();
                    Log.d("Pass word","********************** l'email n'est pas saisi");
                    Log.d("Pass word","********************** le mot de passe n'est pas saisi");
                    return;

                    //on vérifie si aucun champs n'est remplis
                } else {
                    Login();

                }

            }
        });

    }

    private void Login() {
        final String email = EmailId.getText().toString().trim();
        final String password = PasswordId.getText().toString().trim();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //V2RIfication dans logcats
                    Log.d("Response","********************** lancement MainActivity ");
                    Log.i("tagconvertstr 1 ", "["+response+"]");
                    Log.d("Response", response);

                        if(response.contains("1")){
                            //Ouverture du profil
                                openProfile();
                        }else{
                            Toast.makeText(MainActivity.this,"Veuillez-vous inscrire!", Toast.LENGTH_LONG).show();

                        }
                  }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"La connexion a échoué "+error.toString(), Toast.LENGTH_LONG).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    //Ouverture du profil
    private void openProfile() {
        startActivity(new Intent(this, HomeActivity.class));

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

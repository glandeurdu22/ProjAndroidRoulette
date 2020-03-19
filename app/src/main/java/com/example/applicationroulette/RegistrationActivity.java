package com.example.applicationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    EditText PrenomId;
    EditText EmailId;
    EditText AdresseId;
    EditText TelephoneId;
    EditText PasswordId;
    RadioGroup RadioGroupId;
    RadioButton RadioBouttonId;
    Button btnEnregistrerId;
    String type = "Non";
   // private ProgressBar loading;
    private static String REGISTER_URL = "https://randojoe.000webhostapp.com/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        PrenomId = findViewById(R.id.txtPrenom);
        EmailId = findViewById(R.id.txtEmailEnre);
        AdresseId = findViewById(R.id.txtAdresse);
        TelephoneId = findViewById(R.id.txtTelephone);
        PasswordId = findViewById(R.id.txtPasswordEnregistrer);
        RadioGroupId = findViewById(R.id.RbtnGrp);
        btnEnregistrerId = findViewById(R.id.btnEnregistrer);

        EnregistrerAction();
    }



    public void EnregistrerAction (){

        btnEnregistrerId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EnregistrerMembre();

            }
        });

    }



    private void EnregistrerMembre() {
        //loading.setVisibility(View.VISIBLE);
      //  btnEnregistrerId.setVisibility(View.GONE);

    //Récupération des saisis utilisateur
       final String name = PrenomId.getText().toString();
       final String email = EmailId.getText().toString();
       final String adresse = AdresseId.getText().toString();
       final String telephone = TelephoneId.getText().toString();
       final String password = PasswordId.getText().toString();


       //bouton radio
        //ici on récupère le boutton coché
       final int x = RadioGroupId.getCheckedRadioButtonId();
        RadioBouttonId = findViewById(x);

        if (RadioBouttonId.getText().toString().equals("Oui")){
             type = "Oui";
        }else{
            type = "Non";
        }
        //

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")){
                                Toast.makeText(RegistrationActivity.this,"Vous êtes enregistré", Toast.LENGTH_SHORT).show();

                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(RegistrationActivity.this,"L'enregistrement a échoué "+e.toString(), Toast.LENGTH_LONG).show();
                            //loading.setVisibility(View.GONE);
                           // btnEnregistrerId.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistrationActivity.this,"L'enregistrement a échoué 2 "+error.toString(), Toast.LENGTH_SHORT).show();
                       // loading.setVisibility(View.GONE);
                        //btnEnregistrerId.setVisibility(View.VISIBLE);
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("Adresse",adresse);
                params.put("Telephone",telephone);
                params.put("password",password);
                params.put("Type", type);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}

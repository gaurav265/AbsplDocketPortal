package com.rajput.gaurav.alliancebroadband;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {


    private Button LoginButton;
    public EditText mo;
    public String result;
    public String url;


    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        url="https://api.myjson.com/bins/ehdxa";


        LoginButton = (Button) findViewById(R.id.login_button);
        mo = (EditText) findViewById(R.id.mo_ph);


        rq = Volley.newRequestQueue(this);
        jsonparse();

    }

    private void  jsonparse(){

LoginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         String mobile=null;
        mobile = mo.getText().toString();
        result=url+mobile;

        final JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, result, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject validator=null;

                try {
                    validator=response.getJSONObject(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                    if(validator==null){

                        Toast.makeText(LoginActivity.this,"Your Mobile No. is Not Registered",Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {
                        Intent mainintent=new Intent(LoginActivity.this,MainActivity.class);
                        mainintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mainintent);
                         finish();
                    }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(request);


    }

});





    }




}

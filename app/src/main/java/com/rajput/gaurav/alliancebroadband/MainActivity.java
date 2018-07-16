package com.rajput.gaurav.alliancebroadband;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.String;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


     TextView clientid;
     TextView username;
     TextView ipaddress;
     TextView packagename,Fullname;


     String ClientId,UserName,IpAddress,PackageName,FullName;
     String url="http://www.json-generator.com/api/json/get/bUXQtYGndu?indent=2";


   private  RequestQueue rq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fullname = (TextView) findViewById(R.id.full_name);
        clientid = (TextView) findViewById(R.id.client_id);
        username = (TextView) findViewById(R.id.user_name);
        ipaddress = (TextView) findViewById(R.id.ip_address);
        packagename = (TextView) findViewById(R.id.package_name);

          rq=Volley.newRequestQueue(this);
          jsonparse();


    }


    private void  jsonparse(){

        final JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                String json=response.toString();
                ipaddress.setText(json);


                JSONObject jo=null;
                JSONObject ipAcctCustomerIp=null;
                JSONObject pack=null;


                try {
                    jo=response.getJSONObject(0);
                    FullName=jo.getString("name");
                    ClientId=jo.getString("customerId");
                    Fullname.setText(FullName);
                    clientid.setText(ClientId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    ipAcctCustomerIp=jo.getJSONObject("ipAcctCustomerIp");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    IpAddress=ipAcctCustomerIp.getString("ip");
                    UserName=ipAcctCustomerIp.getString("login");
                    ipaddress.setText(IpAddress);
                    username.setText(UserName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                try {
                    pack=jo.getJSONObject("pack");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    PackageName=pack.getString("packageName");
                    packagename.setText(PackageName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             error.printStackTrace();
            }
        });

       rq.add(request);
  }

}

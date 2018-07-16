package com.rajput.gaurav.alliancebroadband;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.lang.AutoCloseable;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {

        String finalurl;
        String data;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected Void doInBackground(Void... voids)
    {
        try(


                URL url=new URL("");

                HttpURLConnection httpurlconnection =(HttpURLConnection)  url.openConnection();
                InputStream inputstream = httpurlconnection.getInputStream();
                BufferedReader bufferreader = new BufferedReader(new InputStreamReader(inputstream));
                String line= "";

                while(line!=null){

             line=bufferreader.readLine();
             data=data+line;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
 /*   } catch(MalformedURLException e){
          e.printStackTrace();

        } catch (IOException e1) {
            e.printStackTrace();
        }*/



        return null;
}

    @Override
    protected void onPostExecute(Void aVoid)

    {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.data);
    }
}

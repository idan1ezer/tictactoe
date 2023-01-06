package com.techsoldev.tictactoegame.http.login;

import android.os.AsyncTask;

import com.techsoldev.tictactoegame.http.MyHTTPInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Login extends AsyncTask<Void, Void, Boolean> {
    private String username;
    private String password;
    private MyHTTPInterface mListener;


    public Login(String username, String password, MyHTTPInterface mListener) {
        this.username = username;
        this.password = password;
        this.mListener = mListener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        URL url = null;
        try {
            url = new URL("http://10.0.2.2:8082/superapp/users/login/2023a.roni.aronson/" + username + "/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            return true;
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private Boolean parseLoginResponse(String responseBody) {
        System.out.println(responseBody);
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (mListener != null)
            mListener.myMethod(result);
    }
}
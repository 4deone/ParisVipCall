package com.bydeone.parisvipcall.controllers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bydeone.parisvipcall.R;
import com.bydeone.parisvipcall.models.AsyncResult;
import com.bydeone.parisvipcall.models.DownloadPage;
import com.bydeone.parisvipcall.models.LoginPassword;
import com.bydeone.parisvipcall.models.LoginPasswordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "HttpExample";
    ArrayList<LoginPassword> loginPasswords = new ArrayList<LoginPassword>();
    ListView listview;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);
        btnDownload = (Button) findViewById(R.id.btnDownload);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            btnDownload.setEnabled(true);
        } else {
            btnDownload.setEnabled(false);
        }
    }

    public void buttonClickHandler(View view) {
        new DownloadPage(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://spreadsheets.google.com/tq?key=19ttjCqT9DVNvCQ-d2ES3puPU-sU1JJLsrjdLiS4i9l4");

    }


    private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                int position = columns.getJSONObject(0).getInt("v");
                String nomService = columns.getJSONObject(1).getString("v");
                String login = columns.getJSONObject(2).getString("v");
                String password = columns.getJSONObject(3).getString("v");
                String type = columns.getJSONObject(4).getString("v");
                String commentaire = columns.getJSONObject(5).getString("v");
                LoginPassword loginPassword = new LoginPassword(position, nomService, login, password, type, commentaire);
                loginPasswords.add(loginPassword);
            }

            final LoginPasswordAdapter adapter = new LoginPasswordAdapter(this, R.layout.pass_adapter, loginPasswords);
            listview.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

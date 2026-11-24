package com.example.seminar9;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ActivityWeather extends AppCompatActivity {

    private static final String API_KEY = "287430";
    Executor executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etOras = findViewById(R.id.etOras);
        Button btnCauta = findViewById(R.id.btnCauta);
        TextView tvRezultat = findViewById(R.id.tvRezultat);

        btnCauta.setOnClickListener(v->{
            executor.execute(new Runnable(){
                @Override
                public void run(){
                    try{
                        String link = "https://dataservice.accuweather.com/locations/v1/cities/:countryCode/:adminCode/search?q=<string>"
                                +API_KEY;
                        URL url = new URL(link);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuilder builder = new StringBuilder("");

                        JSONArray vector =  new JSONArray(builder.toString());
                        JSONObject obiect = vector.getJSONObject(0);
                        String cheieOras = obiect.getString("Key");

                        String line;
                        while ((line = reader.readLine()) != null) {
                            builder.append(line);
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                tvRezultat.setText("cheia: " + cheieOras);
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            });
        });


    }
}
package com.example.sem4_aplicatii;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NewActivity extends AppCompatActivity {

    private ArrayList<ImaginiDomeniu> lista = new ArrayList<>();
    private ImagineAdapter adapter;
    private ArrayList<Bitmap> imagini = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(R.id.imagini);

        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://static.bcchauto.ro/blog/620/masini-1000-cp.jpg");
        linkuriImagini.add("https://usercontent.cdn.workleto.com/bcchauto/carstock/27152/6980c9d22326f1770047954-86980c9d24b604.jpg");
        linkuriImagini.add("");
        linkuriImagini.add("");
        linkuriImagini.add("");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link : linkuriImagini) {
                    HttpURLConnection con = null;
                    try {
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        con.setRequestProperty("User-Agent", "Mozilla/5.0");
                        InputStream is = con.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    } catch (IOException e) {
                        imagini.add(null);
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lista.add(new ImaginiDomeniu("Masini 1000 CP", imagini.get(0), "https://ro.wikipedia.org/wiki/Automobil"));
                        lista.add(new ImaginiDomeniu("Masina 2", imagini.get(1), "https://ro.wikipedia.org/wiki/Automobil"));
                        lista.add(new ImaginiDomeniu("Masina 3", imagini.get(2), "https://ro.wikipedia.org/wiki/Automobil"));
                        lista.add(new ImaginiDomeniu("Masina 4", imagini.get(3), "https://ro.wikipedia.org/wiki/Automobil"));
                        lista.add(new ImaginiDomeniu("Masina 5", imagini.get(4), "https://ro.wikipedia.org/wiki/Automobil"));

                        adapter = new ImagineAdapter(NewActivity.this, R.layout.layout_image, lista);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
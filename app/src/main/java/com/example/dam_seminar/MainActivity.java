package com.example.dam_seminar;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar", "onStart - error");
        Log.w("Seminar", "onStart - warning");
        Log.d("Seminar", "onStart - debug");
        Log.i("Seminar", "onStart - info");
        Log.v("Seminar", "onStart - verbose");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Seminar", "onResume - error");
        Log.w("Seminar", "onResume - warning");
        Log.d("Seminar", "onResume - debug");
        Log.i("Seminar", "onResume - info");
        Log.v("Seminar", "onResume - verbose");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Seminar", "onPause - error");
        Log.w("Seminar", "onPause - warning");
        Log.d("Seminar", "onPause - debug");
        Log.i("Seminar", "onPause - info");
        Log.v("Seminar", "onPause - verbose");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Seminar", "onStop - error");
        Log.w("Seminar", "onStop - warning");
        Log.d("Seminar", "onStop - debug");
        Log.i("Seminar", "onStop - info");
        Log.v("Seminar", "onStop - verbose");
    }
}
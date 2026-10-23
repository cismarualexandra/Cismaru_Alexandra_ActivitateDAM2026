package com.example.sem4_aplicatii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvRezultat;

    private final ActivityResultLauncher<Intent> launcher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Bundle extras = result.getData().getExtras();
                            AMasina masina = (AMasina) extras.getSerializable("masina");
                            if (masina != null) {
                                tvRezultat.setText(masina.toString());
                                Toast.makeText(this, masina.toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

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

        tvRezultat = findViewById(R.id.tvRezultat);
        Button btnAdauga = findViewById(R.id.btnAdauga);

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            launcher.launch(intent);
        });

        Button btnAdaugaAI = findViewById(R.id.btnAdaugaAI);
        btnAdaugaAI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddActivityAI.class);
            launcher.launch(intent);
        });
    }
}
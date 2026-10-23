package com.example.sem4_aplicatii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText etMarca = findViewById(R.id.etMarca);
        CheckBox cbNoua = findViewById(R.id.cbNoua);
        RadioGroup rgCombustibil = findViewById(R.id.rgCombustibil);
        Spinner spCuloare = findViewById(R.id.spCuloare);
        RatingBar rbRating = findViewById(R.id.rbRating);
        Switch swAutomata = findViewById(R.id.swAutomata);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        String[] culori = {"Alb", "Negru", "Rosu", "Albastru"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, culori);
        spCuloare.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String marca = etMarca.getText().toString();
            boolean noua = cbNoua.isChecked();
            String combustibil =
                    rgCombustibil.getCheckedRadioButtonId() == R.id.rbDiesel ? "Diesel" : "Benzina";
            String culoare = spCuloare.getSelectedItem().toString();
            float rating = rbRating.getRating();
            boolean automata = swAutomata.isChecked();

            AMasina masina = new AMasina(marca, culoare, noua, combustibil, automata, rating);
            Bundle bundle = new Bundle();
            bundle.putSerializable("masina", masina);

            Intent rezultat = new Intent();
            rezultat.putExtras(bundle);
            setResult(RESULT_OK, rezultat);
            finish();
        });
    }
}
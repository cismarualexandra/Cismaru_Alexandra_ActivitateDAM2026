package com.example.sem4_aplicatii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class LIstaActivity extends AppCompatActivity {
    private ArrayList<AMasina> listMasini = null;
    private int idModificat = 0;
    private Adapter adapter = null;

    private final ActivityResultLauncher<Intent> launcherModifica =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            AMasina masinaNoua = (AMasina) result.getData()
                                    .getSerializableExtra("masina");
                            if (masinaNoua != null) {
                                listMasini.set(idModificat, masinaNoua);
                                adapter.notifyDataSetChanged();
                            }
                            Intent rezultat = new Intent();
                            rezultat.putExtra("lista", listMasini);
                            setResult(RESULT_OK, rezultat);
                        }
                    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lvMasini = findViewById(R.id.lvMasini);

        listMasini = getIntent().getParcelableArrayListExtra("lista");
        if (listMasini == null) {
            listMasini = new ArrayList<>();
        }

        //ArrayAdapter<AMasina> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);

        adapter = new Adapter(this, R.layout.adapter, listMasini);
        lvMasini.setAdapter(adapter);

        lvMasini.setOnItemClickListener((parent, view, position, id) -> {
            Intent intentModifica = new Intent(this, AddActivity.class);
            intentModifica.putExtra("masina", listMasini.get(position));
            idModificat = position;
            launcherModifica.launch(intentModifica);
        });
    }

}
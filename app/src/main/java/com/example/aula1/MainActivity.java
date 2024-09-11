package com.example.aula1;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSalvar, btnRemover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnRemover = (Button) findViewById(R.id.btnRemover);

        btnSalvar.setOnClickListener(view -> {
            Toast.makeText(this, "Salvou", Toast.LENGTH_SHORT).show();
        });

        btnRemover.setOnClickListener(view -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Atenção");
            alert.setMessage("Deseja remover esse registro?");
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setNegativeButton("Não", null);
            alert.setPositiveButton("Sim", (dialog, which) -> {
                Toast.makeText(this, "Removeu!!", Toast.LENGTH_SHORT).show();
            });
            alert.show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
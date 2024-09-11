package com.example.aula1;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraActivity extends AppCompatActivity {

    Button btnSomar, btnSubtrair, btnLimpar;

    double num1, num2, sumResult, subtractResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        btnSomar = (Button) findViewById(R.id.btnSum);
        btnSubtrair = (Button) findViewById(R.id.btnSubtract);
        btnLimpar = (Button) findViewById(R.id.btnClean);

        EditText editTextNum1 = findViewById(R.id.txtNumber1);
        EditText editTextNum2 = findViewById(R.id.txtNumber2);

        // Atualize os números quando o botão for clicado, não na inicialização
        btnSomar.setOnClickListener(view -> {
            String num1Text = editTextNum1.getText().toString();
            String num2Text = editTextNum2.getText().toString();

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                // Se algum dos campos estiver vazio, exibe uma mensagem de erro
                new AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Por favor, insira números válidos em ambos os campos.")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            try {
                num1 = Double.parseDouble(num1Text);
                num2 = Double.parseDouble(num2Text);
                sumResult = num1 + num2;

                // Exibe o resultado da soma
                new AlertDialog.Builder(this)
                        .setTitle("Resultado da soma:")
                        .setMessage("O resultado da soma é " + sumResult)
                        .setPositiveButton("OK", null)
                        .show();
            } catch (NumberFormatException e) {
                // Trata a exceção se ocorrer um erro de conversão
                new AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Erro ao converter números. Verifique a entrada.")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        btnSubtrair.setOnClickListener(view -> {
            String num1Text = editTextNum1.getText().toString();
            String num2Text = editTextNum2.getText().toString();

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                // Se algum dos campos estiver vazio, exibe uma mensagem de erro
                new AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Por favor, insira números válidos em ambos os campos.")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            try {
                num1 = Double.parseDouble(num1Text);
                num2 = Double.parseDouble(num2Text);
                subtractResult = num1 - num2;

                new AlertDialog.Builder(this)
                        .setTitle("Resultado da soma:")
                        .setMessage("O resultado da Subtração é " + subtractResult)
                        .setPositiveButton("OK", null)
                        .show();
            } catch (NumberFormatException e) {
                // Trata a exceção se ocorrer um erro de conversão
                new AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Erro ao converter números. Verifique a entrada.")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
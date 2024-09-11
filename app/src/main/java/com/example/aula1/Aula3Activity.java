package com.example.aula1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Aula3Activity extends AppCompatActivity {

    private QuizManager quizManager;
    private TextView questionTitle;
    private TextView questions;
    private TextView answer;
    private TextView alternatives;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula3);

        questionTitle = findViewById(R.id.txtQuestionTitle);
        questions = findViewById(R.id.txtQuestions);
        answer = findViewById(R.id.txtResponse);
        alternatives = findViewById(R.id.txtAlternatives);
        Button sendResponse = findViewById(R.id.btnSendResponse);

        quizManager = new QuizManager();
        updateQuestion();

        sendResponse.setOnClickListener(v -> {
            String userAnswer = answer.getText().toString();
            if (quizManager.checkAnswer(userAnswer)) {
                Toast.makeText(this, "Correto!", Toast.LENGTH_SHORT).show();
                correctAnswers++;
            } else {
                Toast.makeText(this, "Incorreta.", Toast.LENGTH_SHORT).show();
                incorrectAnswers++;
            }

            if (quizManager.getCurrentQuestionIndex() < 2) {
                quizManager.nextQuestion();
                updateQuestion();
                Log.d("QuizApp", "Current Question Index: " + quizManager.getCurrentQuestionIndex());
            } else {
                String resultMessage = String.format(
                        "Quiz finalizado!\nVocê acertou: %d\nE errou: %d",
                        correctAnswers, incorrectAnswers
                );

                new AlertDialog.Builder(this)
                        .setTitle("Resultado do Quiz")
                        .setMessage(resultMessage)
                        .setPositiveButton("Jogar Novamente", (dialog, which) -> {
                            // Reiniciar o quiz
                            correctAnswers = 0;
                            incorrectAnswers = 0;
                            quizManager = new QuizManager();
                            updateQuestion();
                        })
                        .setNegativeButton("Sair", (dialog, which) -> {
                            // Encerrar o aplicativo
                            finish();
                        })
                        .show();

                Log.d("QuizApp", "Quiz finalizado");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void updateQuestion() {
        Questions currentQuestion = quizManager.getCurrentQuestion();
        questionTitle.setText("Pergunta:");
        questions.setText(currentQuestion.getQuestionText());
        StringBuilder alternativesText = new StringBuilder();

        for (String alternative : currentQuestion.getIncorrectAnswers()) {
            alternativesText.append(alternative).append("\n");
        }

        alternatives.setText(alternativesText.toString());
    }
}
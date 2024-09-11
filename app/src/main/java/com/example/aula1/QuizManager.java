package com.example.aula1;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por formular e manipular as questões do Quiz.
 * Gerencia uma lista de perguntas e controla o índice da pergunta atual.
 *
 * @see com.example.aula1.Questions
 * @see java.util.List
 */
public class QuizManager {
    private List<Questions> questions;
    private int currentQuestionIndex;

    /**
     * Construtor padrão que inicializa a lista de perguntas e define o índice da pergunta atual.
     * Chama o método loadQuestions para carregar as perguntas iniciais.
     */
    public QuizManager() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        loadQuestions();
    }

    /**
     * Método responsável por carregar as perguntas na lista.
     * Este método cria instâncias da classe Questions, cada uma representando uma pergunta do quiz.
     * Para cada pergunta, são definidos:
     * - O texto da pergunta (questionText)
     * - A resposta correta (correctAnswer)
     * - Uma lista de respostas incorretas (incorrectAnswers)
     * As instâncias criadas são então adicionadas à lista 'questions'.
     *  @see com.example.aula1.Questions
     */
    private void loadQuestions() {
        questions.add(new Questions("Conhecimentos Gerais: Qual é a capital da França?", "Paris", List.of("A) Londres", "B) Berlim", "C) Paris","D) Luxemburgo", "E) Madri")));
        questions.add(new Questions("Matemática: Qual a raiz quadrada de 49?", "7", List.of("A) 12", "B) 5", "C) 8","D) 7","E) 14")));
        questions.add(new Questions("Ciência: Qual o menor planeta do sistema Solar?", "Mercúrio", List.of("A) Mercúrio", "B) Marte", "C) Saturno","D) Vênus","E) Plutão")));
    }

    /**
     * Método responsável por obter a questão atual do quiz.
     * Este método acessa a lista de perguntas e retorna a questão que está
     * atualmente selecionada, com base no índice `currentQuestionIndex`.
     * @return A instância de `Questions` que representa a questão atual na lista `questions`.
     */
    public Questions getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    /**
     * Verifica se a resposta fornecida pelo usuário está correta.
     * Este método acessa a pergunta atual usando `getCurrentQuestion()` e
     * compara a resposta correta com a resposta fornecida pelo usuário.
     * @param userAnswer A resposta fornecida pelo usuário.
     * @return `true` se a resposta do usuário for igual à resposta correta; caso contrário, `false`.
     */
    public boolean checkAnswer(String userAnswer) {
        return getCurrentQuestion().getCorrectAnswer().equals(userAnswer);
    }

    /**
     * Avança para a próxima questão na lista de perguntas.
     * Este método verifica se a questão atual não é a última da lista.
     * Se não for, incrementa o índice da questão atual para apontar para a próxima.
     */
    public void nextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
        }
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }
}

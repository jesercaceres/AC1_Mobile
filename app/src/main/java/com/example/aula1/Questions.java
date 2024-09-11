package com.example.aula1;

import java.util.List;

/**
 * Esta classe é responsável por estruturar e manipular as questões de um Quiz,
 * armazenando o texto da pergunta, a resposta correta e uma lista de respostas incorretas.
 */
public class Questions {
    private String questionText;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    /**
     * Construtor da classe Questions.
     * @param questionText O texto da pergunta.
     * @param correctAnswer A resposta correta para a pergunta.
     * @param incorrectAnswers Uma lista de strings representando as respostas incorretas.
     */
    public Questions(String questionText, String correctAnswer, List<String> incorrectAnswers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    /**
     * Retorna o texto da pergunta.
     * @return O texto da pergunta.
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Retorna a resposta correta.
     * @return A resposta correta.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Retorna a lista de respostas incorretas.
     * @return Uma lista de respostas incorretas.
     */
    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
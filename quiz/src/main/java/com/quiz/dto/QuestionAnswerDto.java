package com.quiz.dto;

import java.util.List;

public class QuestionAnswerDto {
    private String question;

    private Integer questionId;

    private List<AnswerDto> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }

    public static class AnswerDto {
        private Integer answerId;
        private String answer;

        public Integer getAnswerId() {
            return answerId;
        }

        public void setAnswerId(Integer answerId) {
            this.answerId = answerId;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}

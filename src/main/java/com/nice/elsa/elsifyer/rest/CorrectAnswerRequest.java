package com.nice.elsa.elsifyer.rest;

import java.util.Objects;
import java.util.UUID;

public class CorrectAnswerRequest {

    private String question;
    private long answerId;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectAnswerRequest that = (CorrectAnswerRequest) o;
        return answerId == that.answerId &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answerId);
    }
}

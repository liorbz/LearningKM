package com.nice.elsa.elsifyer.impl.service.qna;

import java.io.Serializable;
import java.util.Objects;

public class QnaAnswerRequest implements Serializable {

    private String question;
    private int top;

    public QnaAnswerRequest(String question, int top) {
        this.question = question;
        this.top = top;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QnaAnswerRequest that = (QnaAnswerRequest) o;
        return top == that.top &&
                question.equals(that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, top);
    }
}

package com.nice.elsa.elsifyer.impl.service.qna;

import java.util.List;
import java.util.Objects;

public class QnaAnswerResponse {

    private List<QnaAnswer> answers;

    public List<QnaAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QnaAnswer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QnaAnswerResponse that = (QnaAnswerResponse) o;
        return answers.equals(that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answers);
    }
}

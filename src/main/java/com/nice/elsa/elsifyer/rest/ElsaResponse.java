package com.nice.elsa.elsifyer.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElsaResponse {

    private List<ElsaAnswer> answers = new ArrayList<>();

    public List<ElsaAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ElsaAnswer> answers) {
        this.answers = answers;
    }

    public void addAnswer(ElsaAnswer answer) {
        if (answer != null)
            answers.add(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElsaResponse that = (ElsaResponse) o;
        return answers.equals(that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answers);
    }
}

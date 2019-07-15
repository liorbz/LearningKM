package com.nice.elsa.elsifyer.rest;

import java.util.Objects;
import java.util.UUID;

public class CorrectAnswerRequest {

    private UUID answerId;

    public UUID getAnswerId() {
        return answerId;
    }

    public void setAnswerId(UUID answerId) {
        this.answerId = answerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectAnswerRequest that = (CorrectAnswerRequest) o;
        return answerId.equals(that.answerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId);
    }
}

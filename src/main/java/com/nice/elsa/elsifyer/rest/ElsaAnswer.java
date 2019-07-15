package com.nice.elsa.elsifyer.rest;

import java.util.Objects;
import java.util.UUID;

public class ElsaAnswer {

    private UUID answerId;
    private String text;
    private int rank;

    public ElsaAnswer(UUID answerId, String text, int rank) {
        this.answerId = answerId;
        this.text = text;
        this.rank = rank;
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public void setAnswerId(UUID answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElsaAnswer that = (ElsaAnswer) o;
        return rank == that.rank &&
                answerId.equals(that.answerId) &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId);
    }
}

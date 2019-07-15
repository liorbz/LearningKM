package com.nice.elsa.elsifyer.rest;

import java.util.Objects;
import java.util.UUID;

public class ElsaAnswer {

    private int answerId;
    private String text;
    private double rank;

    public ElsaAnswer(int answerId, String text, double rank) {
        this.answerId = answerId;
        this.text = text;
        this.rank = rank;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElsaAnswer that = (ElsaAnswer) o;
        return answerId == that.answerId &&
                Double.compare(that.rank, rank) == 0 &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId);
    }
}

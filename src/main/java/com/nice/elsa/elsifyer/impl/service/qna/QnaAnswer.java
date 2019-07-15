package com.nice.elsa.elsifyer.impl.service.qna;

import java.util.List;
import java.util.Objects;

public class QnaAnswer {

    private List<String> questions;
    private String answer;
    private double score;
    private int id;
    private String source;
    private List<String> metadata;
    // private Object context;


    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QnaAnswer qnaAnswer = (QnaAnswer) o;
        return Double.compare(qnaAnswer.score, score) == 0 &&
                id == qnaAnswer.id &&
                questions.equals(qnaAnswer.questions) &&
                answer.equals(qnaAnswer.answer) &&
                source.equals(qnaAnswer.source) &&
                metadata.equals(qnaAnswer.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

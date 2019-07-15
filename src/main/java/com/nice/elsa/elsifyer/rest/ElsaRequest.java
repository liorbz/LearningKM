package com.nice.elsa.elsifyer.rest;

import java.util.Objects;
import java.util.UUID;

public class ElsaRequest {

    private UUID agentId;
    private UUID customerId;
    private String questionText;

    public UUID getAgentId() {
        return agentId;
    }

    public void setAgentId(UUID agentId) {
        this.agentId = agentId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElsaRequest that = (ElsaRequest) o;
        return Objects.equals(agentId, that.agentId) &&
                Objects.equals(customerId, that.customerId) &&
                questionText.equals(that.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentId, customerId, questionText);
    }
}

package com.nice.elsa.elsifyer.impl.qnamaker;

public class FeedbackRecordDTO {
    private String userId;
    private String userQuestion;
    private long qnaId;

    public FeedbackRecordDTO(String userId, String userQuestion, long qnaId) {
        this.userId = userId;
        this.userQuestion = userQuestion;
        this.qnaId = qnaId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public long getQnaId() {
        return qnaId;
    }

    public void setQnaId(long qnaId) {
        this.qnaId = qnaId;
    }
}

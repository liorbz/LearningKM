package com.nice.elsa.elsifyer.impl.qnamaker;

import java.util.List;

public class FeedbackDTO {
    private List<FeedbackRecordDTO> feedbackRecords;

    public FeedbackDTO(List<FeedbackRecordDTO> feedbackRecords) {
        this.feedbackRecords = feedbackRecords;
    }

    public List<FeedbackRecordDTO> getFeedbackRecords() {
        return feedbackRecords;
    }

    public void setFeedbackRecords(List<FeedbackRecordDTO> feedbackRecords) {
        this.feedbackRecords = feedbackRecords;
    }
}

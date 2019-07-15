package com.nice.elsa.elsifyer.impl.service;

import com.nice.elsa.elsifyer.impl.service.qna.QnaAnswer;
import com.nice.elsa.elsifyer.impl.service.qna.QnaAnswerResponse;
import com.nice.elsa.elsifyer.impl.service.qna.QnaManager;
import com.nice.elsa.elsifyer.rest.ElsaAnswer;
import com.nice.elsa.elsifyer.rest.ElsaRequest;
import com.nice.elsa.elsifyer.rest.ElsaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElsaServiceImpl implements ElsaService {

    @Autowired
    QnaManager qnaManager;

    @Override
    public ElsaResponse elsify(ElsaRequest request) {

        QnaAnswerResponse ans = qnaManager.generateAnswer(request.getQuestionText());
        return QnaResponseToElsaResponse(ans);
        //return null;
    }

    private ElsaResponse QnaResponseToElsaResponse(QnaAnswerResponse ans) {
        // id, text, rank
        ElsaResponse response = new ElsaResponse();

        if (ans == null || ans.getAnswers() == null || ans.getAnswers().size() == 0) {
            return response;
        }

        for (QnaAnswer answer : ans.getAnswers()) {
            ElsaAnswer eans = new ElsaAnswer(answer.getId(), answer.getAnswer(), answer.getScore());
            response.addAnswer(eans);
        }
        return response;
    }
}

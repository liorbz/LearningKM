package com.nice.elsa.elsifyer.rest;

import com.nice.elsa.elsifyer.impl.qnamaker.ActiveLearning;
import com.nice.elsa.elsifyer.impl.service.ElsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/elsa")
@CrossOrigin(origins = "*")
public class RestController {

    private static final String BARK_EILAM_EMAIL = "be@nice.com";
    private ActiveLearning activeLearning = new ActiveLearning();

//    private ElsaAnswer ans1, ans2, ans3;
//    private ElsaResponse res;

    @Autowired
    ElsaService elsaService;

    @RequestMapping(value = "/elsify", method = RequestMethod.POST)
    public @ResponseBody
    ElsaResponse elsify(@RequestBody ElsaRequest request) {
        //return res;
        System.out.println("Controller question: " + request.getQuestionText());
        return elsaService.elsify(request);
    }

    @RequestMapping(value = "/mark-correct-answer", method = RequestMethod.POST)
    public @ResponseBody
    void markCorrectAnswer(@RequestBody CorrectAnswerRequest request) throws IOException {
        activeLearning.train(BARK_EILAM_EMAIL, request.getQuestion(), request.getAnswerId());
    }

//    @PostConstruct
//    private void init() {
//        ans1 = new ElsaAnswer(UUID.randomUUID(), "This is the answer with the lowest rank", 3);
//        ans2 = new ElsaAnswer(UUID.randomUUID(), "This is the answer with the highest rank", 1);
//        ans3 = new ElsaAnswer(UUID.randomUUID(), "This is the answer with a medium rank", 2);
//        res = new ElsaResponse();
//        res.addAnswer(ans1);
//        res.addAnswer(ans2);
//        res.addAnswer(ans3);
//    }
}

package com.nice.elsa.elsifyer.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Controller
@RequestMapping("/elsa")
@CrossOrigin(origins = "*")
public class RestController {

    ElsaAnswer ans1, ans2, ans3;
    ElsaResponse res;

    @RequestMapping(value = "/elsify", method = RequestMethod.POST)
    public @ResponseBody
    ElsaResponse elsify(@RequestBody ElsaRequest request) {
        return res;
    }

    @RequestMapping(value = "/mark-correct-answer", method = RequestMethod.POST)
    public @ResponseBody
    void markCorrectAnswer(@RequestBody CorrectAnswerRequest request) {

    }

    @PostConstruct
    private void init() {
        ans1 = new ElsaAnswer(UUID.randomUUID(), "This is the answer with the lowest rank", 3);
        ans2 = new ElsaAnswer(UUID.randomUUID(), "This is the answer with the highest rank", 1);
        ans3 = new ElsaAnswer(UUID.randomUUID(), "This is the answer with a medium rank", 2);
        res = new ElsaResponse();
        res.addAnswer(ans1);
        res.addAnswer(ans2);
        res.addAnswer(ans3);
    }
}

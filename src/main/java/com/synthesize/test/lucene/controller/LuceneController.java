package com.synthesize.test.lucene.controller;

import com.synthesize.test.lucene.demo.DemoOne;
import com.synthesize.test.lucene.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/lucene")
public class LuceneController {
    @Autowired
    LuceneService luceneService;
    @RequestMapping("/addDemoOne")
    @ResponseBody
    public void addTest(DemoOne demo){
        luceneService.writer(demo);
    }
    @RequestMapping("/addDemoBatch")
    @ResponseBody
    public void addBatch(List<DemoOne> demoOneList) throws IOException, IllegalAccessException {
        luceneService.writer(demoOneList);
    }
}

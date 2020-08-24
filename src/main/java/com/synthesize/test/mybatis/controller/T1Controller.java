package com.synthesize.test.mybatis.controller;

import com.synthesize.test.mybatis.service.T1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class T1Controller {
    @Autowired
    T1Service t1Service;
}

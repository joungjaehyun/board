package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/layout")
@Log4j2
public class LayoutController {
    
    @GetMapping("/layout")
    public void getLayout(){

        log.info("get layout.....");
    }

}

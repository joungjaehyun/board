package org.zerock.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.RegBoardDTO;
import org.zerock.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void boardList(Model model) {

        // List<BoardDTO> list 선언
        List<BoardDTO> list = boardService.getList();
        model.addAttribute("list", list);

        log.info("boardList............");
    }

    @GetMapping("/read/{bno}")
    public String boardRead(@PathVariable("bno") int bno, Model model) {
        log.info("read...........");
        log.info(bno);

        BoardDTO one = boardService.getOne(bno);

        model.addAttribute("read", one);

        return "/board/read";
    }


    @GetMapping("/registForm")
    public void registForm(){
        log.info("registForm");
        

    }
    @PostMapping("/regist")
    public String regist(
        RegBoardDTO board
    ){
        log.info("regist");
        log.info(board);
        

        return "redirect:/board/list";
    }

}

package org.zerock.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.dto.RegBoardDTO;
import org.zerock.board.dto.UpdateBoardDTO;
import org.zerock.board.service.BoardService;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void boardList(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<BoardDTO> responseDTO 
        = boardService.getList(pageRequestDTO);

        //model.addAttribute("list", responseDTO);
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
        boardService.regOne(board);

        log.info("regist success : " + boardService.regOne(board));
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{bno}")
    public String delete(@PathVariable("bno") int bno){

        boardService.delOne(bno);
        log.info("delete success");

        return "redirect:/board/list";
    }

    @GetMapping("/update/{bno}")
    public String updateGet(@PathVariable("bno") int bno, Model model){

        BoardDTO readData = boardService.getOne(bno);
        log.info(readData);
        log.info("updateForm.....");
        
        model.addAttribute("view", readData);


        return "/board/update";
        
    }

    @PostMapping("/update/{bno}")
    public String update(@PathVariable("bno") int bno,
                        UpdateBoardDTO updateData){
        log.info(updateData);
        boardService.updateOne(updateData);
        log.info("update Success");
        return "redirect:/board/list";
    }


}

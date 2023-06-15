package org.zerock.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImple implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        
        List<BoardDTO> list = boardMapper.select();

        return list;
    }

    @Override
    public BoardDTO getOne(int bno) {
        
        BoardDTO one = boardMapper.selectOne(bno);

        return one;
    }

   
    


}

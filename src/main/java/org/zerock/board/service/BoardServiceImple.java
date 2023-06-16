package org.zerock.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.dto.RegBoardDTO;
import org.zerock.board.dto.UpdateBoardDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
public class BoardServiceImple implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        
        List<BoardDTO> list = boardMapper.select(pageRequestDTO);
        long total = boardMapper.listCount(pageRequestDTO);

        return PageResponseDTO.<BoardDTO>withAll()
        .list(list)
        .totalPage(total)
        .build();
    }

    @Override
    public BoardDTO getOne(int bno) {
        
        BoardDTO one = boardMapper.selectOne(bno);

        return one;
    }

    @Override
    public int regOne(RegBoardDTO regBoardDTO) {
      
        return boardMapper.insert(regBoardDTO);
    }

    @Override
    public int delOne(int bno) {
        
        return boardMapper.delete(bno);
    }

    @Override
    public int updateOne(UpdateBoardDTO updateBoardDTO) {
        
        return boardMapper.update(updateBoardDTO);
    }

   
    


}

package org.zerock.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.dto.RegBoardDTO;
import org.zerock.board.dto.UpdateBoardDTO;

@Transactional
public interface BoardService {
    
    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);

    BoardDTO getOne(int bno);
    int regOne (RegBoardDTO regBoardDTO);
    int delOne (int bno);
    int updateOne (UpdateBoardDTO updateBoardDTO);
}

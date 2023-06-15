package org.zerock.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;

@Transactional
public interface BoardService {
    
    List<BoardDTO> getList();

    BoardDTO getOne(int bno);
}

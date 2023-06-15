package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.RegBoardDTO;
import org.zerock.board.dto.UpdateBoardDTO;

public interface BoardMapper {
    
    List<BoardDTO>select(PageRequestDTO pageRequestDTO);

    long listCount(PageRequestDTO pageRequestDTO);

    BoardDTO selectOne(int bno);

    int insert (RegBoardDTO boardDTO);

    int delete (int bno);

    int update (UpdateBoardDTO boardDTO);
}

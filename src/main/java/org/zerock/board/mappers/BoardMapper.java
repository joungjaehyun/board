package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.UpdateBoardDTO;

public interface BoardMapper {
    
    List<BoardDTO>select();

    BoardDTO selectOne(int bno);

    int insert (BoardDTO boardDTO);

    int delete (int bno);

    int update (UpdateBoardDTO boardDTO);
}

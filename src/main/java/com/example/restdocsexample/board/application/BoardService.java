package com.example.restdocsexample.board.application;

import org.springframework.stereotype.Service;

import com.example.restdocsexample.board.domain.Board;
import com.example.restdocsexample.board.domain.BoardRepository;
import com.example.restdocsexample.board.domain.dto.SaveBoard;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long save(SaveBoard saveBoard) {
        Board board = Board.builder().title(saveBoard.title()).content(saveBoard.content()).build();

        return boardRepository.save(board).getId();
    }

}

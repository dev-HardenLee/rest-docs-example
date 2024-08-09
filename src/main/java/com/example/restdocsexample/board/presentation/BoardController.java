package com.example.restdocsexample.board.presentation;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.restdocsexample.board.application.BoardService;
import com.example.restdocsexample.board.domain.Board;
import com.example.restdocsexample.board.domain.dto.SaveBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Map<String, Long>> saveBoard(@RequestBody SaveBoard saveBoard) {
        Long save = boardService.save(saveBoard);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("id", save));
    }

}

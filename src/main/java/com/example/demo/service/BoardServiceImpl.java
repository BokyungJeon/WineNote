package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    static final Logger log = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.list();
    }

    @Override
    public Board read(Long boardNo) throws Exception {
        log.info("BoardService read(boardNo): " + boardNo);
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        log.info("BoardService remove(boardNo): " + boardNo);
        boardRepository.delete(boardNo);
    }

    @Override
    public void modify(Board board) throws Exception {
        log.info("BoardService modify(board): " + board);
        boardRepository.update(board);
    }
}

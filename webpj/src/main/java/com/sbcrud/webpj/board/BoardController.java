package com.sbcrud.webpj.board;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    //전체 게시물 조회 게시물은 기본 페이징처리 R
    @GetMapping
    public String getAllBoard(Pageable pageable, Model model){
        Page<Board> page = boardRepository.findAll(pageable);
        model.addAttribute("page",page);
        return "board-list";
    }

    //지정된 게시물 리스트수로 조회 R
    @GetMapping("/page/{size}")
    public String getAllPostsWithPageSize(@PathVariable("size") int size, @RequestParam(defaultValue = "0") int page, Model model ){
        Pageable pageable = PageRequest.of(page,size);
        Page<Board> boardPage = boardRepository.findAll(pageable);
        model.addAttribute("page",boardPage);
        model.addAttribute("selectedSize",size);
        return "board-list";
    }


    //게시물 작성페이지 매핑
    @GetMapping("/new")
    public String newBoardForm(Model model){
        model.addAttribute("board",new Board());
        return "board-form";
    }

    //게시물 작성 C
    @PostMapping
    public String createBoard(@ModelAttribute Board board){
        boardRepository.save(board);
        return "redirect:/board";
    }

    //아이디로 조회 R
    @GetMapping("/{id}")
    public String getBoardById(@PathVariable Long id, Model model){
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("board not found with id: "+ id));
        model.addAttribute("board",board);
        return "board-detail";
    }

    //게시물 수정 페이지
    @GetMapping("/{id}/edit")
    public String updateBoardForm(@PathVariable Long id, Model model){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new RuntimeException("board not found with id" + id));
        model.addAttribute("board", board);
        return "board-form";
    }
    //게시물 수정
    @PostMapping("/{id}/edit")
    public String updateBoard(@PathVariable Long id, @ModelAttribute Board boardDetails){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new RuntimeException("board not found id : " + id));
        board.setTitle(boardDetails.getTitle());
        board.setContent(boardDetails.getContent());
        boardRepository.save(board);

        return "redirect:/board/"+id;
    }
    // 게시물 삭제
    @PostMapping("/{id}/delete")
    public String deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return "redirect:/board";
    }

}

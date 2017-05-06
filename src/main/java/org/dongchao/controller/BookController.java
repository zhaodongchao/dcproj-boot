package org.dongchao.controller;

/**
 * Created by zhaodongchao on 2017/5/3.
 */

import org.dongchao.core.model.AuthorInfo;
import org.dongchao.model.Book;
import org.dongchao.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController 相当于 @Controller + @ResponseBody
 * @GetMapping 相当于 @RequestMapping + (method = RequestMethod.GET)
 * @PostMapping 相当于 @RequestMapping + (method = RequestMethod.POST)
 */
@Controller
@RequestMapping("/")
public class BookController {
    private BookRepository bookRepository;
    @Autowired
    private AuthorInfo authorInfo;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 查询
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "book/{id}")
    public String getBooks(@PathVariable(value = "id",required = false) Long id, Model model) {
        List<Book> readingList ;
        if (id == 0){
            readingList = bookRepository.findAll();
        }else{
            readingList = bookRepository.findBooksById(id) ;
        }
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "bookList";
    }

    /**
     * 添加
     * @param id
     * @param book
     * @return
     */
    @PutMapping(value = "book/{id}")
    public String addToReadingList(@PathVariable(value = "id",required = false) Long id , Book book) {
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/book/{id}";
    }

    /**
     * 修改
     * @param book
     * @return
     */
    @PostMapping(value = {"book"})
    public String updateBook(Book book){
        bookRepository.save(book);
     return "redirect:/book/{id}";
    }

    @RequestMapping("author")
    public @ResponseBody String getAuthorInfo() {
        return authorInfo.getDescription();
    }
    @RequestMapping("login")
    public String login(){
        return "login" ;
    }
}

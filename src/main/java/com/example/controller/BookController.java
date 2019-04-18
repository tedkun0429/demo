package com.example.controller;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 *
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookRepository bookRepository;

    /**
     * 查询所有图书
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookList", bookRepository.findAll());
        mav.setViewName("bookList");
        return mav;
    }

    /**
     * 新增图书
     * @param book
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        bookRepository.save(book);
        return "forward:/book/list";
    }

    /**
     * 根据id查询book实体
     * @param id
     * @return
     */
    @RequestMapping(value = "/preModify/{id}")
    public ModelAndView preModify(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", bookRepository.getOne(id));
        mav.setViewName("bookModify");
        return mav;
    }

    /**
     * 修改图书
     * @param book
     * @return
     */
    @PostMapping(value = "/modify")
    public String modify(Book book) {
        bookRepository.save(book);
        return "forward:/book/list";
    }

    @GetMapping(value = "/delete")
    public String delte(Integer id) {
        bookRepository.deleteById(id);
        return "forward:/book/list";
    }
}

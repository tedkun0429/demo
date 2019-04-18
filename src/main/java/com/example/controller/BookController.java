package com.example.controller;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

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

    /**
     * 删除图书
     * @param id
     * @return
     */
    @GetMapping(value = "/delete")
    public String delte(Integer id) {
        bookRepository.deleteById(id);
        return "forward:/book/list";
    }

    /**
     * 自定义查询
     * @return
     */
    @ResponseBody
    @GetMapping("/queryByName")
    public List<Book> queryByName() {
        return bookRepository.findByName("test");
    }

    /**
     * 本地查询
     * @return
     */
    @ResponseBody
    @GetMapping("/randomList")
    public List<Book> randomList() {
        return bookRepository.randomList(2);
    }

    /**
     * 根据条件动态查询
     * @return
     */
    @RequestMapping("/dynamicList")
    public ModelAndView dynamicList(Book book) {
        ModelAndView mav = new ModelAndView();
        List<Book> bookList = bookRepository.findAll(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(book!=null) {
                    if(book.getName()!=null && !"".equals(book.getName())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("name"), "%"+book.getName()+"%"));
                    }
                    if(book.getAuthor()!=null && !"".equals(book.getAuthor())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("author"), "%"+book.getAuthor()+"%"));
                    }
                }
                return predicate;
            }
        });
        mav.addObject("bookList", bookList);
        mav.setViewName("bookList");
        return mav;
    }
}

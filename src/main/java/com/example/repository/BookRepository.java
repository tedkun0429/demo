package com.example.repository;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    /**
     * Hql语言模式
     * @param name
     * @return
     */
    @Query("select b from Book b where b.name like %?1%")
    public List<Book> findByName(String name);

    @Query(value = "select * from book_tbl order by RAND() limit ?1", nativeQuery = true)
    public List<Book> randomList(Integer rows);
}

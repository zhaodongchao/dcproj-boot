package org.dongchao.repository;

import org.dongchao.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhaodongchao on 2017/5/3.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
    List<Book> findBooksById(Long id);
}
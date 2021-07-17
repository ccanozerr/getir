package com.getir.repository;

import com.getir.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Book> findById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Book> findAllById(List<Long> ids);
}

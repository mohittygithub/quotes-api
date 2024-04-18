package com.quotes.repository;

import com.quotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

//    List<Quote> findByAuthorId(Long authorId);

    @Query(value = "SELECT * FROM Quote WHERE Author = ?1", nativeQuery = true)
    List<Quote> findByAuthorNameIgnoreCase(String authorName);
}

package com.quotes.repository;

import com.quotes.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    @Query(value="SELECT * FROM Likes WHERE user_id = :userId AND quote_id = :quoteId", nativeQuery = true)
    Likes findByUserIdAndQuoteId(Long userId, Long quoteId);
}

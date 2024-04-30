package com.quotes.service;

import com.quotes.model.Likes;
import com.quotes.repository.LikeRepository;
import com.quotes.repository.QuoteRepository;
import com.quotes.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final QuoteRepository quoteRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository, QuoteRepository quoteRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.quoteRepository = quoteRepository;
    }

    public void createLike(Long userId, Long quoteId){
        Likes existingLike = likeRepository.findByUserIdAndQuoteId(userId, quoteId);
        System.out.println("existingLike=====> " + existingLike);
        if(existingLike == null){
            Likes newLike = Likes.builder()
                    .user(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found")))
                    .quote(quoteRepository.findById(quoteId).orElseThrow(() -> new RuntimeException("Quote not found")))
                    .build();
            likeRepository.save(newLike);
            System.out.println("saved");
        }else{
            likeRepository.delete(existingLike);
        }
    }
}

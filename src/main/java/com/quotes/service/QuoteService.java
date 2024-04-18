package com.quotes.service;

import com.quotes.model.Quote;
import com.quotes.util.QuoteRequest;
import com.quotes.repository.QuoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote createQuote(QuoteRequest quoteRequest){
        Quote quote =  mapQuoteRequestToQuote(quoteRequest);
        return quoteRepository.save(quote);
    }

    public List<Quote> createQuotes(List<QuoteRequest> quoteRequests){
        List<Quote> quotes = quoteRequests.stream().map(this::mapQuoteRequestToQuote).filter(Objects::nonNull).toList();

        quoteRepository.saveAll(quotes);
        return quotes;
    }

    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }

    public Quote getQuoteById(Long id){
        return quoteRepository.findById(id).orElseThrow(() -> new RuntimeException("No record(s) found"));
    }

//    public List<Quote> getQuotesByAuthorId(Long id){
//        return quoteRepository.findByAuthorId(id);
//    }

    public List<Quote> getQuotesByAuthorName(String authorName){
        return quoteRepository.findByAuthorNameIgnoreCase(authorName);
    }

    private Quote mapQuoteRequestToQuote(QuoteRequest quoteRequest){
        return Quote.builder()
                .content(quoteRequest.content())
                .author(quoteRequest.author())
                .build();
    }
}

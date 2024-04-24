package com.quotes.controller;

import com.quotes.dto.ApiResponse;
import com.quotes.dto.QuoteRequest;
import com.quotes.service.QuoteService;
import com.quotes.util.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;
    private final Utility utility;

    public QuoteController(QuoteService quoteService, Utility utility) {
        this.quoteService = quoteService;
        this.utility = utility;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createQuote(@RequestBody QuoteRequest quoteRequest){
        return new ResponseEntity<>(new ApiResponse(utility.getUrlPath(), 201, true, "", List.of(quoteService.createQuote(quoteRequest))),
                HttpStatus.CREATED);
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse> createQuotes(@RequestBody List<QuoteRequest> quoteRequests){
        return new ResponseEntity<>(new ApiResponse(utility.getUrlPath(),201, true, "", quoteService.createQuotes(quoteRequests)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllQuotes(){
        return new ResponseEntity<>(new ApiResponse(utility.getUrlPath(),200, true, "", quoteService.getAllQuotes()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getQuoteById(@PathVariable Long id){
        return new ResponseEntity<>(new ApiResponse(utility.getUrlPath(),200, true, "", List.of(quoteService.getQuoteById(id))), HttpStatus.OK);
    }

//    @GetMapping("/author/{id}")
//    public ResponseEntity<ApiResponse> getQuotesByAuthorId(@PathVariable Long id){
//        return new ResponseEntity<>(new ApiResponse(200, true, "", List.of(quoteService.getQuotesByAuthorId(id))), HttpStatus.OK);
//    }

    @GetMapping("/author/{name}")
    public ResponseEntity<ApiResponse> getQuotesByAuthorName(@PathVariable String name){
        return new ResponseEntity<>(new ApiResponse(utility.getUrlPath(),200, true, "", quoteService.getQuotesByAuthorName(name)), HttpStatus.OK);
    }
}

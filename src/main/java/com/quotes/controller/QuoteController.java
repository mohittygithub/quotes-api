package com.quotes.controller;

import com.quotes.util.ApiResponse;
import com.quotes.util.QuoteRequest;
import com.quotes.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createQuote(@RequestBody QuoteRequest quoteRequest){
        return new ResponseEntity<>(new ApiResponse(201, true, "", List.of(quoteService.createQuote(quoteRequest))), HttpStatus.CREATED);
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse> createQuotes(@RequestBody List<QuoteRequest> quoteRequests){
        return new ResponseEntity<>(new ApiResponse(201, true, "", quoteService.createQuotes(quoteRequests)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllQuotes(){
        return new ResponseEntity<>(new ApiResponse(200, true, "", quoteService.getAllQuotes()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getQuoteById(@PathVariable Long id){
        return new ResponseEntity<>(new ApiResponse(200, true, "", List.of(quoteService.getQuoteById(id))), HttpStatus.OK);
    }

//    @GetMapping("/author/{id}")
//    public ResponseEntity<ApiResponse> getQuotesByAuthorId(@PathVariable Long id){
//        return new ResponseEntity<>(new ApiResponse(200, true, "", List.of(quoteService.getQuotesByAuthorId(id))), HttpStatus.OK);
//    }

    @GetMapping("/author/{name}")
    public ResponseEntity<ApiResponse> getQuotesByAuthorName(@PathVariable String name){
        return new ResponseEntity<>(new ApiResponse(200, true, "", quoteService.getQuotesByAuthorName(name)), HttpStatus.OK);
    }
}

package com.quotes.dto;

import com.quotes.model.User;

public record QuoteRequest(String content, User author, Long testId) {
}

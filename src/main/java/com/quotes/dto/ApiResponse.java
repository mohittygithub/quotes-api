package com.quotes.dto;

import java.util.List;

public record ApiResponse(String path, int status, boolean success, String message, List<?> results) {
}

package com.quotes.util;

import java.util.List;

public record ApiResponse(int status, boolean success, String message, List<?> results) {
}

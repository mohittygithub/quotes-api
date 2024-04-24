package com.quotes.dto;

public record UserRegisterRequest(String firstName, String lastName, String email, String password) {
}

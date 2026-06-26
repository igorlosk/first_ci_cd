package com.example.first_ci_cd.api;

public record PhoneDto(
        Long id,
        String brandName,
        Integer memory,
        Long price
){
}

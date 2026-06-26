package com.example.first_ci_cd.domain;

public record Phone(
        Long id,
        String brandName,
        Integer memory,
        Long price
) {
}

package com.example.first_ci_cd.domain;

import com.example.first_ci_cd.api.PhoneDto;
import org.springframework.stereotype.Component;

@Component
public class PhoneDtoMapper {

    public PhoneDto toDto(Phone phone) {
        return new PhoneDto(
                phone.id(),
                phone.brandName(),
                phone.memory(),
                phone.price()
        );
    }

    public Phone toDomain(PhoneDto phoneDto) {
        return new Phone(
                phoneDto.id(),
                phoneDto.brandName(),
                phoneDto.memory(),
                phoneDto.price()
        );
    }
}

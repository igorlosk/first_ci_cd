package com.example.first_ci_cd.db;

import com.example.first_ci_cd.domain.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneToEntityMapper {

    public PhoneEntity toEntity(Phone phone) {
        return new PhoneEntity(
                phone.id(),
                phone.brandName(),
                phone.memory(),
                phone.price()
        );
    }

    public Phone toDomain(PhoneEntity phoneEntity) {
        return new Phone(
                phoneEntity.getId(),
                phoneEntity.getBrandName(),
                phoneEntity.getMemory(),
                phoneEntity.getPrice()
        );
    }
}

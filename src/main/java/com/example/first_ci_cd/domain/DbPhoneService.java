package com.example.first_ci_cd.domain;

import com.example.first_ci_cd.api.PhoneDto;
import com.example.first_ci_cd.db.PhoneEntity;
import com.example.first_ci_cd.db.PhoneRepository;
import com.example.first_ci_cd.db.PhoneToEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class DbPhoneService implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneToEntityMapper phoneToEntityMapper;

    public DbPhoneService(
            PhoneRepository phoneRepository,
            PhoneToEntityMapper phoneToEntityMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneToEntityMapper = phoneToEntityMapper;
    }

    @Override
    public Phone createPhone(PhoneDto phoneDto) {
        Phone phone = new Phone(
                null,
                phoneDto.brandName(),
                phoneDto.memory(),
                phoneDto.price()
        );

        return phoneToEntityMapper.toDomain(phoneRepository.save(phoneToEntityMapper.toEntity(phone)));
    }

    @Override
    public Phone updatePhone(PhoneDto phoneDto) {
        return null;
    }

    @Override
    public void deletePhone(Long id) {

    }

    @Override
    public Phone getPhone(Long id) {
        return null;
    }
}

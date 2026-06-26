package com.example.first_ci_cd.domain;

import com.example.first_ci_cd.api.PhoneDto;

public interface PhoneService {

    Phone createPhone(PhoneDto phone);
    Phone updatePhone(PhoneDto phone);
    void deletePhone(Long id);
    Phone getPhone(Long id);

}

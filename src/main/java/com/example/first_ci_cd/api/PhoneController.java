package com.example.first_ci_cd.api;

import com.example.first_ci_cd.domain.Phone;
import com.example.first_ci_cd.domain.PhoneDtoMapper;
import com.example.first_ci_cd.domain.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PhoneController {

    private final PhoneService phoneService;
    private final PhoneDtoMapper phoneDtoMapper;

    public PhoneController(
            PhoneService phoneService,
            PhoneDtoMapper phoneDtoMapper) {
        this.phoneService = phoneService;
        this.phoneDtoMapper = phoneDtoMapper;
    }



    @PostMapping
    public ResponseEntity<PhoneDto> addPhone(
            @RequestBody PhoneDto phoneDto) {
        Phone phone = phoneService.createPhone(phoneDto);
        return ResponseEntity.ok().body(phoneDtoMapper.toDto(phone));
    }
}

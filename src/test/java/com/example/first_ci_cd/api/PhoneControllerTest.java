package com.example.first_ci_cd.api;

import com.example.first_ci_cd.db.PhoneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PhoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    void addPhone_shouldReturnCreatedPhone() throws Exception {
        PhoneDto requestDto = new PhoneDto(1L, "Samsung", 256, 35000L);
        String jsonRequest = new ObjectMapper().writeValueAsString(requestDto);

        MvcResult result = mockMvc.perform(
                post("/api")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("Samsung"))
                .andExpect(jsonPath("$.memory").value(257))
                .andExpect(jsonPath("$.price").value(35000))
                .andReturn();

    }
}
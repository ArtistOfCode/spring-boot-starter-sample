package com.codeartist.component.core.sample.test.controller;

import com.codeartist.component.core.entity.enums.ApiHttpStatus;
import com.codeartist.component.core.support.test.AbstractSpringWebRunnerTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author AiJiangnan
 * @date 2023-12-11
 */
class UserControllerTest extends AbstractSpringWebRunnerTests {

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/exception/client"))
                .andExpect(status().is(ApiHttpStatus.CLIENT_WARNING.getValue()))
                .andExpect(jsonPath("$.code").value(ApiHttpStatus.CLIENT_WARNING.getValue()))
                .andDo(print());
    }

    @Test
    void page() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void getRelation() {
    }

    @Test
    void saveRelation() {
    }
}
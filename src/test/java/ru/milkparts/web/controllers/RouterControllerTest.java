package ru.milkparts.web.controllers;

import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.milkparts.web.services.PageService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RouterController.class)

class RouterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PageService pageService;

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content()
                        .string(containsString("<title>Товары для животноводства, " +
                                "запасные части танков-молокоохладителей, доильных залов</title>")));
    }

    @Test
    public void testFeedbackPage() throws Exception {
        mockMvc.perform(get("/feedback"))
                .andExpect(status().isOk())
                .andExpect(view().name("feedback"))
                .andExpect(content().string(containsString("<title>Обратная связь</title>")));
    }

    @Test
    public void testDeliveryPage() throws Exception {
        mockMvc.perform(get("/delivery"))
                .andExpect(status().isOk())
                .andExpect(view().name("delivery"))
                .andExpect(content().string(containsString("<title>Отправка</title>")));
    }

//    @Test
//    public void test404Page() throws Exception {
//        mockMvc.perform(get("/wrong_path"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("404"))
//                .andExpect(content().string(containsString("<title>ошибка 404</title>")));
//    }
}
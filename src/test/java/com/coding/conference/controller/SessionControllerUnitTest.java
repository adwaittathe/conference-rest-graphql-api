package com.coding.conference.controller;

import com.coding.conference.controllers.SessionsController;
import com.coding.conference.repositories.SessionRepository;
import com.coding.conference.services.SessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(SessionsController.class)
public class SessionControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SessionService sessionService;

    @MockBean
    SessionRepository sessionRepository;

    @Test
    public void getAllSessions() throws Exception
    {
        mockMvc.perform(get("/api/v1/sessions"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(sessionService,times(1)).getAll();
    }
}

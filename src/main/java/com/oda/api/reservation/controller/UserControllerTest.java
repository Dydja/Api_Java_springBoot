package com.oda.api.reservation.controller;
        import static org.hamcrest.CoreMatchers.is;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestClassOrder;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public void UserControllerTest () throws Exception {
        mockMvc.perform(get("/api/v1/users")) //url d'acces
                .andExpect(status().isOk()) //renvoie le status ok en cas de reussite
                .andExpect(jsonPath("$[0].nom", is("Emelie Bergstrom")));
    }

}
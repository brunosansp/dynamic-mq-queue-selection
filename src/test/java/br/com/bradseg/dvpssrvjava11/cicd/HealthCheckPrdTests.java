package br.com.brunosan.gerenciarobjetivo.cicd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@TestPropertySource(properties = { "spring.ci.secrets=PR" })
@AutoConfigureMockMvc
@SpringBootTest
class HealthCheckPrdTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Utils property;

    @Test
    void healthcheckPRD() {
        try {
            mockMvc.perform(get("/ci/healthcheck").contentType("application/json")).andDo(print())
                    .andExpect(status().isOk()).andExpect(content().string(property.getAmbiente()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

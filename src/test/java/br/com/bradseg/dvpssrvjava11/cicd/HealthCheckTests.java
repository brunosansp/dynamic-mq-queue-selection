package br.com.brunosan.gerenciarobjetivo.cicd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class HealthCheckTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Utils property;

    @Test
    void healthcheckCI200() {
        try {
            mockMvc.perform(get("/ci/healthcheck").contentType("application/json")).andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content()
                            .string("{\"nome_aplicacao\": \"" + property.getName() + "\", \"descricao_sistema\": \""
                                    + property.getDescription() + "\", \"versao_sistema\": \"" + property.getVersion()
                                    + "\", \"versao_java\": \"" + property.getJava() + "\", \"ambiente\": \""
                                    + property.getAmbiente() + "\", \"secrets\": \"" + property.getSecrets() + "\"}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void healthcheckCI404() {
        try {
            mockMvc.perform(get("/ci/testeErro").contentType("application/json")).andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

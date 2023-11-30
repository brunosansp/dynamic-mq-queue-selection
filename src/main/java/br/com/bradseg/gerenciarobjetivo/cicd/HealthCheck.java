package br.com.brunosan.gerenciarobjetivo.cicd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthCheck {

    @Autowired
    private Utils property;

    @GetMapping(value="ci/healthcheck", produces="application/json")
    public @ResponseBody String healthcheckCI() {
        if ("PR".equalsIgnoreCase(property.getSecrets())) {
            return property.getAmbiente();
        }

        return "{\"nome_aplicacao\": \"" + property.getName() + "\", \"descricao_sistema\": \""
                + property.getDescription() + "\", \"versao_sistema\": \"" + property.getVersion()
                + "\", \"versao_java\": \"" + property.getJava() + "\", \"ambiente\": \"" + property.getAmbiente()
                + "\", \"secrets\": \"" + property.getSecrets() + "\"}";

    }

}

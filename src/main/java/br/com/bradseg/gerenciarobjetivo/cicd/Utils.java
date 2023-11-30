package br.com.brunosan.gerenciarobjetivo.cicd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    @Value("${spring.application.name:}")
    private String name;

    @Value("${spring.application.version:}")
    private String version;

    @Value("${spring.application.description:}")
    private String description;

    @Value("${spring.application.java:}")
    private String java;

    @Value("${spring.ci.ambiente:}")
    private String ambiente;

    @Value("${spring.ci.secrets:}")
    private String secrets;

    public Utils() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String getJava() {
        return java;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public String getSecrets() {
        return secrets;
    }

}

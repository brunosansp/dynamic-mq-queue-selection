package br.com.brunosan.gerenciarobjetivo.controller;

import br.com.brunosan.gerenciarobjetivo.configs.QueueProperties;
import br.com.brunosan.gerenciarobjetivo.configs.QueuePropertiesProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
    
    private final QueuePropertiesProvider propertiesProvider;
    
    public APIController(QueuePropertiesProvider propertiesProvider) {
        this.propertiesProvider = propertiesProvider;
    }
    
    @GetMapping("/detalhar")
    public QueueProperties detalhar() {
        return propertiesProvider.getQueueProperties("/detalhar");
    }
    
    @GetMapping("/simular")
    public QueueProperties simular() {
        return propertiesProvider.getQueueProperties("/simular");
    }
    
    @GetMapping("/salvar")
    public QueueProperties salvar() {
        return propertiesProvider.getQueueProperties("/salvar");
    }
}
